#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

int T, n;
int preorder[1001], inorder[1001];

void postorder(int root, int start, int end) {
    for(int i = start; i < end; i++) {
        if(inorder[i] == preorder[root]) {
            postorder(root + 1, start, i);
            postorder(root + i - start + 1, i + 1, end);
            cout << preorder[root] << " ";
        }
    }

}

int main() {
    cin >> T;

    while(T-- > 0) {
        cin >> n;

        for(int i = 0; i < n; i++)
            cin >> preorder[i];
        for(int i = 0; i < n; i++)
            cin >> inorder[i];

        postorder(0, 0, n);
        cout << endl;
    }
}
