#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>

using namespace std;

int N, S;
vector<int> brother;

int gcd(int a, int b) {
    int c;
    while(b != 0) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main() {
    cin >> N >> S;
    for(int i = 0; i < N; i++) {
        int temp;
        cin >> temp;
        brother.push_back(abs(temp - S));
    }
    if(brother.size() == 1)
        cout << brother[0] << endl;
    else {
        int ret = gcd(brother[0], brother[1]);
        for(int i = 2; i < N; i++)
            ret = gcd(ret, brother[i]);
        cout << ret << endl;
    }
}


/*
 48 24 24
 */
