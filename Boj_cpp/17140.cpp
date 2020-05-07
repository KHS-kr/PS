#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>

using namespace std;

int r, c, k;
int arr[100][100];
int x = 3, y = 3;
vector<pair<int, int>> vec; //카운팅 하는 배열

bool compare(pair<int, int> a, pair<int, int> b) {
    if(a.second == b.second)
        return a.first < b.first;
    else
        return a.second < b.second;
}

void x_counting(int n) {
    bool flag = false;
    for(int i = 0; i < y; i++) {
        if(arr[n][i] == 0)
            continue;
        flag = false;
        for(int j = 0; j < vec.size(); j++) {
            if(vec[j].first == arr[n][i]) {
                vec[j].second++;
                flag = true;
                break;
            }
        }
        if(!flag)
            vec.push_back(make_pair(arr[n][i], 1));
    }
}

void y_counting(int n) {
    bool flag = false;
    for(int i = 0; i < y; i++) {
        if(arr[i][n] == 0)
            continue;
        flag = false;
        for(int j = 0; j < vec.size(); j++) {
            if(vec[j].first == arr[i][n]) {
                vec[j].second++;
                flag = true;
                break;
            }
        }
        if(!flag)
            vec.push_back(make_pair(arr[i][n], 1));
    }
}

int RC() {
    int count = 0, max_xy = 0, temp;
    while(arr[r][c] != k && count <= 100) {
        max_xy = 0;
        if(x >= y) {
            for(int i = 0; i < x; i++) {
                temp = 0;
                vec.clear();
                x_counting(i);
                sort(vec.begin(), vec.end(), compare);
                for(int j = 0; j < vec.size(); j++) {
                    arr[i][j * 2] = vec[j].first;
                    arr[i][j * 2 + 1] = vec[j].second;
                    temp += 2;
                }
                if(temp < x) {
                    for(int j = temp; j < x; j++)
                        arr[i][j] = 0;
                }
                max_xy = max_xy > temp ? max_xy : temp;
            }
            y = max_xy > y ? max_xy : y;
        }
        else {
            for(int i = 0; i < y; i++) {
                temp = 0;
                vec.clear();
                y_counting(i);
                sort(vec.begin(), vec.end(), compare);
                for(int j = 0; j < vec.size(); j++) {
                    arr[j * 2][i] = vec[j].first;
                    arr[j * 2 + 1][i] = vec[j].second;
                    temp += 2;
                }
                if(temp < y) {
                    for(int j = temp; j < x; j++)
                        arr[j][i] = 0;
                }
                max_xy = max_xy > temp ? max_xy : temp;
            }
            x = max_xy > x ? max_xy : x;
            
        }
        count++;
//        cout << "* " << count << " *" << endl;
//        for(int i = 0; i < x; i++) {
//            for(int j = 0; j < y; j++)
//                cout << arr[i][j] << " ";
//            cout << endl;
//        }
    }
    
    return count <= 100 ? count : -1;
}

int main() {
    cin >> r >> c >> k;
    r--; c--;
    for(int i = 0; i < 3; i++)
        for(int j = 0; j < 3; j++)
            cin >> arr[i][j];
    
    cout << RC() << endl;
}
