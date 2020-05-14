#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

#define MAX 2100000000

struct node {
    int a;
    int b;
};

int N, M;
int arr[20001];
bool visited[20001];
vector<node> vec;

void bfs() {
    arr[1] = 0;
    queue<pair<int, int>> q;
    q.push({1, 0});
    visited[1] = true;
    
    while(!q.empty()) {
        int x = q.front().first;
        int weight = q.front().second;
        q.pop();
        
        bool flag = false;
        for(int i = 1; i <= N; i++)
            if(!visited[i]) {
                flag = true;
                break;
            }
        
        if(!flag)
            return;
        
        for(int i = 0; i < M; i++) {
            if(vec[i].a == x || vec[i].b == x) {
                int to;
                if(vec[i].a == x)
                    to = vec[i].b;
                else
                    to = vec[i].a;
                if(visited[to])
                    continue;
                q.push( { to, weight + 1 });
                arr[to] = weight + 1;
                visited[to] = true;
            }
        }
    }
}

int main() {
    cin >> N >> M;
    
    for(int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        vec.push_back( { a, b });
    }
    
    bfs();
    
    int max = 0;
    for(int i = 1; i < N; i++)
        if(max < arr[i])
            max = arr[i];
    
    int ret = 0; int count = 0;
    for(int i = 1; i <= N; i++) {
        if(max == arr[i]) {
            if(ret == 0)
                ret = i;
            count++;
        }
    }
    
    cout << ret << " " << max << " " << count << endl;
}
