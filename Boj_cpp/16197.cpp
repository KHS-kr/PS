#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct coins {
    pair<int, int> first;
    pair<int, int> second;
};

int N, M;
vector<pair<int, int>> coin;
char arr[22][22];
queue<coins> q;
queue<int> cnt;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int bfs() {
    coins temp;
    temp.first = coin[0];
    temp.second = coin[1];
    q.push(temp);
    cnt.push(0);
    
    while(!q.empty()) {
        pair<int, int> f = q.front().first;
        pair<int, int> s = q.front().second;
        q.pop();
        int count = cnt.front();
        cnt.pop();
        
        //10번보다 많이눌리면
        if(count > 10)
            break;
        //두개다 떨어지면
        if(arr[f.first][f.second] == '\0' && arr[s.first][s.second] == '\0')
            continue;
        //하나만 떨어지면
        if(arr[f.first][f.second] == '\0' || arr[s.first][s.second] == '\0')
            return count;
        
        for(int i = 0; i < 4; i++) {
            int tfx = f.first + dx[i];
            int tfy = f.second + dy[i];
            int tsx = s.first + dx[i];
            int tsy = s.second + dy[i];
            if(arr[tfx][tfy] == '#') {
                tfx = f.first;
                tfy = f.second;
            }
            if(arr[tsx][tsy] == '#') {
                tsx = s.first;
                tsy = s.second;
            }
            if(tfx == f.first && tfy == f.second && tsx == s.first && tsy == s.second)
                continue;
            
            coins input;
            input.first.first = tfx;
            input.first.second = tfy;
            input.second.first = tsx;
            input.second.second = tsy;
            q.push(input);
            cnt.push(count + 1);
        }
    }
    
    return -1;
}

int main() {
    cin >> N >> M;
    for(int i = 1; i <= N; i++)
        for(int j = 1; j <= M; j++) {
            cin >> arr[i][j];
            if(arr[i][j] == 'o')
                coin.push_back(make_pair(i, j));
        }
    
    cout << bfs() << endl;
}
