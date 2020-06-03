#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>
#include <cmath>
#include <cstdlib>
#include <stack>
#include <map>

using namespace std;

long long N;
int P, Q;
map<long long, long long> dp;

long long an(long long n) {
    if(n == 0)
        return 1;
    else if(dp[n] != 0)
        return dp[n];
    dp[n] = an(n / P) + an(n / Q);
    
    return dp[n];
}

int main() {
    cin >> N >> P >> Q;
    
    cout << an(N) << endl;
}
