#include <stdio.h>

int bhc(int opt, int money); // 1.양념반후라이드반, 2.뿌링클, 3.맛초킹
int bbq(int opt, int money); // 1.양념반후라이드반, 2.순살크래커, 3.마라핫치킨
int kyochon(int opt, int money); // 1.양념반후라이드반, 2.허니콤보, 3.교촌라이스
int trasnportaion(int chick, int money);

int main(){

    int opt, money, trans_money;

    printf("단위를 치킨으로 변경해드립니다!\n");
    printf("1.BHC 2.BBQ 3.교촌치킨\n");
    scanf("%d", &opt);
    printf("1.양념반후라이드반 2.뿌링클 3.맛초킹");
    scanf("%d", &opt);
    printf("금액을 입력하세요 : ");
    scanf("%d", &money);
    
    trans_money = bhc(opt ,money);

    printf("치킨%d마리 입니다!", trans_money);

    return 0;
}

int bhc(int opt, int money){

   int trans;

    switch (opt) {

        case 1:
            trans = trasnportaion(16000, money);
            break;
    }

    return trans;
}

int trasnportaion(int chick, int money){

    int quotient, remainder; //몫, 나머지
    int trans; //변환 값
    
    quotient = money/chick;
    remainder = money%chick;

    trans = (remainder >= 0) ? quotient + 1 : quotient;

    return trans;
}