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

int N, ret = 0;
char arr[10][8];
int alphabet[26];

bool compare(int a, int b) {
    return a > b;
}

int main() {
    memset(alphabet, 0, sizeof(alphabet));
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
        int multi = 1;
        int length = 0;
        while(arr[i][length] != '\0')
            length++;
        
        for(long j = length - 1; j >= 0; j--) {
            alphabet[arr[i][j] - 'A'] += multi;
            multi *= 10;
        }
    }
    
    sort(alphabet, alphabet + 26, compare);
    
    for(int i = 9; i >= 0; i--) {
        ret += alphabet[9 - i] * i;
    }
    
    cout << ret << endl;
}
