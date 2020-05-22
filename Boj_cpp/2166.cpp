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

using namespace std;

int N, a, b;
long long S = 0;
vector<pair<long long, long long>> vec;

long long ccw(long long x1, long long x2, long long x3, long long y1, long long y2, long long y3) {
    return (((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)));
}

int main() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> a >> b;
        vec.push_back({a, b});
    }
    
    long long x[3], y[3];
    for(int i = 0; i < 3; i++) {
        x[i] = vec[i].first;
        y[i] = vec[i].second;
    }
    
    S += ccw(x[0], x[1], x[2], y[0], y[1], y[2]);
    
    for(int i = 3; i < N; i++) {
        x[1] = x[2]; y[1] = y[2];
        x[2] = vec[i].first; y[2] = vec[i].second;
        S += ccw(x[0], x[1], x[2], y[0], y[1], y[2]);
    }
    
    printf("%.1lf\n", abs(S / 2.0));
}
