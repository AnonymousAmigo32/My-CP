#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <string>
#include <math.h>
#include <vector>
#include <map>

using namespace std;
vector<int> *dp;
int maxD, maxV;
int iter(map<int, vector<int>>& tree, int current, int parent, int depth) {
	int val = 0;
	for (int i : tree[current]) {
		if (i != parent) {
			iter(tree, i, current, depth + 1);
		}
	}
	if (depth > maxD) {
		maxD = depth;
		maxV = current;
	}
	return val;
}
int length(map<int, vector<int>> &tree, int &n) {
	maxD = -1;
	iter(tree, 1, 0, 0);
	maxD = -1;
	iter(tree, maxV, 0, 0);
	return maxD;
}

int main() {
	int n;
	cin >> n;
	dp = new vector<int>(n+1);
	map<int, vector<int>> tree;
	for (int i = 1; i <= n; i++)tree.insert({i, vector<int>()});
	for (int i = 1; i < n; i++) {
		int a, b;
		cin >> a >> b;
		tree[a].push_back(b);
		tree[b].push_back(a);
	}
	cout << length(tree, n);
}
