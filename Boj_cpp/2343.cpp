#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int N, M;
int arr[100000];

bool song(int len) {
    int sum = 0;
    int count = 1;
    for(int i = 0; i < N; i++) {
        if(arr[i] > len)
            return false;
        sum += arr[i];
        
        if(sum > len) {
            count++;
            sum = arr[i];
        }
    }
    
    return M >= count;
}

int main() {
    cin >> N >> M;
    
    int sum = 0;
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    
    int l = 0, r = sum;
    int result = 0;
    
    while(l <= r) {
        int mid = (l + r) / 2;
        
        if(song(mid)) {
            result = mid;
            r = mid - 1;
        }
        else
            l = mid + 1;
    }
    
    cout << result << endl;
}
