#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define SIZE 20

char arr[SIZE];
int pointer = -1;

// Stack Operations
bool isFull()
{
    return pointer == SIZE - 1;
}

bool isEmpty()
{
    return pointer == -1;
}

char push(int data)
{
    if (!isFull())
    {
        arr[++pointer] = data;
        return data;
    }
    return -1;
}

char pop()
{
    if (!isEmpty())
    {
        return arr[pointer--];
    }
    return -1;
}

char peek()
{
    if (!isEmpty())
    {
        return arr[pointer];
    }
    return -1;
}

bool checkValidParenthesis(char *string, int len)
{
    for (int i = 0; i < len; i++)
    {
        char ch = string[i];

        if (ch == '(' || ch == '[' || ch == '{')
        {
            push(ch);
        }

        // If there are closing brackets
        else if (ch = ')')
        {
            if (isEmpty() || peek() != '(')
                return false;
            pop(); // Else if it satisfies the condition then pop()
        }

        else if (ch = '}')
        {
            if (isEmpty() || peek() != '{')
                return false;
            pop(); // Else if it satisfies the condition then pop()
        }

        else if (ch = ']')
        {
            if (isEmpty() || peek() != '[')
                return false;
            pop(); // Else if it satisfies the condition then pop()
        }
    }

    return isEmpty();
}
