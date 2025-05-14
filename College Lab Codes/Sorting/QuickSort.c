#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

int partition(int arr[], int start, int end)
{

    int pivot = start;
    int i = start + 1;
    int j = end;
    while (i <= j)
    {
        while (i < end && arr[i] < arr[pivot])
            i++;
        while (j > start && arr[j] >= arr[pivot])
            j--;
        if (i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // Swap j and pivot
    int temp = arr[j];
    arr[j] = arr[pivot];
    arr[pivot] = temp;

    return j;
}

int quicksort(int arr[], int start, int end)
{
    if (start < end)
    {
        int mid = partition(arr, start, end);
        quicksort(arr, start, mid-1);
        quicksort(arr,mid + 1, end);
    }
}



void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int size = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    printArray(arr, size);

    quicksort(arr, 0, size - 1);

    printf("Sorted array: ");
    printArray(arr, size);

    return 0;
}