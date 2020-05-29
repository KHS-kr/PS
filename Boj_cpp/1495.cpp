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

using namespace std;

int N, S, M;
int arr[101];
bool dp[101][1001]; // i번째 곡을 j의 볼륨으로 연주할수 있으면 true

int main() {
    cin >> N >> S >> M;
    for(int i = 1; i <= N; i++)
        cin >> arr[i];
    
    dp[0][S] = true;
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j <= M; j++) {
            if(!dp[i][j])
                continue;
            if(j - arr[i + 1] >= 0)
                dp[i + 1][j - arr[i + 1]] = true;
            if(j + arr[i + 1] <= M)
                dp[i + 1][j + arr[i + 1]] = true;
        }
    }
    
    for(int i = M; i >= 0; i--)
        if(dp[N][i]) {
            cout << i << endl;
            return 0;
        }
    
    cout << -1 << endl;
}
