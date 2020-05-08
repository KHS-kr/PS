#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

struct liquid {
    long long a, b, c;
    long long sum() {
        return this->a + this->b + this->c;
    }
};

int N;
vector<long long> vec;

liquid find() {
    liquid temp, ret;
    long long minus = LONG_MAX;
    
    for(int i = 0; i < N - 2; i++) {
        temp.a = vec[i];
        for(int j = i + 1; j < N - 1; j++) {
            temp.b = vec[j];
            long long t = -(temp.a + temp.b);
            int k = lower_bound(vec.begin() + j + 1, vec.end(), t) - vec.begin();
            for(int l = k - 2; l <= k + 2 && l < N; l++) {
                if(l <= j)
                    continue;
                temp.c = vec[l];
                if(abs(minus) > abs(temp.sum())) {
                    minus = temp.sum();
                    ret = temp;
                }
            }
        }
    }
    return ret;
}

int main() {
    cin >> N;
    vec.resize(N);
    for(int i = 0; i < N; i++)
        cin >> vec[i];
    
    sort(vec.begin(), vec.end());
    
    liquid ret = find();
    cout << ret.a << " " << ret.b << " " << ret.c << endl;
}
