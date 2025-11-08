// Last updated: 08/11/2025, 16:03:54
// (()) 1. ( enter stack , ) exit stack
#define MAX_SIZE 10000
char stack[MAX_SIZE];
int top = -1;

void push(char x){
    if(top==MAX_SIZE-1){
        printf("Stack is full\n");
        return;
    }
    else{
        top++;
        stack[top]=x;
    }
}
char pop(){
    if(top==-1){
        printf("Empty Stack\n");
        return ' ';
    }
    else{
        char temp=stack[top];
        top--;
        return temp;
    }
}
bool isEmpty(){
    if(top==-1)return true;
    else return false;
}
bool isValid(char* s) {
    top=-1;
    int i = 0;

    while (s[i] != '\0') {
        char x = s[i];

        // Opening brackets
        if (x == '(' || x == '{' || x == '[') {
            push(x);
        }
        else if (x == ')' || x == ']' || x == '}') {
            // If stack empty → invalid
            if (isEmpty()) return false;

            char y = pop();

            // Check correct pairs
            if ((x == ')' && y != '(') ||
                (x == ']' && y != '[') ||
                (x == '}' && y != '{')) {
                return false;
            }
        }
        i++;
    }
    
    // Should end with empty stack
    return isEmpty();
}



