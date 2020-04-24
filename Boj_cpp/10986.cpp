#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <string>

using namespace std;

int N, M;
long long sum[1000001];
long long ret = 0;

int main(void) {
    cin >> N >> M;
    
    vector<long long> cnt(M, 0);
    
    for(int i = 1; i <= N; i++) {
        int temp;
        cin >> temp;
        
        sum[i] = (sum[i - 1] + temp) % M;
        if(!sum[i])
            ret++;
        cnt[sum[i]]++;
    }
    
    for(int i = 0; i < M; i++)
        ret += cnt[i] * (cnt[i] - 1) / 2;
    
    cout << ret << endl;
}
