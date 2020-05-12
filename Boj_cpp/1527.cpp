#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int A, B;
int ret = 0;

void geumMinSoo(long long n) {
    if(n > B)
        return;
    
    if(A <= n && n <= B)
        ret++;
    
    geumMinSoo(n * 10 + 4);
    geumMinSoo(n * 10 + 7);
}

int main() {
    cin >> A >> B;
    
    geumMinSoo(4);
    geumMinSoo(7);
    
    cout << ret << endl;
}
