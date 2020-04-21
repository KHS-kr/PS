#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

bool sosu[1000001];
vector<int> arr;

int main() {
    int input = 1;
    while(input) {
        scanf("%d", &input);
        arr.push_back(input);
    }
    arr.pop_back();
    
    for(int i = 2; i <= 1000000; i++)
        sosu[i] = true;
    
    for(int i = 2; i * i <= 1000000; i++) {
        if(sosu[i])
            for(int j = i * i; j <= 1000000; j += i)
                sosu[j] = false;
    }

    for(int i : arr) {
        bool flag = false;
        for(int j = 2; j <= 1000000; j++) {
            if(j > i)
                break;
            if(sosu[j] && sosu[abs(i - j)]) {
                printf("%d = %d + %d\n", i, j, i - j);
                flag = true;
                break;
            }
        }
        if(!flag)
            printf("Goldbach's conjecture is wrong.");
    }
}
