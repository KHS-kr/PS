#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;

int N, M;
//int arr[10001][10001] = { 0, };
vector<pair<int, int>> vec[10001];
int visited[10001];
int x, y; // 공장

bool bfs(int n) {
    queue<int> q;
    q.push(x);
    visited[x] = true;
    
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        
        if(cur == y)
            return true;
        
//        for(int i = 1; i <= N; i++) {
//            if(arr[cur][i] == 0 || visited[i])
//                continue;
//            int temp = i;
//            int weight = arr[cur][i];
//            if(weight >= n) {
//                visited[temp] = true;
//                q.push(temp);
//            }
//        }
        for(int i = 0; i < vec[cur].size(); i++) {
            int temp = vec[cur][i].first;
            int weight = vec[cur][i].second;
            
            if(!visited[temp] && n <= weight) {
                visited[temp] = true;
                q.push(temp);
            }
        }
    }
    
    return false;
}

int main(void) {
    int l = 0, r = 0;
    
    cin >> N >> M;
    for(int i = 0; i < M; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        vec[a].push_back(make_pair(b, c));
        vec[b].push_back(make_pair(a, c));
        r = max(r, c);
//        arr[a][b] = max(arr[a][b], c);
//        arr[b][a] = arr[a][b];
//        r = max(r, arr[a][b]);
    }
    cin >> x >> y;
    
    while(l <= r) {
        int mid = (l + r) / 2;
        
        memset(visited, false, sizeof(visited));
        if(bfs(mid))
            l = mid + 1;
        else
            r = mid - 1;
    }
    
    cout << r << endl;
}
