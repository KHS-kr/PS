#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <cstring>
#include <regex>
#include <climits>

using namespace std;

int g, l;

int gcd(int a, int b) {
    if(!b) return a;
    if(a > b) return gcd(b, a % b);
    return gcd(a, b % a);
}

int main() {
    cin >> g >> l;
    
    int ab = l / g;
    int a = 0, b = 0;
    for(int i = 1; i * i <= ab; i++) {
        if(ab % i == 0)
            if(gcd(ab / i, i) == 1) {
                a = i;
                b = ab / i;
            }
    }
    
    cout << a * g << " " << b * g << endl;
}
