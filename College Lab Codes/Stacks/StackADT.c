#include <stdio.h>
#include <stdbool.h>
#include <string.h>


#define SIZE 20

int arr[SIZE];
int pointer = -1;

// Stack Operations
bool isFull() {
    return pointer == SIZE - 1;
}

bool isEmpty() {
    return pointer == -1;
}

int push(int data) {
    if (!isFull()) {
        arr[++pointer] = data;
        return data;
    }
    return -1;
}

int pop() {
    if (!isEmpty()) {
        return arr[pointer--];
    }
    return -1;
}

int peek() {
    if (!isEmpty()) {
        return arr[pointer];
    }
    return -1;
}
