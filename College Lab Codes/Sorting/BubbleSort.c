#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void swapElements(int *arr, int min, int i)
{
    int temp = arr[i];
    arr[i] = arr[min];
    arr[min] = temp;
}

void BubbleSort(int *arr, int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        bool flag = false;

        // Restricting our Search Space as with every iteration last part of the array is sorted
        for (int j = 0; j < n - 1 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swapElements(arr, j, j + 1);
                flag = true;
            }
        }

        if (!flag)
        {
            break;
        }
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
    BubbleSort(arr, 5);
    display(arr, 5);

    return 0;
}