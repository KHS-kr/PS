#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int N, a, b;
int dp[501];
vector<pair<int, int>> vec;

int main() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> a >> b;
        vec.push_back( { a, b } );
    }
    for(int i = 0; i < 501; i++)
        dp[i] = 1;
    
    sort(vec.begin(), vec.end());
    
    for(int i = 1; i < N; i++) {
        for(int j = i; j >= 0; j--) {
            if(vec[i].second > vec[j].second && dp[i] <= dp[j]) {
                dp[i] = dp[j] + 1;
            }
        }
    }
    int ret = 0;
    for(int i = 0; i < N; i++) {
        ret = max(ret, dp[i]);
    }
    
    cout << N - ret << endl;
}
