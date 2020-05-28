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

long long N;

int main() {
    cin >> N;
    if(N % 7 == 0 || N % 7 == 2)
        cout << "CY" << endl;
    else
        cout << "SK" << endl;
}
