#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <string>

using namespace std;

int N, f;
vector<pair<int, int>> vec;

int main(void) {
    cin >> N;
    for(int i = 0; i < N; i++) {
        int t1, t2, t3, t4;
        cin >> t1 >> t2 >> t3 >> t4;
        vec.push_back(make_pair(t1 * 100 + t2, t3 * 100 + t4));
    }
    sort(vec.begin(), vec.end());
    
    if(vec[0].first > 301) {
        cout << 0 << endl;
        return 0;
    }
    
    int date = 301, index = -1, temp = 0;
    bool flag = false;
    while(date <= 1130 && f <= N) {
        flag = false;
        index++;
        for(int i = index; i <= N; i++) {
            if(vec[i].first > date)
                break;
            if(temp < vec[i].second) {
                flag = true;
                temp = vec[i].second;
                index = i;
            }
        }
        if(flag) {
            date = temp;
            f++;
        }
        else {
            cout << 0 << endl;
            return 0;
        }
    }
    cout << f << endl;
}
