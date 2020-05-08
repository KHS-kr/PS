#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>

using namespace std;

bool sosu[10001];
vector<int> vec;
bool visited[10000];
int a, b;

bool bigyo(int a, int b) {
    string aa = to_string(a);
    string bb = to_string(b);
    int count = 0;
    for(int i = 0; i < 4; i++)
        if(aa[i] != bb[i])
            count++;
    if(count != 1)
        return false;
    return true;
}

void bfs() {
    queue<pair<int, int>> q;
    q.push(make_pair(a, 0));
    visited[a] = true;
    
    while(!q.empty()) {
        int n = q.front().first;
        int cnt = q.front().second;
        q.pop();
        if(n == b) {
            cout << cnt << endl;
            return;
        }
        
        for(int i = 0; i < vec.size(); i++) {
            if(!visited[vec[i]] && bigyo(n, vec[i])) {
                visited[vec[i]] = true;
                q.push(make_pair(vec[i], cnt + 1));
            }
        }
    }
    
    cout << "Impossible" << endl;
    return;
}

int main() {
    memset(sosu, true, sizeof(sosu));
    sosu[0] = false;
    sosu[1] = false;
    for(int i = 2; i * i <= 10000; i++) {
        if(sosu[i]) {
            for(int j = i * i; j <= 10000; j += i)
                sosu[j] = false;
        }
    }
    for(int i = 1000; i < 10000; i++)
        if(sosu[i])
            vec.push_back(i);
    int T;
    cin >> T;
    while(T--) {
        memset(visited, false, sizeof(visited));
        cin >> a >> b;
        bfs();
    }
}
