#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int N, K;
long long arr[10000];

int main() {
    cin >> K >> N;
    for(int i = 0; i < K; i++)
        cin >> arr[i];
    
    long long l = 1, r = *(max_element(arr, arr + K));
    long long ret = 0;
    
    while(l <= r) {
        long long mid = (l + r) / 2;
        long long temp = 0;
        
        for(int i = 0; i < K; i++)
            temp += arr[i] / mid;
        
        if(temp >= N) {
            if(mid > ret)
                ret = mid;
            l = mid + 1;
        }
        else
            r = mid - 1;
    }
    
    cout << ret << endl;
}
