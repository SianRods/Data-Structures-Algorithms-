#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *head = NULL; // maintaining a global head pointer
int size = 0;             // Maintaining the size of the LinkedList

struct Node *createNewNode(int val)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        // memory allocation to new Node failed
        return NULL;
    }
    newNode->data = val;
    newNode->next = NULL;
    return newNode;
}

int insertAtStart(int val)
{
    struct Node *newNode = createNewNode(val);
    if (head == NULL)
    {
        head = newNode;
        return head->data;
    }

    newNode->next = head;
    head = newNode;
    return head->data;
}

int insertAtEnd(int val)
{
    struct Node *newNode = createNewNode(val);
    if (head == NULL)
    {
        return insertAtStart(val);
    }

    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;
    return newNode->data;
}

int insertAfterSpecificValue(int target, int val)
{
    struct Node *newNode = createNewNode(val);
    struct Node *temp = head;

    while (temp->data != target && temp->next != NULL)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    return newNode->data;
}

int insertBeforeSpecificValue(int target, int val)
{
    struct Node *newNode = createNewNode(val);
    struct Node *temp = head;

    while (temp->next != NULL && temp->next->data != target)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    return newNode->data;
}

int removeFromStart()
{
    // Check if Empty then only proceed to remove the ehad
    if (head == NULL)
    {
        return -1;
    }

    head = head->next;
}

int removeFromEnd()
{
    // Assuming that the list is not empty
    struct Node *temp = head;

    while (temp->next->next != NULL)
    {
        temp = temp->next;
    }

    free(temp->next);
    temp->next = NULL;
    return 0;
}

int deleteNodeBeforeValue(int target)
{
    struct Node *t1;
    struct Node *t2 = head;
    // Assuming that the list is not empty

    while (t2->next != NULL && t2->next->data != target)
    {
        t1 = t2;
        t2 = t2->next;
    }

    t1->next = t2->next;
    free(t2);
    return 0;
}

int deleteNodeAfterValue(int target)
{
    struct Node *t1;
    struct Node *t2 = head;
    // Assuming that the list is not empty

    while (t1->data != target && t2->next != NULL)
    {
        t1 = t2;
        t2 = t2->next;
    }

    t1->next = t2->next;
    free(t2);
    return 0;
}

bool searchValueInList(int val)
{

    struct Node *temp = head;
    if (head == NULL)
    {
        return false;
    }

    while (temp->data != val && temp != NULL)
    {
        temp = temp->next;
    }

    if (temp == NULL)
    {
        return false;
    }

    return true;
}

void display(struct Node *head)
{
    struct Node *temp = head;

    while (temp != NULL)
    {
        printf("%d-->", temp->data);
        temp = temp->next;
    }
    printf("END\n");
}

// This Method will be used to return a new head of the list which will have the reveresed list in order

struct Node *reverseLinkedList()
{

    struct Node *current = head;
    struct Node *prev = NULL;
    struct Node *next = NULL;

    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    return prev;
}

// Merging of Two Sorted Lists into a New One
void mergeTwoSortedLists(struct Node *head1, struct Node *head2)
{
    // Creating a new list to add both the merged lists
    struct Node *t1 = head1;
    struct Node *t2 = head2;

    while (t1 != NULL || t2 != NULL)
    {
        if (t1->data >= t2->data)
        {
            insertAtStart(t2->data);
            t2 = t2->next;
        }
        else
        {
            insertAtStart(t1->data);
            t1 = t1->next;
        }
    }

    // At last adding the lists which are pending 
    while(t1!=null){
        insertAtEnd(t1->data);
        t1=t1->next;
    }

    while(t2!=null){
        insertAtEnd(t2->data);
        t2=t2->next;
    }

}


void sortALinkedList(){
    // Using Arrays 
}



int main()
{
    insertAtStart(3);
    insertAtStart(2);
    insertAtStart(1);
    insertAtEnd(4);
    insertAtEnd(5);
    insertAfterSpecificValue(3, 6);
    insertBeforeSpecificValue(5, 10);
    deleteNodeAfterValue(3);
    deleteNodeBeforeValue(5);

    printf("%d", searchValueInList(2));
    display(head);
    display(reverseLinkedList());
}
