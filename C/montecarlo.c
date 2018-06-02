#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){

    unsigned int n;
    int cnt = 0, circle = 0;
    double x, y, pi;
    

    printf("던질 횟수 : ");
    scanf("%d",&n);

    srand(time(NULL));

    for(int i = 0; i < n; i++){
        x = (double)rand() / (double)RAND_MAX;
        y = (double)rand() / (double)RAND_MAX;
        cnt++;

        if((x*x)+(y*y) <= 1) 
            circle++;
    }

    pi = (double)(4 * circle) / (double)cnt;
    printf("%lf\n",pi);

    return 0;
}   