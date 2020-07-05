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

int main() {
	int t;
	cin >> t;
	while (t--) {
		int pw, tw, W;
		cin >> pw >> tw;
		W = tw - pw;
		int size;
		cin >> size;
		vector<pair<int, int>> vec(size);
		for (int i = 0; i < size; i++) {
			int a, b;
			cin >> a >> b;
			vec[i] = make_pair(a, b);
		}
		vector<int> dp(W + 1);
		fill(dp.begin(), dp.end(), INT_MAX);
		dp[0] = 0;
		for (int i = 1; i <= W; i++) {
			for (int j = 0; j < size; j++) {
				if (vec[j].second <= i) {
					if (dp[i - vec[j].second] != INT_MAX)
						dp[i] = min(dp[i], dp[i - vec[j].second] + vec[j].first);
				}
			}
		}
		if (dp[W]!=INT_MAX) {
			cout << "The minimum amount of money in the piggy-bank is " << dp[W] << "." << endl;
		}
		else {
			cout << "This is impossible." << endl;
		}
	}
}
