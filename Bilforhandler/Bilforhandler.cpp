#include<iostream>
using namespace std;

void BuyCar(int* pnr, int* pbuy){

wcout << L"Enter nr:";
wcin >> *pnr;
wcout << L"Enter price:";
wcin >> *pbuy;
}

void SellCar(int*pnr, int*psell){
    wcout<<L"Enter carnumber: ";
    wcin>>*pnr;
    wcout<<L"Enter sellprice: ";
    wcin>>*psell;
}

void TotalProfit(int* buyprice, int* sellprice, int n){ //int n er antall biler i listene (lengden på listene)
    int profit=0;
   
    for(int i=0; i<n; i++){
        profit += (sellprice[i]>0)? (sellprice[i]-buyprice[i]):0;
    }
    wcout<<L"Total profit on sales: " <<profit << endl;
}

void ListCars(int* pnr, int* pbuy, int n){
for (int i=0; i < n; i++)
wcout << L"Carnr: " << *(pnr+i) << L" Price: " << *(pbuy+i) << endl;
}

void CleanUpList(int* pnr, int* pbuy, int* psell, int& idx){
    for(int i=0; i<idx;){
        if(psell[i]>0){
            //da skal vi fjerne bilen som er solgt, det kan vi gjøre ved å flytte alle de resterende bilene i arrayen til høyre
            for(int j=0; j<idx-1; j++){
                pnr[j]=pnr[j+1];
                pbuy[j]=pbuy[j+1];
                psell[j]=psell[j+1];
            }
            //huske å redusere antallet bilder
            idx--;
        }
        else{ //hvis ikke bilen har salgspris over 0 hopper vi videre i arrayen til neste solgte bil
            i++; 
        }
    }
}

int main(){
int carnr[1000];
int buyprice[1000];
int sellprice[1000];
int choice = 0;
int idx = 0;

do{
wcout << endl << L"List of choices" << endl;
wcout << L"1 Buy a car" << endl;
wcout << L"2 Sell a car" << endl;
wcout << L"3 Find the profit" << endl;
wcout << L"4 List all the cars" << endl;
wcout << L"5 Cleanup list (remove sold cars)" << endl;
wcout << L"0 Quit" << endl;
wcin >> choice;

switch (choice){
int nr, buy, sell;
case 1: BuyCar(&nr, &buy);
carnr[idx] = nr;
buyprice[idx] = buy;
sellprice[idx] = 0;
idx++;
break;
case 2: SellCar(&nr, &sell);
carnr[idx]=nr;
sellprice[idx]=sell;
buyprice[idx]=0;
idx--;
break;
case 3: TotalProfit(&buy, &sell, nr);
break;
case 4: ListCars(carnr, buyprice, idx);
break;
case 5: CleanUpList(&nr, &buy, &sell, idx);
}
} 
while (choice != 0);
return 0;
}


