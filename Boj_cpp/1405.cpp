#include <iostream>
#include <algorithm>
#include <vector>
#include <stdio.h>

using namespace std;

int N;
double input[4];
int arr[29][29];
bool visited[29][29];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

double dfs(int x, int y, int count) {
    if(count == N)
        return 1.0;
    
    visited[x][y] = true;
    double ret = 0.0;
    
    for(int i = 0; i < 4; i++) {
        int tx = x + dx[i];
        int ty = y + dy[i];
        
        if(visited[tx][ty] == true) continue;
        ret = ret + input[i] * dfs(tx, ty, count + 1);
    }
    visited[x][y] = false;
    
    return ret;
}


int main() {
    scanf("%d", &N);
    for(int i = 0; i < 4; i++) {
        scanf("%lf", &input[i]);
        input[i] /= 100;
    }
    
    cout.precision(10);
    cout << dfs(14, 14, 0) << endl;
}
