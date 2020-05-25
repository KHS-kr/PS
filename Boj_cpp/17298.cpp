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

int N;
int arr[1000001];
int nge[1000001];
stack<int> s;

int main() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
        nge[i] = -1;
    }
    
    for(int i = 0; i < N; i++) {
        while(!s.empty() && arr[s.top()] < arr[i]) {
            nge[s.top()] = arr[i];
            s.pop();
        }
        s.push(i);
    }
    for(int i = 0; i < N; i++)
        cout << nge[i] << " ";
}
