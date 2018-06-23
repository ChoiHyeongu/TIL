#include <stdio.h>

void printKindOfChick(int brand);
double BHC(int opt, int money); // 1.양념반후라이드반, 2.뿌링클, 3.맛초킹
double BBQ(int opt, int money); // 1.양념반후라이드반, 2.순살크래커, 3.마라핫치킨
double Kyochon(int opt, int money); // 1.양념반후라이드반, 2.허니콤보, 3.교촌라이스
double trasnportaion(int chick, int money);

int main(){

    int brand, money, KindOfChick;
    double trans_money;

    printf("단위를 치킨으로 변경해드립니다!\n\n");
    printf("어느 브랜드 치킨을 원하시나요?\n");

    printf("1.BHC 2.BBQ 3.교촌치킨 : ");
    scanf("%d", &brand);

    printKindOfChick(brand);   
    scanf("%d", &KindOfChick);
    
    printf("금액을 입력하세요 : ");
    scanf("%d", &money);

    switch(brand){

        case 1:
            trans_money = BHC(KindOfChick, money);
            break;
        case 2:
            trans_money = BBQ(KindOfChick, money);
            break;
        case 3:
            trans_money = Kyochon(KindOfChick, money);
            break;
    }

    printf("치킨 %.1lf마리 입니다! \n", trans_money);

    return 0;
}

void printKindOfChick(int brand){

    switch(brand){

        case 1:
            printf("1.양념반후라이드반 2.뿌링클 3.맛초킹 : ");
            break;
        case 2:
            printf("1.양념반후라이드반, 2.순살크래커, 3.마라핫치킨 : ");
            break;
        case 3:
            printf("1.양념반후라이드반, 2.허니콤보, 3.교촌라이스 : ");
            break;
    }
}

double trasnportaion(int chick, int money){

    double trans; //변환 값
    
    trans  = (double)money/(double)chick;
    
    return trans;
}

double BHC(int kindofChick, int money){

    double trasnportaionMoney;

    switch(kindofChick){

        case 1:
            trasnportaionMoney = trasnportaion(16000, money);
            break;
        case 2:
            trasnportaionMoney = trasnportaion(18000, money);
            break;
        case 3:
            trasnportaionMoney = trasnportaion(19000, money);
            break;
    }    

    return trasnportaionMoney;
}

double BBQ(int kindofChick, int money){

    double trasnportaionMoney;

    switch(kindofChick){

        case 1:
            trasnportaionMoney = trasnportaion(16000, money);
            break;
        case 2:
        case 3:
            trasnportaionMoney = trasnportaion(17000, money);
            break;
    }    

    return trasnportaionMoney;
}

double Kyochon(int kindofChick, int money){
    
    double trasnportaionMoney;

    switch(kindofChick){

        case 1:
            trasnportaionMoney = trasnportaion(16000, money);
            break;
        case 2:
            trasnportaionMoney = trasnportaion(17000, money);
            break;
        case 3:
            trasnportaionMoney = trasnportaion(19000, money);
            break;
    }    

    return trasnportaionMoney;
}