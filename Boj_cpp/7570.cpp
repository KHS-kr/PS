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
int arr[1000001];
int dp[1000001];

int main() {
    cin >> N;
    int temp = 0;
    for(int i = 0; i < N; i++)
        cin >> arr[i];
    for(int i = 0; i < N; i++) {
        dp[arr[i]] = dp[arr[i] - 1] + 1;
        temp = max(temp, dp[arr[i]]);
    }

    cout << N - temp << endl;;
}
