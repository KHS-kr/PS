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

int T, l, a, b;
pair<int, int> pos;
pair<int, int> dest;
int arr[300][300];
bool visited[300][300];

int dx[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
int dy[8] = {1, -1, 2, -2, 2, -2, 1, -1};

bool range_check(int x, int y) {
    return (x >= 0 && x < l && y >= 0 && y < l);
}

void bfs() {
    queue<pair<int, pair<int, int>>> q;
    q.push( { 0, pos } );
    visited[pos.first][pos.second] = true;
    
    while(!q.empty()) {
        int cnt = q.front().first;
        int x = q.front().second.first;
        int y = q.front().second.second;
        q.pop();
        
        if(x == dest.first && y == dest.second) {
            cout << cnt << endl;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            
            if(range_check(tx, ty) && !visited[tx][ty]) {
                q.push( { cnt + 1, { tx, ty } } );
                visited[tx][ty] = true;
            }
        }
    }
}

int main() {
    cin >> T;
    while(T--) {
        memset(arr, 0, sizeof(arr));
        memset(visited, false, sizeof(visited));
        
        cin >> l;
        cin >> a >> b;
        pos = { a, b };
        cin >> a >> b;
        dest = { a, b };
        
        bfs();
    }
}
