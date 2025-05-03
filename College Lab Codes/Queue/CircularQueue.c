#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int queue[MAX];
int front = -1;
int rear = -1;

// Function to check if queue is empty
int isEmpty() {
    return front == -1;
}

// Function to check if queue is full
int isFull() {
    return (rear + 1) % MAX == front;
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
        rear = (rear + 1) % MAX;
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

    // Storing the value to be returned before changing the front operator
    int value = queue[front];

    if (front == rear) {
        // Only one element was present
        front = rear = -1;
    } else {
        front = (front + 1) % MAX;
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
    int i = front;
    while (1) {
        printf("%d ", queue[i]);
        if (i == rear) break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}

// Main function for testing
int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50); // Should fill the queue
    enqueue(60); // Should say "Queue is full"

    display();

    dequeue();
    dequeue();

    display();

    enqueue(60);
    enqueue(70); // Should wrap around

    display();

    return 0;
}
