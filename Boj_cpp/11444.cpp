#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>

#define MOD 1000000007

using namespace std;

typedef vector<vector<long long>> matrix;

long long n;

matrix operator * (const matrix &a, const matrix &b) {
    long long size = a.size();
    matrix res(size, vector<long long>(size));
    for (long long i = 0; i < size; i++) {
        for (long long j = 0; j < size; j++) {
            for (long long k = 0; k < size; k++) {
                res[i][j] += a[i][k] * b[k][j];
            }
            res[i][j] %= MOD;
        }
    }
    
    return res;
}

matrix power(matrix a, long long n) {
    long long size = a.size();
    matrix res(size, vector<long long>(size));
    for(long long i = 0; i < size; i++)
        res[i][i] = 1;
    
    while(n > 0) {
        if(n % 2 == 1)
            res = res * a;
        n /= 2;
        a = a * a;
    }
    
    return res;
}

int main() {
    scanf("%lld", &n);
    matrix a = { {1, 1}, {1, 0} };
    matrix res = (power(a, n - 1));
    cout << (res[1][0] + res[1][1]) % MOD << endl;
}
