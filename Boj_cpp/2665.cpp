#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

struct node {
    pair<int, int> xy;
    int cnt;
};

struct cmp {
    bool operator()(node a, node b) {
        return a.cnt > b.cnt;
    }
};

int arr[51][51];
bool visited[51][51];
int n;
priority_queue<node, vector<node>, cmp> pq;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int bfs() {
    node temp;
    temp.xy = make_pair(1, 1);
    temp.cnt = 0;
    pq.push(temp);
    visited[1][1] = true;
    
    while(!pq.empty()) {
        pair<int, int> xy = pq.top().xy;
        int count = pq.top().cnt;
        pq.pop();
        
        if(xy.first == n && xy.second == n)
            return count;
        
        for(int i = 0; i < 4; i++) {
            int tx = xy.first + dx[i];
            int ty = xy.second + dy[i];
            
            if(tx < 1 || tx > n || ty < 1 || ty > n || visited[ty][tx])
                continue;
            
            visited[ty][tx] = true;
            node input;
            input.xy = make_pair(tx, ty);
            
            if(arr[ty][tx] == 0)
                input.cnt = count + 1;
            else
                input.cnt = count;
            pq.push(input);
        }
    }
    
    return 0;
}

int main() {
    cin >> n;
    for(int i = 1; i <= n; i++) {
        char temp;
        for(int j = 1; j <= n; j++) {
            cin >> temp;
            arr[i][j] = temp - '0';
        }
    }
    
    cout << bfs() << endl;
}
