#include <stdio.h>

int main(){

    int num = 10;
    int *ptr1 = &num;
    int *ptr2;
    *ptr1 = *ptr1*2;
     ptr2=ptr1;

    printf("ptr1 = %d | ptr2 = %d | num = %d", *ptr1, *ptr2, *num);
}