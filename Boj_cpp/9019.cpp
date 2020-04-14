#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

int T, A, B;
bool visited[10000];

int D(int n) {
    return (n * 2) % 10000;
}

int S(int n) {
    return n - 1 < 0 ? 9999 : n - 1;
}

int L(int n) {
    return (n % 1000) * 10 + n / 1000;
}

int R(int n) {
    return (n % 10) * 1000 + n / 10;
}

string AtoB() {
    queue<pair<int, string>> q;
    q.push(make_pair(A, ""));
    visited[A] = true;
    
    while(!q.empty()) {
        int n = q.front().first;
        string cur = q.front().second;
        q.pop();
        
        if(n == B)
            return cur;
        
//        int temp = D(n);
        int temp = (n * 2) % 10000;
        if(!visited[temp]) {
            visited[temp] = true;
            q.push(make_pair(temp, cur + "D"));
        }
        
//        temp = S(n);
        temp = n - 1 < 0 ? 9999 : n - 1;
        if(!visited[temp]) {
            visited[temp] = true;
            q.push(make_pair(temp, cur + "S"));
        }
        
//        temp = L(n);
        temp = (n % 1000) * 10 + n / 1000;
        if(!visited[temp]) {
            visited[temp] = true;
            q.push(make_pair(temp, cur + "L"));
        }
        
//        temp = R(n);
        temp = (n % 10) * 1000 + n / 10;
        if(!visited[temp]) {
            visited[temp] = true;
            q.push(make_pair(temp, cur + "R"));
        }
    }
    
    return "";
}

int main() {
    cin >> T;
    
    for(int i = 0; i < T; i++) {
        memset(visited, false, sizeof(visited));
        cin >> A >> B;
        cout << AtoB() << endl;
    }
}
