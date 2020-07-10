#include <bits/stdc++.h>
#include<unordered_map>
using namespace std;
int step;
struct mo {
	int l, r, index;
};
 
bool __cmp(mo& a, mo& b) {
	int astep = a.l / step, bstep = b.l/step;
	return (astep != bstep) ? astep < bstep : a.r < b.r;
}
 
int main() {
	int size;
	cin >> size;
	vector<int> arr(size);
	for (int& i : arr)cin >> i;
	int m;
	cin >> m;
	vector<mo> queries(m);
	for (int i = 0; i < m;i++) {
		cin >> queries[i].l >> queries[i].r;
		queries[i].l--; queries[i].r--;
		queries[i].index = i;
	}
	step = ceil(sqrt(size));
	sort(queries.begin(), queries.end(), __cmp);
	int left = 0, right = 0;
	vector<int> solution(m);
	int answer = 1;
	unordered_map<int, int> holdset;
	holdset[arr[0]]++;
	for (int i = 0; i < m; i++) {
		mo& query = queries[i];
		int ql = query.l, qr = query.r;
 
		while (left < ql) {
			holdset[arr[left]]--;
			if (holdset[arr[left]] == 0)answer--;
			left++;
		}
		while (right > qr) {
			holdset[arr[right]]--;
			if (holdset[arr[right]] == 0)answer--;
			right--;
		}
		while (left > ql) {
			--left;
			holdset[arr[left]]++;
			if (holdset[arr[left]] == 1)answer++;
		}
		while (right < qr) {
			++right;
			holdset[arr[right]]++;
			if (holdset[arr[right]] == 1)answer++;
		}
		solution[query.index] = answer;
	}
	for (int i = 0; i < m; i++) {
		cout << solution[i] << endl;
	}
} 
