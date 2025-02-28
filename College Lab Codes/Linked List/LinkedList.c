#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Node *head = NULL;

struct Node
{
    int val;
    struct Node *next;
};

// Creating a Function for allocating Memory to the new Node
struct Node *createNode(int data)
{

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        printf("Memry Allocation Failed ");
        return NULL;
    }

    // NOTE THAT IN C BY DEFAULT VALUE IS GARBAGE VALUE IN CASE OF JAVA IT IS NULL VALUE

    newNode->val = data;
    newNode->next = NULL;
    return newNode;
}

bool isEmpty()
{
    // simple equality check of the head with NULL
    return head == NULL;
}

int insertAtStart(int data)
{

    struct Node *newNode = createNode(data);
    if (isEmpty())
    {
        head = newNode;
        return newNode->val;
    }
    else
    {
        newNode->next = head;
        head = newNode;
        return newNode->val;
    }
    return -1;
}

int insertAtEnd(int data)
{
    struct Node *newNode = createNode(data);

    // CHECKING IF THE LIST IS EMPTY
    if (isEmpty())
    {
        head = newNode;
        return newNode->val;
    }

    struct Node *temp = head;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;
    return newNode->val;
}

int insertAfterSpecificValue(int val, int target)
{
    struct Node * newNode = createNode(val);

    if(isEmpty()){
        insertAtStart(val);
        return -1;
    }   

    struct Node * temp =head;

    while(temp->val!=target){
        temp=temp->next;
    }

    newNode->next=temp->next;
    temp->next=newNode;
    #include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Node *head;

struct Node
{
    int val;
    struct Node *next;
};

// Creating a Function for allocating Memory to the new Node
struct Node *createNode(int data)
{

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        printf("Memry Allocation Failed ");
        return NULL;
    }

    // NOTE THAT IN C BY DEFAULT VALUE IS GARBAGE VALUE IN CASE OF JAVA IT IS NULL VALUE

    newNode->val = data;
    newNode->next = NULL;
    return newNode;
}

bool isEmpty()
{
    // simple equality check of the head with NULL
    return head == NULL;
}

int insertAtStart(int data)
{

    struct Node *newNode = createNode(data);
    if (isEmpty())
    {
        head = newNode;
        return newNode->val;
    }
    else
    {
        newNode->next = head;
        head = newNode;
        return newNode->val;
    }
    return -1;
}

int insertAtEnd(int data)
{
    struct Node *newNode = createNode(data);

    // CHECKING IF THE LIST IS EMPTY
    if (isEmpty())
    {
        head = newNode;
        return newNode->val;
    }

    struct Node *temp = head;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;
    return newNode->val;
}

int insertAfterSpecificValue(int val, int target)
{
    struct Node * newNode = createNode(val);

    if(isEmpty()){
        insertAtStart(val);
        return -1;
    }   

    struct Node * temp =head;

    while(temp->val!=target){
        temp=temp->next;
    }

    newNode->next=temp->next;
    temp->next=newNode;
    
    return newNode->val;
}


int insertBeforeSpecificValue(int val, int target)
{
    struct Node *newNode = createNode(val);

    if (isEmpty())
    {
        printf("List is empty.\n");
        return -1;
    }

    if (head->val == target)
    {
        newNode->next = head;
        head = newNode;
        return newNode->val;
    }

    struct Node *temp = head;
    while (temp->next != NULL && temp->next->val != target)
    {
        temp = temp->next;
    }

    if (temp->next == NULL)
    {
        printf("Target value not found.\n");
        return -1;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    return newNode->val;
}

void deleteStartNode()
{
    if (isEmpty())
    {
        printf("List is empty.\n");
        return;
    }

    struct Node *temp = head;
    head = head->next;
    free(temp);
}

void deleteEndNode()
{
    if (isEmpty())
    {
        printf("List is empty.\n");
        return;
    }

    if (head->next == NULL)
    {
        free(head);
        head = NULL;
        return;
    }

    struct Node *temp = head;
    while (temp->next->next != NULL)
    {
        temp = temp->next;
    }

    free(temp->next);
    temp->next = NULL;
}

void deleteNodeBeforeValue(int target)
{
    if (isEmpty() || head->next == NULL)
    {
        printf("List is empty or has only one node.\n");
        return;
    }

    if (head->next->val == target)
    {
        deleteStartNode();
        return;
    }

    struct Node *temp = head;
    while (temp->next->next != NULL && temp->next->next->val != target)
    {
        temp = temp->next;
    }

    if (temp->next->next == NULL)
    {
        printf("Target value not found.\n");
        return;
    }

    struct Node *nodeToDelete = temp->next;
    temp->next = temp->next->next;
    free(nodeToDelete);
}

void deleteNodeAfterValue(int target)
{
    if (isEmpty() || head->next == NULL)
    {
        printf("List is empty or has only one node.\n");
        return;
    }

    struct Node *temp = head;
    while (temp != NULL && temp->val != target)
    {
        temp = temp->next;
    }

    if (temp == NULL || temp->next == NULL)
    {
        printf("Target value not found or no node after target.\n");
        return;
    }

    struct Node *nodeToDelete = temp->next;
    temp->next = temp->next->next;
    free(nodeToDelete);
}

void display()
{
    struct Node *temp = head;

    // HERE THE END CONDITION WILL BE WHEN TEMP == NULL AS IF WE SET TEMP->NEXT == NULL
    // THEN THE LAST NODE WON'T BE PRINTED
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
    int choice, value, target;

    while (1)
    {
        printf("\nMenu:\n");
        printf("1. Insert at Start\n");
        printf("2. Insert at End\n");
        printf("3. Insert After Specific Value\n");
        printf("4. Insert Before Specific Value\n");
        printf("5. Delete Start Node\n");
        printf("6. Delete End Node\n");
        printf("7. Delete Node Before Specific Value\n");
        printf("8. Delete Node After Specific Value\n");
        printf("9. Display List\n");
        printf("10. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            printf("Enter value to insert at start: ");
            scanf("%d", &value);
            insertAtStart(value);
            break;
        case 2:
            printf("Enter value to insert at end: ");
            scanf("%d", &value);
            insertAtEnd(value);
            break;
        case 3:
            printf("Enter value to insert: ");
            scanf("%d", &value);
            printf("Enter target value after which to insert: ");
            scanf("%d", &target);
            insertAfterSpecificValue(value, target);
            break;
        case 4:
            printf("Enter value to insert: ");
            scanf("%d", &value);
            printf("Enter target value before which to insert: ");
            scanf("%d", &target);
            insertBeforeSpecificValue(value, target);
            break;
        case 5:
            deleteStartNode();
            break;
        case 6:
            deleteEndNode();
            break;
        case 7:
            printf("Enter target value before which to delete: ");
            scanf("%d", &target);
            deleteNodeBeforeValue(target);
            break;
        case 8:
            printf("Enter target value after which to delete: ");
            scanf("%d", &target);
            deleteNodeAfterValue(target);
            break;
        case 9:
            display();
            break;
        case 10:
            exit(0);
        default:
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
    return newNode->val;
}


int insertBeforeSpecificValue(int val, int target)
{
    struct Node *newNode = createNode(val);

    if (isEmpty())
    {
        printf("List is empty.\n");
        return -1;
    }

    if (head->val == target)
    {
        newNode->next = head;
        head = newNode;
        return newNode->val;
    }

    struct Node *temp = head;
    while (temp->next != NULL && temp->next->val != target)
    {
        temp = temp->next;
    }

    if (temp->next == NULL)
    {
        printf("Target value not found.\n");
        return -1;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    return newNode->val;
}

void deleteStartNode()
{
    if (isEmpty())
    {
        printf("List is empty.\n");
        return;
    }

    struct Node *temp = head;
    head = head->next;
    free(temp);
}

void deleteEndNode()
{
    if (isEmpty())
    {
        printf("List is empty.\n");
        return;
    }

    if (head->next == NULL)
    {
        free(head);
        head = NULL;
        return;
    }

    struct Node *temp = head;
    while (temp->next->next != NULL)
    {
        temp = temp->next;
    }

    free(temp->next);
    temp->next = NULL;
}

void deleteNodeBeforeValue(int target)
{
    if (isEmpty() || head->next == NULL)
    {
        printf("List is empty or has only one node.\n");
        return;
    }

    if (head->next->val == target)
    {
        deleteStartNode();
        return;
    }

    struct Node *temp = head;
    while (temp->next->next != NULL && temp->next->next->val != target)
    {
        temp = temp->next;
    }

    if (temp->next->next == NULL)
    {
        printf("Target value not found.\n");
        return;
    }

    struct Node *nodeToDelete = temp->next;
    temp->next = temp->next->next;
    free(nodeToDelete);
}

void deleteNodeAfterValue(int target)
{
    if (isEmpty() || head->next == NULL)
    {
        printf("List is empty or has only one node.\n");
        return;
    }

    struct Node *temp = head;
    while (temp != NULL && temp->val != target)
    {
        temp = temp->next;
    }

    if (temp == NULL || temp->next == NULL)
    {
        printf("Target value not found or no node after target.\n");
        return;
    }

    struct Node *nodeToDelete = temp->next;
    temp->next = temp->next->next;
    free(nodeToDelete);
}

void display()
{
    struct Node *temp = head;

    // HERE THE END CONDITION WILL BE WHEN TEMP == NULL AS IF WE SET TEMP->NEXT == NULL
    // THEN THE LAST NODE WON'T BE PRINTED
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
    int choice, value, target;

    while (1)
    {
        printf("\nMenu:\n");
        printf("1. Insert at Start\n");
        printf("2. Insert at End\n");
        printf("3. Insert After Specific Value\n");
        printf("4. Insert Before Specific Value\n");
        printf("5. Delete Start Node\n");
        printf("6. Delete End Node\n");
        printf("7. Delete Node Before Specific Value\n");
        printf("8. Delete Node After Specific Value\n");
        printf("9. Display List\n");
        printf("10. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            printf("Enter value to insert at start: ");
            scanf("%d", &value);
            insertAtStart(value);
            break;
        case 2:
            printf("Enter value to insert at end: ");
            scanf("%d", &value);
            insertAtEnd(value);
            break;
        case 3:
            printf("Enter value to insert: ");
            scanf("%d", &value);
            printf("Enter target value after which to insert: ");
            scanf("%d", &target);
            insertAfterSpecificValue(value, target);
            break;
        case 4:
            printf("Enter value to insert: ");
            scanf("%d", &value);
            printf("Enter target value before which to insert: ");
            scanf("%d", &target);
            insertBeforeSpecificValue(value, target);
            break;
        case 5:
            deleteStartNode();
            break;
        case 6:
            deleteEndNode();
            break;
        case 7:
            printf("Enter target value before which to delete: ");
            scanf("%d", &target);
            deleteNodeBeforeValue(target);
            break;
        case 8:
            printf("Enter target value after which to delete: ");
            scanf("%d", &target);
            deleteNodeAfterValue(target);
            break;
        case 9:
            display();
            break;
        case 10:
            exit(0);
        default:
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}