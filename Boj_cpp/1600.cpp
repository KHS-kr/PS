#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

struct node {
    pair<int, int> xy;
    int cnt;
    int k;
};

struct cmp {
    bool operator()(node a, node b) {
        return a.cnt > b.cnt;
    }
};

int K, W, H;
int arr[200][200];
bool visited[200][200][30];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
//int dx[2] = {1, 0};
//int dy[2] = {0, 1};
//말
int hx[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
int hy[8] = {-1, 1, -2, 2, -2, 2, -1, 1};
//int hx[2] = {1, 2};
//int hy[2] = {2, 1};
priority_queue<node, vector<node>, cmp> pq;

int bfs() {
    node temp = { make_pair(0, 0), 0, 0 };
    pq.push(temp);
    
    while(!pq.empty()) {
        int x = pq.top().xy.first;
        int y = pq.top().xy.second;
        int cnt = pq.top().cnt;
        int k = pq.top().k;
        pq.pop();
        
        if(x == W - 1 && y == H - 1)
            return cnt;

        if(k < K) {
            for(int i = 0; i < 8; i++) {
                int tx = x + hx[i];
                int ty = y + hy[i];
                int tcnt = cnt + 1;
                int tk = k + 1;
                
                if(tx < 0 || tx >= W || ty < 0 || ty >= H || arr[ty][tx] != 0 || visited[ty][tx][tk])
                    continue;
                node input = { make_pair(tx, ty), tcnt, tk };
                visited[ty][tx][tk] = true;
                pq.push(input);
            }
        }
        
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            int tcnt = cnt + 1;
            int tk = k;
            
            if(tx < 0 || tx >= W || ty < 0 || ty >= H || arr[ty][tx] != 0 || visited[ty][tx][tk])
                continue;
            node input = { make_pair(tx, ty), tcnt, tk };
            visited[ty][tx][tk] = true;
            pq.push(input);
        }
    }
    
    return -1;
}

int main() {
    cin >> K;
    cin >> W >> H;
    
    for(int i = 0; i < H; i++)
        for(int j = 0; j < W; j++)
            cin >> arr[i][j];
    
    cout << bfs() << endl;
}
