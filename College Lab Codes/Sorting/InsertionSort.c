#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

void InsertionSort(int *arr, int n)
{
    for (int i = 1; i < n; i++)
    {
        int j = i - 1;

        int value = arr[i];
        // Searching for the correct postition in the sorted part for every element
        while (j >= 0 && arr[j] > value)
        {
            // Shifting the Elements in the array
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = value;
    }
}

void display(int *arr, int len)
{
    for (int i = 0; i < len; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main()
{
    int arr[5] = {64, 25, 12, 22, 11};
    display(arr, 5);
    InsertionSort(arr, 5);
    display(arr, 5);

    return 0;
}