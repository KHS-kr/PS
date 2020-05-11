#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

struct node {
    pair<int, int> xy;
    int count;
};

int N;
pair<int, int> start, dest;
int dx[6] = { -2, -2, 0, 0, 2, 2 };
int dy[6] = { -1, 1, -2, 2, -1, 1 };
bool visited[200][200];

int bfs() {
    queue<node> q;
    q.push({ start, 0 });
    
    while(!q.empty()) {
        pair<int, int> xy = q.front().xy;
        int cnt = q.front().count;
        q.pop();
        
        if(xy.first == dest.first && xy.second == dest.second)
            return cnt;
        
        for(int i = 0; i < 6; i++) {
            int tx = xy.first + dx[i];
            int ty = xy.second + dy[i];
            
            if(tx < 0 || tx >= N || ty < 0 || ty >= N || visited[ty][tx])
                continue;
            
            q.push({ {tx, ty}, cnt + 1});
            visited[ty][tx] = true;
        }
    }
    
    return -1;
}

int main() {
    cin >> N;
    cin >> start.first >> start.second;
    cin >> dest.first >> dest.second;
    
    cout << bfs() << endl;
}
