#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = data;
    // Preassigning it to Null else it will have any random garbage value
    newNode->left = newNode->right = NULL;
    return newNode;
}

void inorderTraversal(struct Node *root)
{
    if (root == NULL){
        return;
    }
    // LEFT VISIT RIGHT
    inorderTraversal(root->left);
    printf("%d ", root->data);
    inorderTraversal(root->right);
}

void preorderTraversal(struct Node *root)
{
    if (root == NULL){
        return;
    }
    //  VISIT LEFT RIGHT
    printf("%d" , root->data);
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

void postorderTraversal(struct Node *root)
{
    if (root == NULL){
        return;
    }
    //   LEFT RIGHT VISIT
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    printf("%d ", root->data);
}

void levelorderTraversal(struct Node *root)
{
    if (root == NULL){
        return;
    }

    struct Node *queue[100];
    int front =0;
    int rear = 0;

    queue[rear++] = root;

    // Repeating the process till the Queue is not Empty
    while (front < rear)
    {
        // dequeing the current node and adding it's children to the queue again
        struct Node *current = queue[front++];

        // printing the data in the current node
        printf("%d ", current->data);

        if (current->left != NULL)
        {
            queue[rear++] = current->left;
        }

        if (current->right != NULL)
        {
            queue[rear++] = current->right;
        }
    }
}


int main() {
    // Create a sample binary tree
    struct Node* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);

    printf("Inorder Traversal: ");
    inorderTraversal(root);
    printf("\n");

    printf("Preorder Traversal: ");
    preorderTraversal(root);
    printf("\n");

    printf("Postorder Traversal: ");
    postorderTraversal(root);
    printf("\n");

    printf("Level Order Traversal: ");
    levelorderTraversal(root);
    printf("\n");

    return 0;
}