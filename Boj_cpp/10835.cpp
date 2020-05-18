#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int N;
int a[2000];
int b[2000];
int dp[2000][2000];

int score(int l, int r) {
    if(l >= N || r >= N)
        return 0;
    if(dp[l][r] != -1)
        return dp[l][r];
    if(a[l] > b[r]) {
        dp[l][r] = max(dp[l][r], score(l, r + 1) + b[r]);
    }
    dp[l][r] = max(dp[l][r], score(l + 1, r));
    dp[l][r] = max(dp[l][r], score(l + 1, r + 1));
    return dp[l][r];
}

int main() {
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> a[i];
    for(int i = 0; i < N; i++)
        cin >> b[i];
    
    memset(dp, -1, sizeof(dp));
    cout << score(0, 0) << endl;
}
