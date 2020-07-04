#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <math.h>
#include <vector>
#include <map>
#include <climits>

using namespace std;
int st[4* 50000];

int get(int l, int r, int s, int e, int v) {
	if (s >= l && e <= r) {
		return st[v];
	}
	if (e<l||s>r) {
		return INT_MIN;
	}
	int mid = s + (e - s) / 2;
	return max(get(l, r, s, mid, 2*v), get(l,r, mid+1, e, 2*v+1));
}

int build(int* arr, int as, int ae, int v) {
	if (as == ae) {
		st[v] = arr[as];
		return st[v];
	}
	int mid = as + (ae - as) / 2;
	int req = max(build(arr, as, mid, v * 2), build(arr, mid + 1, ae, v * 2 + 1));
	st[v] = req;
	return req;
}

int main() {
	int n;
	cin >> n;
	int *arr = new int[n];
	for (int i = 0; i < n;i++) {
		cin >> *(arr + i);
	}
	build(arr, 0, n - 1, 1);
	int tc;
	cin >> tc;
	while (tc--) {
		int l, r;
		cin >> l >> r;
		cout << get(l-1, r-1, 0, n - 1, 1)<<endl;
	}
}
