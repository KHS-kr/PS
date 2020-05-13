#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

#define MAX 2100000000
struct node {
    int start;
    int dest;
    int weight;
};

int n, m;
int arr[101][101];

int main() {
    cin >> n;
    cin >> m;
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            arr[i][j] = MAX;
    
    for(int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        if(arr[a][b] > c)
            arr[a][b] = c;
    }
    
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            for(int k = 1; k <= n; k++)
                if(arr[j][i] != MAX && arr[i][k] != MAX)
                    arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k]);
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(i != j && arr[i][j] != MAX)
                cout << arr[i][j] << " ";
            else
                cout << "0 ";
        }
        cout << endl;
    }
}
