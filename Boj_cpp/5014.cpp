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

int F, S, G, U, D;
bool visited[1000001];

void bfs() {
    priority_queue<pair<int, int>> pq;
    pq.push( { 0, S } );
    visited[S] = true;
    
    while(!pq.empty()) {
        int cur = pq.top().second;
        int cnt = pq.top().first;
        pq.pop();
        
        if(cur == G) {
            cout << cnt << endl;
            return;
        }
        
        int ucur = cur + U;
        if(ucur <= F && !visited[ucur]) {
            pq.push( { cnt + 1, ucur } );
            visited[ucur] = true;
        }
        
        int dcur = cur - D;
        if(dcur >= 1 && !visited[dcur]) {
            pq.push( { cnt + 1, dcur } );
            visited[dcur] = true;
        }
    }
    
    cout << "use the stairs" << endl;
}

int main() {
    cin >> F >> S >> G >> U >> D;
    
    bfs();
}
