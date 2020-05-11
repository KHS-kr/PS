#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int N;
int W[11];
bool visited[11];
int ret = 0;

void dfs(int energy, int count) {
    if(N - count <= 2) {
        ret = max(ret, energy);
        return;
    }
    
    for(int i = 2; i < N; i++) {
        if(visited[i])
            continue;
        
        visited[i] = true;
        int left = i, right = i;
        
        while(visited[left])
            left--;
        while(visited[right])
            right++;
        
        dfs(energy + (W[left] * W[right]), count + 1);
        visited[i] = false;
    }
}

int main() {
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> W[i + 1];
    
    dfs(0, 0);
    cout << ret << endl;
}
