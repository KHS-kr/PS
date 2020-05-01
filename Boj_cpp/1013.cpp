#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>

using namespace std;

bool pattern(string str) {
    return regex_match(str, regex("(100+1+|01)+"));
}

int main(void) {
    int T;
    cin >> T;
    while(T--) {
        string temp;
        cin >> temp;
        if(pattern(temp)) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
}
