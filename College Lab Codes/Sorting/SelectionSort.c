#include <stdio.h>
#include <conio.h>

// Here we Assume the min index and then place it properly in it's correct position

void swapElements(int *arr, int min, int i)
{
    int temp = arr[i];
    arr[i] = arr[min];
    arr[min] = temp;
}

void SelectionSort(int *arr , int n)
{
    int minIndex;
    for (int i = 0; i < n - 1; i++)
    {
        minIndex = i;
        for (int j = i + 1; j < n ; j++)
        {
            if (arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        swapElements(arr, minIndex, i);
    }
}


void display(int *arr , int len){
    for(int i=0;i<len;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}


int main(){
    int arr[5]={64,25,12,22,11};
    display(arr,5);
    SelectionSort(arr,5);
    display(arr,5);


    return 0 ;
}