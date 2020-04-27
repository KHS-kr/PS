#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <string>
#define PLUS 0
#define MINUS 1
#define MULTIPLY 2
#define SUBSTITUTE 3

using namespace std;

int N;
int arr[11];
int cal[4];
vector<int> vec;

void find(int n, int c1, int c2, int c3, int c4, int ret) {
    if(n == N) {
        vec.push_back(ret);
        return;
    }
    if(c1 != cal[PLUS]) {
        find(n + 1, c1 + 1, c2, c3, c4, ret + arr[n]);
    }
    if(c2 != cal[MINUS]) {
        find(n + 1, c1, c2 + 1, c3, c4, ret - arr[n]);
    }
    if(c3 != cal[MULTIPLY]) {
        find(n + 1, c1, c2, c3 + 1, c4, ret * arr[n]);
    }
    if(c4 != cal[SUBSTITUTE]) {
        find(n + 1, c1, c2, c3, c4 + 1, ret / arr[n]);
    }
}

int main(void) {
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> arr[i];
    for(int i = 0; i < 4; i++)
        cin >> cal[i];
    
    find(1, 0, 0, 0, 0, arr[0]);
    sort(vec.begin(), vec.end());
    
    cout << vec[vec.size() - 1] << endl;
    cout << vec[0] << endl;
}
