#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h> // For isalnum necessary imports for checking if it is a alphanumeric normal character

#define SIZE 20

char arr[SIZE];
int pointer = -1;

// Stack Operations
bool isFull() {
    return pointer == SIZE - 1;
}

bool isEmpty() {
    return pointer == -1;
}

char push(char data) {
    if (!isFull()) {
        arr[++pointer] = data;
        return data;
    }
    return -1;
}

char pop() {
    if (!isEmpty()) {
        return arr[pointer--];
    }
    return -1;
}

char peek() {
    if (!isEmpty()) {
        return arr[pointer];
    }
    return '\0';
}

// Operator Precedence
// Note that we are dealing with the brackets seperately in the code 
int precedence(char op) {
    switch (op) {
        case '^': return 3;
        case '*':
        case '/':
        case '%': return 2;
        case '+':
        case '-': return 1;
        default: return 0;
    }
}

// Infix to Postfix Conversion
void InfixToPostFix(char *infix, char *post) {
    int j = 0;
    int len = strlen(infix);

    for (int i = 0; i < len; i++) {
        char ch = infix[i];

        // Directly app to postfix if not operator & is operand 
        if (isalnum(ch)) {
            post[j++] = ch;
        }

        // if opening bracket then push to stack 
        else if (ch == '(') {
            push(ch);
        }

        // If Closing bracket then while stack is empty or we get opening bracket we keep on poping and adding operators to postfix
        else if (ch == ')') {
            while (!isEmpty() && peek() != '(') {
                post[j++] = pop();
            }

            // Discarding the opening bracket when we get it 
            if (!isEmpty() && peek() == '(') {
                pop(); // Discard '('
            }
        }

        // now handling the case of unequal operator precedence 
        else {
            // Operator
            while (!isEmpty() && precedence(peek()) >= precedence(ch) && ch != '^') {
                post[j++] = pop();
            }
            push(ch);
        }
    }

    // Pop any remaining operators
    while (!isEmpty()) {
        post[j++] = pop();
    }

    post[j] = '\0'; // Null-terminate the postfix expression important step in C as it won't recognised as vallid character array 

}

// Utility Function to Display a String
void displayChar(char *sam) {
    for (int i = 0; i < strlen(sam); i++) {
        printf("%c", sam[i]);
    }
    printf("\n");
}

// Main Function
int main() {
    char infix[SIZE] = "(a+b-c)*d-(e+f)";
    char post[SIZE] = {0};  // Initilizing the Post Equation to 0 Initilally 

    InfixToPostFix(infix, post);

    printf("Infix: ");
    displayChar(infix);

    printf("Postfix: ");
    displayChar(post);

    return 0;
}
