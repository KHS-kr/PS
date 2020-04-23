#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <string>

using namespace std;

int L, C;
vector<char> vec;
char aeiou[] = {'a', 'e', 'i', 'o', 'u'};

void dfs(int index, int count, int mo, int ja, string str) {
    if(count == L) {
        if(mo >= 1 && ja >= 2) {
            cout << str << endl;
        }
        return;
    }
    
    if(index == C)
        return;
    bool flag = true;
    for(int i = 0; i < 5; i++) {
        if(vec[index] == aeiou[i]) {
            dfs(index + 1, count + 1, mo + 1, ja, str + vec[index]);
            flag = false;
            break;
        }
    }
    if(flag)
        dfs(index + 1, count + 1, mo, ja + 1, str + vec[index]);
    dfs(index + 1, count, mo, ja, str);
    
}

int main(void) {
    cin >> L >> C;
    for(int i = 0; i < C; i++) {
        char temp;
        cin >> temp;
        vec.push_back(temp);
    }
    sort(vec.begin(), vec.end());
    dfs(0, 0, 0, 0, "");
}
