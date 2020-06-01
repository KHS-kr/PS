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

int N, H, ret = INT_MAX, cnt;
vector<int> top, bottom;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> H;
    
    top.resize(N / 2);
    bottom.resize(N / 2);
    
    for(int i = 0; i < N / 2; i++) {
        cin >> bottom[i] >> top[i];
    }
    
    sort(bottom.begin(), bottom.end());
    sort(top.begin(), top.end());
    
    cnt = 1;
    
    for(int i = 1; i <= H; i++) {
        int temp = bottom.size() - (lower_bound(bottom.begin(), bottom.end(), i) - bottom.begin());
        temp += top.size() - (upper_bound(top.begin(), top.end(), H - i) - top.begin());
        
        if(ret == temp)
            cnt++;
        else if(ret > temp) {
            ret = temp;
            cnt = 1;
        }
    }
    
    cout << ret << " " << cnt << endl;
}
