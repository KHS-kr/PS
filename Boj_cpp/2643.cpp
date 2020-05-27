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

int n, x, y, ret = 1;
vector<pair<int, int>> vec;
int dp[100];

bool compare(pair<int, int> a, pair<int, int> b) {
    if(a.first == b.first)
        return a.second >= b.second;
    return a.first >= b.first;
}

bool range_check(pair<int, int> a, pair<int, int> b) {
    return (a.first >= b.first && a.second >= b.second) ||
    (a.first >= b.second && a.second >= b.first);
}

int main() {
    memset(dp, 0, sizeof(dp));
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> x >> y;
        if(y > x)
            swap(x, y);
        vec.push_back( { x, y } );
    }
    
    sort(vec.begin(), vec.end(), greater<pair<int, int>>());
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < i; j++) {
            if(range_check(vec[j], vec[i]))
                dp[i] = max(dp[i], dp[j]);
        }
        dp[i]++;
    }
    
    for(int i = 0; i < n; i++)
        ret = max(ret, dp[i]);
    
    cout << ret << endl;
}
