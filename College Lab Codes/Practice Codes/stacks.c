#include <stdlib.h>
#include <conio.h>
#include <stdbool.h>
#include <stdio.h>
#define  DEFAULT_SIZE  5

int arr[DEFAULT_SIZE];
int pointer = -1;

bool isEmpty()
{
    return pointer == -1;
}

bool isFull(){
    return pointer==DEFAULT_SIZE-1;
}


bool push(int data){

    if(isFull()){
        return false ;
    }
    //else push the element ;
    arr[++pointer]=data;
}

int pop()
{
    if(isEmpty()){
        return -1;
    }
    // If Not Empty then remove the element 
    return arr[pointer--];
}


int peek (){
    if(isEmpty()){
        return -1;
    }
    // Else 
    return arr[pointer];
}