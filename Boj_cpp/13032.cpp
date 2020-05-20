#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int N, M, a, b;
vector<int> vec[2000];
bool visited[2000];
bool ret;

void dfs(int n, int cnt) {
    if(cnt == 4) {
        ret = true;
        return;
    }
    
    visited[n] = true;
    for(int i = 0; i < vec[n].size(); i++) {
        int next = vec[n][i];
        if(!visited[next])
            dfs(next, cnt + 1);
        if(ret)
            return;
    }
    
    visited[n] = false;
}

int main() {
    cin >> N >> M;
    for(int i = 0; i < M; i++) {
        cin >> a >> b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    
    for(int i = 0; i < N; i++) {
        memset(visited, false, sizeof(visited));
        dfs(i, 0);
        if(ret)
            break;
    }
    
    if(ret)
        cout << 1 << endl;
    else
        cout << 0 << endl;
}
