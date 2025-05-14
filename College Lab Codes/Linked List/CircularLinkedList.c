#include <stdlib.h>
#include <conio.h>
#include <stdio.h>
#include <stdbool.h>

/*
CODE FOR THE CIRCULAR LINKED LIST
EVERYTHING SAME EXCEPT INSERTION AT START AND END WHERE LAST POINTER / HEAD IS INVOLVED
*/

struct Node
{
    int val;
    // Address of the next pointer
    struct Node *next;
};

// Defining a Global Variable Head for Easier Access
struct Node *head = NULL;

// Function to Check whether a list is Empty or not
bool isEmpty()
{
    return head == NULL;
}

// Creating a Function to create a new node

struct Node *createNewNode(int data)
{

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    // If the Space if NULL assignment Failed Else the Assignment Succeeded

    if (newNode == NULL)
    {
        return NULL;
    }

    // else initialize the internal struct parameters of the created Node
    newNode->val = data;
    newNode->next = NULL;
    return newNode;
}

// Addition at the Beginning
bool insertAtStart(int data)
{
    struct Node *newNode = createNewNode(data);

    if (isEmpty())
    {
        head = newNode;
        return true;
    }

    struct Node *temp = head;

    // creating a temporary variable to point at the last element 
    do
    {
        temp = temp->next;
    } while (temp->next != head);

    // Else insert new
    newNode->next = head;
    head = newNode;
    temp->next=head;

    return true;
}

bool insertAtEnd(int data)
{
    struct Node *newNode = createNewNode(data);

    if (isEmpty())
    {
        head = newNode;
        return true;
    }

    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;

    newNode->next = head;

    return true;
}
