#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int T, n, cnt;
int arr[100001];
bool visited[100001];
bool team[100001];

void dfs(int p) {
	visited[p] = true;

	int next = arr[p];
	if (!visited[next])
		dfs(next);
	else if (!team[next]) {
		for (int i = next; i != p; i = arr[i]) {
			team[i] = true;
			cnt++;
		}
		
		cnt++;
	}
	team[p] = true;
}

int main() {
	cin >> T;
	
	while (T--) {
		cin >> n;
		cnt = 0;
		memset(visited, false, sizeof(visited));
		memset(team, false, sizeof(team));
		memset(arr, false, sizeof(arr));

		for (int i = 1; i <= n; i++)
			cin >> arr[i];

		for (int i = 1; i <= n; i++)
			if (!visited[i])
				dfs(i);

		cout << n - cnt << endl;
	}
}
