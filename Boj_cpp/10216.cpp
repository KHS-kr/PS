#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>
#include <cmath>
#include <cstdlib>

using namespace std;

struct enemy {
    int x;
    int y;
    int R;
};

int N, x, y, R, ret;
vector<enemy> vec;
bool visited[3001];
vector<int> v[3001];

void dfs(int n) {
    visited[n] = true;
    
    for(int i = 0; i < v[n].size(); i++) {
        if(!visited[v[n][i]])
            dfs(v[n][i]);
    }
}

int main() {
    int T;
    cin >> T;
    while(T--) {
        cin >> N;
        vec.clear();
        ret = 0;
        memset(visited, false, sizeof(visited));
        for(int i = 0; i < 3001; i++)
            v[i].clear();
        enemy temp;
        for(int i = 0; i < N; i++) {
            cin >> x >> y >> R;
            temp = {x, y, R};
            vec.push_back(temp);
            if(i != 0) {
                for(int j = 0; j < i; j++) {
                    if((vec[j].x - vec[i].x) * (vec[j].x - vec[i].x)
                       + (vec[j].y - vec[i].y) * (vec[j].y - vec[i].y)
                       <= (vec[j].R + vec[i].R) * (vec[j].R + vec[i].R)) {
                           v[i].push_back(j);
                           v[j].push_back(i);
                       }
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(i);
                ret++;
            }
        }
        
        cout << ret << endl;
    }
}
