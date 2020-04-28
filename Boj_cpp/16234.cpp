#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;

int N, L, R;
int arr[51][51];
bool visited[51][51];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void bfs(int a, int b) {
//    cout << "a : " << a << ", b : " << b << endl;
//    for(int i = 1; i <= N; i++) {
//        for(int j = 1; j <= N; j++)
//            cout << arr[i][j] << " ";
//        cout << endl;
//    }
    queue<pair<int, int>> q, input;
    q.push(make_pair(a, b));
    input.push(make_pair(a, b));
    visited[b][a] = true;
    int sum = 0;
    int cnt = 0;
    
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        
        sum += arr[y][x];
        cnt++;
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            
            if(tx < 1 || tx > N || ty < 1 || ty > N)
                continue;
            if(visited[ty][tx])
                continue;
            if(abs(arr[y][x] - arr[ty][tx]) >= L && abs(arr[y][x] - arr[ty][tx]) <= R) {
                visited[ty][tx] = true;
                q.push(make_pair(tx, ty));
                input.push(make_pair(tx, ty));
            }
        }
    }
    
    int temp = sum / cnt;
    
    if(input.size() > 1)
        while(!input.empty()) {
            int x = input.front().first;
            int y = input.front().second;
            input.pop();
            arr[y][x] = temp;
        }
}

//이동할 수 있는지
bool check(int x, int y) {
    for(int i = 0; i < 4; i++) {
        int tx = x + dx[i];
        int ty = y + dy[i];
        if(tx > 0 && tx <= N && ty > 0 && ty <= N) {
            if(abs(arr[y][x] - arr[ty][tx]) >= L && abs(arr[y][x] - arr[ty][tx]) <= R)
                return true;
        }
    }
    return false;
}

int main(void) {
    cin >> N >> L >> R;
    for(int i = 1; i <= N; i++)
        for(int j = 1; j <= N; j++)
            cin >> arr[i][j];
    
    bool flag = true;
    int day = 0;
    while(flag) {
        flag = false;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[j][i] && check(i, j)) {
                    bfs(i, j);
                    flag = true;
                }
            }
        }
        
        if(flag) day++;
        memset(visited, false, sizeof(visited));
    }
    
    cout << day << endl;
}
