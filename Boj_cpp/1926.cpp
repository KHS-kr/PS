#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int n, m;
int arr[500][500];
bool visited[500][500];
int cnt = 0, ret = 0;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int bfs(int a, int b) {
    int r = 0;
    queue<pair<int, int>> q;
    visited[a][b] = true;
    q.push({a, b});
    r++;
    
    while(!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();
        
        for(int i = 0; i < 4; i++) {
            int ta = a + dx[i];
            int tb = b + dy[i];
            
            if(ta < 0 || ta >= n || tb < 0 || tb >= m || visited[ta][tb] || arr[ta][tb] == 0)
                continue;
            q.push({ta, tb});
            visited[ta][tb] = true;
            r++;
        }
    }
    
    return r;
}

int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            cin >> arr[i][j];
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++)
            if(arr[i][j] != 0 && !visited[i][j]) {
                int temp = bfs(i, j);
                cnt++;
                if(ret < temp)
                    ret = temp;
            }
    }
    
    cout << cnt << endl;
    cout << ret << endl;
}
