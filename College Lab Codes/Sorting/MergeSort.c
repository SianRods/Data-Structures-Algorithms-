#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

void Merge(int arr[], int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftArray[n1];
    int rightArray[n2];

    for (int i = 0; i < n1; i++)
    {
        leftArray[i] = arr[left + i];
    }

    for (int i = 0; i < n2; i++)
    {
        rightArray[i] = arr[(mid + 1) + i];
    }

    int i = 0;
    int j = 0;
     int k = left;

    while (i < n1 && j < n2)
    {
        if (leftArray[i] < rightArray[j])
        {
            arr[k] = leftArray[i];
            i++;
        }
        else
        {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    // Adding the array which are still not empty yet
    while (i < n1)
    {
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < n2)
    {
        arr[k] = rightArray[j];
        j++;
        k++;
    }
}

void MergeSort(int arr[], int left, int right)
{
    if (left < right)
    {
        int mid = (left + right) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        Merge(arr, left, mid, right);
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

    MergeSort(arr, 0, size - 1);

    printf("Sorted array: ");
    printArray(arr, size);

    return 0;
}