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

int N, K;
bool visited[100001];

int bfs() {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; //시간, 위치
    pq.push( { 0, N } );
    visited[N] = true;
    
    while(!pq.empty()) {
        int time = pq.top().first;
        int pos = pq.top().second;
        pq.pop();
        
        if(pos == K)
            return time;
        
        if(pos * 2 < 100001 && !visited[pos * 2]) {
            pq.push( { time, pos * 2 } );
            visited[pos * 2] = true;
        }
        
        if(pos > 0 && !visited[pos - 1]) {
            pq.push( { time + 1, pos - 1 } );
            visited[pos - 1] = true;
        }
        if(pos < 100000 && !visited[pos + 1]) {
            pq.push( { time + 1, pos + 1 } );
            visited[pos + 1] = true;
        }
    }
    
    return 0;
}

int main() {
    cin >> N >> K;
    
    if(N > K) {
        cout << N - K << endl;
        return 0;
    }
    
    cout << bfs() << endl;
}
