#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;
int n, use;
pair<int, int> open;
int arr[21];
int dp[21][21][21];

int moving(int N, int f, int s) {
    if(N > use) return 0;
    if(dp[N][f][s] != -1) return dp[N][f][s];
    return dp[N][f][s] = min(abs(s - arr[N]) + moving(N + 1, f, arr[N]),
                             abs(f - arr[N]) + moving(N + 1, s, arr[N]));
}

int main(void) {
    cin >> n;
    cin >> open.first >> open.second;
    cin >> use;
    for(int i = 1; i <= use; i++)
        cin >> arr[i];
    memset(dp, -1, sizeof(dp));
    
    cout << moving(1, open.first, open.second) << endl;
}
