public class SegmentTree {

    Node root;

    
    public class Node {
        int data;
        int startIndex;
        int endIndex;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.startIndex = start;
            this.endIndex = end;
        }

        public Node(int value) {
            this.data = value;
        }
    }

    // @Constructor of the tree will be used to create the new tree()
    public SegmentTree(int arr[]) {
        // Note that the time Complexity to create the tree will be O(N)
        // As we will have to traverse each and every element of the array and insert
        // those

        this.root = ConstructTree(arr, 0, arr.length - 1);
    }

    private Node ConstructTree(int arr[], int start, int end) {
        // If Start == end then we have reached the leaf Node
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // If the start!=end then we have to keep growing the tree more By creating a
        // Node and assigning the value of it's left and right part
        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = ConstructTree(arr, start, mid);
        node.right = ConstructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;

        // Return the newly updated Node in the segment tree
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startIndex + "-" + node.left.endIndex + "] and data: "
                    + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startIndex + "-" + node.endIndex + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startIndex + "-" + node.right.endIndex + "] and data: "
                    + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    // Function to Query Data From the Segment Trees ==> to Retreive a Value from
    // the Segment trees
    // qsi ==> Query Start Index
    // qei ==> Query End Index
    public int query(int qsi, int qei) {
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        // There are mainly Three cases of finding our index element at a particular
        // interval
        // 1] The interval of the node completely overlaps the search interval ==>
        // return that value
        // 2] Non overlapping part exists ==> Go on digging (i.e) reducing the interval
        // till it becomes completely overlapping then return that value
        // 3] The index which is being queried completely lies out of bounds ==> Return
        // 0 cause then we don't have to consider that range

        if (node.startIndex >= qsi && node.endIndex <= qei) {
            // case of completely overlapping of the range query ==> so return the value
            return node.data;
        }

        else if (node.startIndex > qei || node.endIndex < qsi) {
            // Complete Nonoverlaping condition here
            return 0;
        } else {
            // If partial Overlapping case we try to bring it under bounds and return that
            // value
            // and return the sum of the chunks of this parts under the query range

            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }

    }

    // Funtion to update the values inside of a Segment Tree
    // The whole trick behind updating the values inside of a Segement Trees is
    // understanding
    // That the value of the index to be updated will always occurs in unique Nodes
    // So there will be a unique path which will be ultimately be followed in order
    // to update the values

    public void update(int index, int data) {
        // The update function will return the root's data of the tree with all the
        // updated values
        // Which lie in the path of the main index leaf node of the segment tree;

        this.root.data = update(root, index, data);
    }

    private int update(Node node, int index, int data) {
        // Check if the node is in the actual path down towards the leaf node
        if (index >= node.startIndex && index < node.endIndex) {
            if (node.startIndex == index && node.endIndex == index) {
                node.data = data;
                return node.data;
            } else {
                // Collect the answer from the left and right part of the given node and
                // accordingly
                // update the data value of this node
                int leftAns = update(node.left, index, data);
                int rightAns = update(node.right, index, data);
                node.data = leftAns + rightAns;
                return node.data;
            }
        } else {
            // Returning the data of the node itself without changing anypart
            return node.data;
        }

    }

}
