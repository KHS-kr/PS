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

struct truck {
    int weight;
    int length;
};

int n, w, L, p = 0, t = 0, sum = 0;
truck arr[1001];
vector<truck> bridge;
bool flag = true;

int main() {
    cin >> n >> w >> L;
    for(int i = 0; i < n; i++) {
        cin >> arr[i].weight;
    }
    
    while(p != n) {
        flag = true;
        if(bridge.empty()) {
            bridge.push_back(arr[p]);
            sum += arr[p].weight;
            p++;
            flag = false;
        }
        
        //length 다 더하기
        for(int i = 0; i < bridge.size(); i++) {
            bridge[i].length++;
        }
        
        if(bridge.front().length > w) {
            sum -= bridge.front().weight;
            bridge.erase(bridge.begin());
        }
        
        if(flag && sum + arr[p].weight <= L) {
            bridge.push_back(arr[p]);
            bridge.back().length++;
            sum += arr[p].weight;
            p++;
        }
        t++;
    }
    
    t += (w - bridge.back().length) + 1;
    
    cout << t << endl;
}
