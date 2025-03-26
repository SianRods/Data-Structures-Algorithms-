#include <stdio.h>
#include <conio.h>
#include <stdbool.h>
#include <stdlib.h>

// Creating a Structure for the Node
struct Node
{
    int val;
    struct Node *next; //  Memory Location of the Next Node
};

struct Node *head = NULL;
// Creating newNode by allcoation memory to it using malloc(sizeof(struct Node *))
int size = 0;

// Check the return type of the createNewNode properly
struct Node *createNewNode(int val)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        return NULL;
    }

    // Assigning the Value to the newNode created and the next of the create Node  to NULL
    newNode->val = val;
    newNode->next = NULL;
    return newNode;
}

int insertAtStart(int val)
{
    struct Node *newNode = createNewNode(val);
    if (head == NULL)
    {
        head = newNode;
        size++;
        return head->val;
    }
    newNode->next = head;
    head = newNode;
    size++;
    // Return the value of newly inserted head
    return head->val;
}

int insertAtEnd(int val)
{
    struct Node *newNode = createNewNode(val);
    if (head == NULL)
    {
        // if the list is empty insert at start
        head = newNode;
        size++;
        return head->val;
    }

    // else traverse till the end
    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    // Insert at the last postion
    temp->next = newNode;
    size++;
    return newNode->val;
}

int insertAfterValue(int val, int target)
{
    struct Node *newNode = createNewNode(val);

    if (head == NULL)
    {
        insertAtStart(val);
        return newNode->val;
    }

    // traverse till the
    struct Node *temp = head;
    while (temp->val != target && temp != NULL)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    size++;
    return newNode->val;
}

int insertBeforeValue(int val, int target)
{
    struct Node *newNode = createNewNode(val);

    if (head == NULL)
    {
        insertAtStart(val);
        return newNode->val;
    }
    // HERE WE NEED SLOW AND FAST POINTERS

    struct Node *t1 = NULL;
    struct Node *temp = head;

    while (temp->val != target && temp != NULL)
    {
        t1 = temp;
        temp = temp->next;
    }
    newNode->next = t1->next;
    t1->next = newNode;
    size++;
    return newNode->val;
}

bool deleteAtStart()
{
    if (size == 0)
    {
        return false;
    }

    else if (size == 1)
    {
        free(head);
        size--;
        return true;
    }

    // Shift head pointer ahead by one
    head = head->next;
    size--;
    // Do we need to free the temp variable ??
    return true;
}

int deleteAtEnd()
{
    if (size == 0)
    {
        return false;
    }

    struct Node *temp = head;
    while (temp->next->next != NULL)
    {
        temp = temp->next;
    }

    free(temp->next);
    temp->next = NULL;
    size--;
    return true;
}

bool deleteAfter(int target)
{
    if (size == 0)
    {
        return false;
    }

    struct Node *fast = head;
    struct Node *slow;
    while (slow->val != target && fast->next != NULL)
    {
        slow = fast;
        fast = fast->next;
    }

    slow->next = fast->next;
    size--;
    free(fast);

    return true;
}

int deleteBefore(int target)
{
    if (size == 0)
    {
        return false;
    }

    struct Node *fast = head;
    struct Node *slow;
    while (fast->next != NULL && fast->next->val != target)
    {
        slow = fast;
        fast = fast->next;
    }

    // fast points to the target variable data

    slow->next = fast->next;
    free(fast);
    size--;
    return true;
}

int deleteSpecificValue()
{
}

// Program to reverse a linked list given it's head
struct Node *reverseLinkedList(struct Node *head)
{

    struct Node *current = head;
    struct Node *prev = NULL;
    struct Node *next = NULL;

    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        // Updating the prev to new Current
        // At the end of the loop the prev Node will be the new head Node of the Linked List
        // As it was updated to current before the loop breaks
        prev = current;
        current = next;
    }

    return prev;
}

void display()
{
    struct Node *temp = head;
    while (temp != NULL)
    {
        printf("%d -->", temp->val);
        temp = temp->next;
    }
    printf("END");
    printf("\n");
}

int main()
{

    // Testing all the Functions
    insertAtStart(10);
    insertAtStart(123);
    insertAtStart(23);
    display();
    insertAtEnd(94);
    display();
    insertAfterValue(32, 123);
    display();
    insertBeforeValue(45, 10);
    display();
    deleteAtStart();
    display();
    deleteAtEnd();
    display();
    deleteAfter(32);
    display();
    deleteBefore(10);
    display();
    return 1;
}