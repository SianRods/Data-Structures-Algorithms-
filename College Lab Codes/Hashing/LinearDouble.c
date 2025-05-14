#include <stdio.h>
#include <conio.h>



void LinearHashing(int *arr, int *data, int len, int size)
{
    // H(x) = value % size
    // Here we are storing all the data from an array data into hash table arr
    int value = 0;
    int key = 0;
    for (int i = 0; i < len; i++)
    {
        value = data[i];
        key = value % size;
        if (arr[key] == 0)
        {
            // Location is empty  and the value can be stored in the key position
            arr[key] = value;
        }
        else
        {
            // if the location is not empty we keep on probing
            int j = 1;
            int startPoint = key;
            while (arr[(value + j) % size] != 0)
            {
                j++;
                // if reaches the intial point again then break the loop
                if ((value + j) % size == startPoint)
                {
                    printf("Hash table is full. Cannot insert value: %d\n", value);
                    break;
                }
            }

            // Checking if the linear probing has Actually Found any Empty Key
            if (arr[(key + j) % size] == 0)
            {
                arr[(key + j) % size] = value;
            }
        }
    }
}




void DoubleHashing(int *arr, int *data, int len, int size, int PRIME)
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
            while (arr[(value % size) + j * (PRIME - (value % PRIME))] != 0)
            {
                j++;
                if ((value % size) + j * (PRIME - (value % PRIME)) == startPoint)
                {
                    printf("Cannot Find Value for Your Key ");
                    break;
                }
            }
            if(arr[(value % size) + j * (PRIME - (value % PRIME))]==0){
                arr[(value % size) + j * (PRIME - (value % PRIME))]=value;
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
    int size = 10;                             // Size of the hash table
    int arr[10] = {0};                         // Initialize hash table with 0 (empty slots)  --> this is important cause on this basis we will be finding empty keys
    int data[] = {23, 43, 13, 27, 87, 33, 77}; // Data to be inserted
    int len = sizeof(data) / sizeof(data[0]);

    LinearHashing(arr, data, len, size);
    displayHashTable(arr, size);


    // Testing the Double Hashing 
    int sample[7]={4371, 1323, 6173, 4199, 4344, 9679, 1989};
    int arr2[10]={0};
    int len2 = sizeof(sample)/sizeof(sample[0]);
    DoubleHashing(arr2,sample,len2,10,7);
    displayHashTable(arr2,10);

    return 0;
}