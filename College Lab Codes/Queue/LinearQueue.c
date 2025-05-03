#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int queue[MAX];
int front = -1;
int rear = -1;

// Function to check if queue is empty
int isEmpty() {
    return front == -1 || front > rear;
}

// Function to check if queue is full
int isFull() {
    return rear == MAX - 1;
}

// Function to add an element to the queue
void enqueue(int value) {
    if (isFull()) {
        printf("Queue is full! Cannot enqueue %d\n", value);
        return;
    }

    if (isEmpty()) {
        front = rear = 0;
    } else {
        rear++;
    }

    queue[rear] = value;
    printf("Enqueued: %d\n", value);
}

// Function to remove an element from the queue
int dequeue() {
    if (isEmpty()) {
        printf("Queue is empty! Cannot dequeue\n");
        return -1;
    }

    int value = queue[front];
    front++;

    if (front > rear) {
        // Reset queue if it's now empty
        front = rear = -1;
    }

    printf("Dequeued: %d\n", value);
    return value;
}

// Function to display the queue
void display() {
    if (isEmpty()) {
        printf("Queue is empty!\n");
        return;
    }

    printf("Queue contents: ");
    for (int i = front; i <= rear; i++) {
        printf("%d ", queue[i]);
    }
    printf("\n");
}

// Main function for testing
int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50); // Queue is full
    enqueue(60); // Should fail

    display();

    dequeue();
    dequeue();

    display();

    enqueue(60); // May still be full in linear queue
    enqueue(70);

    display();

    return 0;
}
