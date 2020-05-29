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

struct abc {
    int a, b, c;
};

int A, B, C, sum;
bool visited[1001][1001];
vector<int> vec;

int stones() {
    queue<abc> q;
    vec.push_back(A); vec.push_back(B); vec.push_back(C);
    sort(vec.begin(), vec.end());
    q.push( { vec[0], vec[1], vec[2] } );
    visited[vec[0]][vec[1]] = true;
    vec.clear();
    
    while(!q.empty()) {
        int a = q.front().a;
        int b = q.front().b;
        int c = q.front().c;
        q.pop();
        
        if(a == b && b == c)
            return 1;
        
        int dx[] = {a, a, b};
        int dy[] = {b, c, c};
        
        for(int i = 0; i < 3; i++) {
            int ta = dx[i];
            int tb = dy[i];
            int tc = sum - ta - tb;
            
            if(ta > tb) {
                ta -= tb;
                tb += tb;
            }
            else if(ta < tb) {
                tb -= ta;
                ta += ta;
            }
            else
                continue;
        

            vec.push_back(ta);
            vec.push_back(tb);
            vec.push_back(tc);
            sort(vec.begin(), vec.end());
            if(!visited[vec[0]][vec[1]]) {
                q.push( { vec[0], vec[1], vec[2] } );
                visited[vec[0]][vec[1]] = true;
            }

            vec.clear();
        }
    }
    
    return 0;
}

int main() {
    cin >> A >> B >> C;
    sum = A + B + C;
    if(sum % 3 == 0)
        cout << stones() << endl;
    else
        cout << 0 << endl;
}
