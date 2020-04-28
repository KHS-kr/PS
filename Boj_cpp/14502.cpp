#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;

int N, M;
int arr[8][8];
int temp[8][8];
bool visited[8][8];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int ret = 0;

bool range_check(int a, int b) {
    if(a >= 0 && a < N && b >= 0 && b < M)
        return true;
    return false;
}

void bfs() {
    int after[8][8];
    queue<pair<int, int>> q;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++) {
            after[i][j] = temp[i][j];
            if(after[i][j] == 2)
                q.push(make_pair(i, j));
        }
    
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            
            if(range_check(tx, ty) && after[tx][ty] == 0) {
                after[tx][ty] = 2;
                q.push(make_pair(tx, ty));
            }
        }
    }
    
    int count = 0;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            if(after[i][j] == 0)
                count++;
    ret = max(ret, count);
}

void makeWall(int n) {
    if(n == 3) {
        bfs();
        return;
    }
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(temp[i][j] == 0) {
                temp[i][j] = 1;
                makeWall(n + 1);
                temp[i][j] = 0;
            }
        }
    }
}

int main(void) {
    cin >> N >> M;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            cin >> arr[i][j];
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(arr[i][j] == 0) {
                for(int a = 0; a < N; a++)
                    for(int b = 0; b < M; b++)
                        temp[a][b] = arr[a][b];
                temp[i][j] = 1;
                makeWall(1);
                temp[i][j] = 0;
            }
        }
    }
    
    cout << ret << endl;
}
