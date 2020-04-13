#include <iostream>
#include <stdio.h>
#include <string>

using namespace std;

string str;
int dp[502][502];

int main() {
    getline(cin, str);
    
    for(int size = 1; size < str.length(); size++) {
        for(int start = 0; start + size < str.length(); start++) {//
            int end = start + size;

            for(int mid = start; mid < end; mid++) {
                dp[start][end] = max(dp[start][end], dp[start][mid] + dp[mid + 1][end]);

            if((str[start] == 'a' && str[end] == 't') || (str[start] == 'g' && str[end] == 'c'))
                dp[start][end] = max(dp[start + 1][end - 1] + 2, dp[start][end]);
            }
        }
    }
    
    cout << dp[0][str.length() - 1] << endl;
}
