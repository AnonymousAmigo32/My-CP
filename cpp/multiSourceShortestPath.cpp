#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <math.h>
#include <vector>
#include <map>
#include <climits>
#include <queue>

using namespace std;

int a[190][190];
int n, m;

void bfs(int i, int j) {
	a[i][j] = 0;
	queue<int> q;
	q.push(i);
	q.push(j);
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		int y = q.front();
		q.pop();
		int dist = a[x][y] + 1;
		if (y - 1 >= 0 && dist < a[x][y - 1]) {
			a[x][y - 1] = dist;
			q.push(x);
			q.push(y - 1);
		}
		if (y + 1 < m && dist < a[x][y + 1]) {
			a[x][y + 1] = dist;
			q.push(x);
			q.push(y + 1);
		}
		if (x - 1 >= 0 && dist < a[x - 1][y]) {
			a[x - 1][y] = dist;
			q.push(x - 1);
			q.push(y);
		}
		if (x + 1 < n && dist < a[x + 1][y]) {
			a[x + 1][y] = dist;
			q.push(x + 1);
			q.push(y);
		}
	}
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		cin >> n >> m;
		vector<pair<int, int>> p;
		for(int i=0;i<n;i++)
			for (int j = 0; j < m; j++) {
				char c;
				cin >> c;
				if (c == '1') {
					a[i][j] = INT_MIN;
					p.push_back({ i,j });
				}
				else {
					a[i][j] = INT_MAX;
				}
			}
		for (pair<int, int> pos : p) {
			bfs(pos.first, pos.second);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cout << a[i][j] << " ";
			}
			cout << endl;
		}
	}
}
