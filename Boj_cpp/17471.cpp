#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>

#define max 2100000000

using namespace std;

int N;
int people[11];
int arr[11][11];
int ret = max;
//선거구
vector<int> red; vector<bool> redvisited;
vector<int> blue; vector<bool> bluevisited;
int redsum;
int bluesum;

bool desc(int a, int b){
    return a > b;
}

void check(vector<int> vec, vector<bool>& visited, int n) {
    visited[n] = true;
    for(int i = 0; i < visited.size(); i++)
        if(!visited[i] && arr[vec[i]][vec[n]] == 1)
            check(vec, visited, i);
}

int main() {
    scanf("%d", &N);
    for(int i = 1; i <= N; i++)
        scanf("%d", &people[i]);
    
    for(int i = 1; i <= N; i++) {
        int temp;
        scanf("%d", &temp);
        for(int j = 0; j < temp; j++) {
            int pos;
            scanf("%d", &pos);
            arr[i][pos] = 1;
        }
    }
//    for(int i = 1; i <= N; i++) {
//        for(int j = 1; j <= N; j++)
//            cout << arr[i][j] << " ";
//        cout << endl;
//    }
    
    vector<int> idx;
    vector<int> list;
    for(int i = 0; i < N; i++)
        list.push_back(i + 1);
    
    idx.assign(N, 0);
//    idx[0] = 1; idx[1] = 1;
    for(int i = 0; i < N / 2; i++) {
        idx[i] = 1;
        do {
            red.assign(0, 0);
            blue.assign(0, 0);
            redsum = 0; bluesum = 0;
            for(int j = 0; j < N; j++) {
                if(idx[j]) {
                    red.push_back(list[j]);
                    redsum += people[list[j]];
                }
                else {
                    blue.push_back(list[j]);
                    bluesum += people[list[j]];
                }
            }
            redvisited.assign(red.size(), false);
            bluevisited.assign(blue.size(), false);
            check(red, redvisited, 0);
            check(blue, bluevisited, 0);
            
            bool flag = false;
            for(bool b : redvisited)
                if(!b)
                    flag = true;
            for(bool b : bluevisited)
                if(!b)
                    flag = true;
            if(flag == true)
                continue;

//            for(int k : red)
//                cout << k;
//            cout << " ";
//            for(int k : blue)
//                cout << k;
//            cout << endl;
            
            ret = ret > abs(redsum - bluesum) ? abs(redsum - bluesum) : ret;
        }
        while(next_permutation(idx.begin(), idx.end(), desc));
    }
    
    if(ret == max)
        ret = -1;
    cout << ret << endl;
}

//선거구를 나눈다. brute-force
//나눈 선거구가 다 연결이 되는지 확인한다
//연결이 되면 인구수 차이를 비교해서 저장한다
