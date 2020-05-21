#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int M, N, x, y;
int a, b;
bool flag = false;

int gcd(int a, int b) {
    while(b != 0) {
        int t = a % b;
        a = b;
        b = t;
    }
    return a;
}

int main() {
    int T;
    cin >> T;
    
    while(T--) {
        cin >> M >> N >> x >> y;
        a = x; b = y;
        flag = false;
        int end = M * N / gcd(M, N);
        while(a != b) {
            if(end < a || end < b) {
                flag = true;
                break;
            }
            if(a > b)
                b += N;
            else
                a += M;
        }
        if(flag)
            cout << -1 << endl;
        else
            cout << a << endl;
    }
}
