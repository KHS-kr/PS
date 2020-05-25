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
#include <stack>

using namespace std;

struct dir {
    bool N, S, E, W;
};

struct room {
    int i, j;
    int S;
};

int n, m, cnt = 0, room_max = 0, extra = 0, p = 0;
dir castle[50][50];
int arr[50][50];
bool visited[50][50];
vector<room> vec;
vector<vector<pair<int, int>>> con;

bool room_comparator(room a, room b) {
    return a.S > b.S;
}

bool pair_comparator(vector<pair<int, int>> a, vector<pair<int, int>> b) {
    return a.size() > b.size();
}

void findNSEW(int i, int j) {
    int ij = arr[i][j];
    int temp = 8;
    while(temp > 0) {
        if(ij >= temp) {
            switch(temp) {
                case 1 : castle[i][j].W = true;
                    break;
                case 2 : castle[i][j].N = true;
                    break;
                case 4 : castle[i][j].E = true;
                    break;
                case 8 : castle[i][j].S = true;
                    break;
            }
            ij -= temp;
        }
        temp /= 2;
    }
}

bool range_check(int i, int j) {
    if(i >= 0 && i < m && j >= 0 && j < n)
        return true;
    return false;
}

int dfs(int i, int j) {
    int ret = 1;
    visited[i][j] = true;
    con[p].push_back( { i, j } );
    
    if(!castle[i][j].N && !visited[i - 1][j] && range_check(i - 1, j))
        ret += dfs(i - 1, j);
    if(!castle[i][j].S && !visited[i + 1][j] && range_check(i + 1, j))
        ret += dfs(i + 1, j);
    if(!castle[i][j].E && !visited[i][j + 1] && range_check(i, j + 1))
        ret += dfs(i, j + 1);
    if(!castle[i][j].W && !visited[i][j - 1] && range_check(i, j - 1))
        ret += dfs(i, j - 1);
    
    return ret;
}

int connection(int a, int b) {
    for(int i = 0; i < con[a].size(); i++) {
        for(int j = 0; j < con[b].size(); j++) {
            int dx = abs(con[a][i].first - con[b][j].first);
            int dy = abs(con[a][i].second - con[b][j].second);
            if((dx == 1 && dy == 0) || (dx == 0 && dy == 1))
                return vec[a].S + vec[b].S;
        }
    }
    
    return 0;
}

int main() {
    cin >> n >> m;
    
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            cin >> arr[i][j];
            findNSEW(i, j);
        }
    }
    
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(!visited[i][j]) {
                con.push_back( { } );
                vec.push_back( { i, j, dfs(i, j) } );
                room_max = max(room_max, vec.back().S);
                cnt++;
                p++;
            }
        }
    }
    
    sort(con.begin(), con.end(), pair_comparator);
    sort(vec.begin(), vec.end(), room_comparator);
    
    for(int i = 0; i < vec.size(); i++) {
        for(int j = i + 1; j < vec.size(); j++) {
            extra = max(extra, connection(i, j));
        }
    }
    
//    for(int i = 0; i < con.size(); i++) {
//        for(int j = 0; j < con[i].size(); j++) {
//            cout << "(" << con[i][j].first << ", " << con[i][j].second << ") ";
//        }
//        cout << endl;
//    }
//
//    for(int i = 0; i < vec.size(); i++) {
//        cout << vec[i].i << " " << vec[i].j << " " << vec[i].S << endl;
//    }
    
    cout << cnt << endl << room_max << endl << extra << endl;;
}
