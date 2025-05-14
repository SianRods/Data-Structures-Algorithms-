#include <stdio.h>
#include <conio.h>

void QuadraticHashing(int *arr, int *data, int len, int size, int C1, int C2)
{
    int value;
    int key;
    for (int i = 0; i < len; i++)
    {
        value = data[i];
        ;
        key = value % size;
        if (arr[key] == 0)
        {
            // If the table is empty at given key directyl insert it
            arr[key] = value;
        }
        else
        {
            // Storing the initial value of key as to Compare after probing We find any empty or not
            int startPoint = key;
            int j = 1;
            while (arr[((value % size) + C1*j + C2*j*j)%size] != 0)
            {
                j++;
                if (((value % size) + C1*j + C2*j*j)%size == startPoint)
                {
                    printf("Cannot Find Value for Your Key : %d \n",value);
                    break;
                }
            }
            if(arr[((value % size) + C1*j + C2*j*j)%size]==0){
                arr[((value % size) + C1*j + C2*j*j)%size] = value;
            }
        }
    }
}

void displayHashTable(int *arr, int size)
{
    printf("Hash Table:\n");
    for (int i = 0; i < size; i++)
    {
        printf("Index %d: %d\n", i, arr[i]);
    }
}

int main()
{
    int size = 7;                             // Size of the hash table
    int arr[7] = {0};                         // Initialize hash table with 0 (empty slots)  --> this is important cause on this basis we will be finding empty keys
    int data[] = { 50, 700, 76, 85, 92, 32}; // Data to be inserted
    int len = sizeof(data) / sizeof(data[0]);

    int C1=1;
    int C2=3;

    QuadraticHashing(arr, data, len, size,C1,C2);
    displayHashTable(arr, size);

    return 0;
}