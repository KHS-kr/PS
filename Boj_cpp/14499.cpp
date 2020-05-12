#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;
int N, M, x, y, K;
int arr[20][20];
int order[1000];
int dice[6] = {0, 0, 0, 0, 0, 0}; //위, 그아래, 그아래, 그아래, 서, 동
int up = 0;
int dx[5] = {0, 1, -1, 0, 0};
int dy[5] = {0, 0, 0, -1, 1};

bool range_check(int x, int y) {
    if(x < 0 || x >= M || y < 0 || y >= N)
        return false;
    return true;
}

/*
    2
 4  1  3
    5
    0
 */

void dice_move(int k) {
    int temp;
    switch(k) {
        case 3 :
            temp = dice[0];
            dice[0] = dice[1]; dice[1] = dice[2]; dice[2] = dice[3]; dice[3] = temp;
            break;
        case 4 :
            temp = dice[0];
            dice[0] = dice[3]; dice[3] = dice[2]; dice[2] = dice[1]; dice[1] = temp;
            break;
        case 1 :
            temp = dice[5];
            dice[5] = dice[0]; dice[0] = dice[4]; dice[4] = dice[2]; dice[2] = temp;
            break;
        case 2 :
            temp = dice[4];
            dice[4] = dice[0]; dice[0] = dice[5]; dice[5] = dice[2]; dice[2] = temp;
            break;
    }
}

void move() {
    int px = x; int py = y;
    for(int k = 0; k < K; k++) {
        int nx = px + dx[order[k]];
        int ny = py + dy[order[k]];
        
        if(!range_check(nx, ny))
            continue;
        
        if(arr[py][px] == 0) {
            arr[py][px] = dice[2];
        }
        else {
            dice[2] = arr[py][px];
            arr[py][px] = 0;
        }
        
        dice_move(order[k]);
        
        px = nx; py = ny;
        
        cout << dice[0] << endl;
    }
}

int main() {
    cin >> N >> M >> y >> x >> K;

    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            cin >> arr[i][j];
    for(int i = 0; i < K; i++)
        cin >> order[i];

    move();
}
