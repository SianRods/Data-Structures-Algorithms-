# Priority Queue and Building Max Heap (Brief Notes)

## 1. What is a Priority Queue?

A **Priority Queue** is an abstract data structure where each element has a priority, and elements are served based on priority rather than insertion order.

### Types

* **Max Priority Queue** → highest priority element is removed first
* **Min Priority Queue** → lowest priority element is removed first

### Implementation

Priority queues are commonly implemented using **heaps**:

* Max Heap → Max Priority Queue
* Min Heap → Min Priority Queue

---

## 2. Basic Operations

| Operation | Description           | Time Complexity |
| --------- | --------------------- | --------------- |
| Insert    | Add element           | O(log n)        |
| Delete    | Remove highest/lowest | O(log n)        |
| Peek      | Get top element       | O(1)            |

---

## 3. Java Implementation (Using Built-in PriorityQueue)

### Min Heap (Default)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(10);
pq.add(5);
pq.add(20);

System.out.println(pq.poll()); // 5
```

### Max Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
pq.add(10);
pq.add(5);
pq.add(20);

System.out.println(pq.poll()); // 20
```

---

## 4. Converting Unsorted Array into Max Heap

This process is called **Heap Construction (Build Heap)**.

### Key Idea

* Start from last non-leaf node
* Apply heapify moving upwards

### Formula

* Last non-leaf index = `n/2 - 1`

---

## 5. Algorithm

```text
for i = n/2 - 1 down to 0:
    heapify(arr, n, i)
```

---

## 6. Example

### Input Array

```
[4, 10, 3, 5, 1]
```

### After Building Max Heap

```
[10, 5, 3, 4, 1]
```

### Tree Representation

```
        10
       /  \
      5    3
     / \
    4   1
```

---

## 7. Heapify Function

```java
static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        heapify(arr, n, largest);
    }
}
```

---

## 8. Time Complexity

* Build Max Heap → **O(n)**
* Heapify → **O(log n)**

---

## 9. Key Takeaways

* Priority Queue is implemented using heaps
* Max Heap gives highest priority element first
* Build Heap is more efficient than inserting elements one by one
* Heap construction runs in linear time O(n)

