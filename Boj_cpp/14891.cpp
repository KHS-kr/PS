#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;

int arr[4][8];
int K;
vector<pair<int, int>> vec;

void clock(int n) {
    int temp = arr[n][7];
    for(int i = 0; i < 7; i++)
        arr[n][7 - i] = arr[n][6 - i];
    arr[n][0] = temp;
}

void unclock(int n) {
    int temp = arr[n][0];
    for(int i = 0; i < 7; i++)
        arr[n][i] = arr[n][i + 1];
    arr[n][7] = temp;
}

int rotate() {
    int ret = 0;
    for(int i = 0; i < K; i++) {
        int first = vec[i].first;
        int temp = vec[i].second;
        int rotate[4] = {0, }; //1 == 시계, -1 == 반시계
        rotate[first] = temp;
        int prev = first;
        //왼쪽
        while(--prev >= 0) {
            if(arr[prev][2] != arr[prev + 1][6])
                rotate[prev] = rotate[prev + 1] * -1;
            else
                break;
        }
        prev = first;
        while(++prev < 4) {
            if(arr[prev][6] != arr[prev - 1][2])
                rotate[prev] = rotate[prev - 1] * -1;
            else
                break;
        }
        for(int j = 0; j < 4; j++) {
            if(rotate[j] == 1)
                clock(j);
            else if(rotate[j] == -1)
                unclock(j);
        }
    }
    
    int temp = 1;
    for(int i = 0; i < 4; i++) {
        if(arr[i][0] == 1)
            ret += temp;
        temp *= 2;
    }
    
    return ret;
}

int main(void) {
    for(int i = 0; i < 4; i++) {
        char temp;
        for(int j = 0; j < 8; j++) {
            cin >> temp;
            arr[i][j] = temp - '0';
        }
    }
    cin >> K;
    
    for(int i = 0; i < K; i++) {
        int a, b;
        cin >> a >> b;
        vec.push_back(make_pair(a - 1, b));
    }
    
    cout << rotate() << endl;
}
