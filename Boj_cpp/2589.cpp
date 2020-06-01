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

struct treasure {
    int x, y;
    int time;
    
    bool operator < (const treasure& other) const {
        return time > other.time;
    }
};

int L, W, ret = 0;
char arr[50][50];
bool visited[50][50];
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };

bool range_check(int i, int j) {
    return i >= 0 && i < L && j >= 0 && j < W && arr[i][j] != 'W' && !visited[i][j];
}

int bfs(int a, int b) {
    priority_queue<treasure> q;
    int length = 0;
    q.push( { a, b, 0 });
    visited[a][b] = true;
    
    while(!q.empty()) {
        int x = q.top().x;
        int y = q.top().y;
        int time = q.top().time;
        length = time;
        q.pop();
        
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            
            if(range_check(tx, ty)) {
                q.push( { tx, ty, time + 1 } );
                visited[tx][ty] = true;
            }
        }
    }
    
    return length;
}

int main() {
    cin >> L >> W;
    
    for(int i = 0; i < L; i++)
        for(int j = 0; j < W; j++)
            cin >> arr[i][j];
    
    for(int i = 0; i < L; i++) {
        for(int j = 0; j < W; j++) {
            if(arr[i][j] == 'W')
                continue;
            memset(visited, false, sizeof(visited));
            ret = max(ret, bfs(i, j));
        }
    }
    
    cout << ret << endl;
}
