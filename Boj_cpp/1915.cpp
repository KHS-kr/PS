#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int n, m, ret;
char temp;
int arr[1000][1000];
int dp[1000][1000];

int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++) {
            cin >> temp;
            arr[i][j] = temp - '0';
            if(arr[i][j] == 1) {
                dp[i][j] = 1;
                ret = 1;
            }
            else
                dp[i][j] = 0;
        }
    
    for(int i = 1; i < n; i++) {
        for(int j = 1; j < m; j++) {
            if(arr[i - 1][j - 1] == 1 && arr[i - 1][j] == 1 && arr[i][j - 1] == 1) {
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] = min(dp[i][j], dp[i][j - 1]) + 1;
            }
            ret = max(ret, dp[i][j]);
        }
    }
    
    cout << ret * ret << endl;
}
