#include<bits/stdc++.h>

using namespace std;
#define ll long long

struct node{
    ll sum,best, left,right;
    node(ll a, ll b, ll c, ll d) {
        sum=a,best=b,left=c,right=d;
    }
};

vector<node> tree(5*50010, node(0,0,0,0));

node merges(node l, node r) {
    node s = node(0,0,0,0);
    if(l.best == -7e8){
        s.sum = r.sum;
        s.left = r.left;
        s.right = r.right;
        s.best=r.best;
        return s;
        }
    if(r.best == -7e8){
        s.sum = l.sum;
        s.left = l.left;
        s.right = l.right;
        s.best = l.best;
        return s;
    }
    s.sum = l.sum+r.sum;
    s.left = max(l.left, l.sum+r.left);
    s.right = max(r.right, r.sum+l.right);
    s.best = max(max(s.sum, s.left), s.right);
    s.best = max(s.best, l.best);
    s.best = max(s.best, r.best);
    s.best = max(s.best, l.right);
    s.best = max(s.best, r.left);
    s.best = max(s.best, l.right+r.left);
    return s;
}

void build(int ss, int se, vector<int> &arr, int idx) {
    if(se<ss)return;
    if(se==ss) {
        tree[idx]= node(arr[ss],arr[ss],arr[ss],arr[ss]);
        return;
    }
    int mid = ss + (se-ss)/2;
    build(ss, mid, arr, 2*idx+1);
    build(mid+1, se, arr, 2*idx+2);
    tree[idx]=merges(tree[2*idx+1],tree[2*idx+2]);
}

void update(int pos, int val, int ss, int se, int idx) {
    if(ss>pos||se<pos)return;
    if(ss==pos&&ss==se) {
        ll newVal = val;
        tree[idx].best = newVal;
        tree[idx].left = newVal;
        tree[idx].right = newVal;
        tree[idx].sum = newVal;
        return;
    }
    int mid = ss + (se-ss)/2;
    update(pos,val,ss,mid,2*idx+1);
    update(pos,val,mid+1, se,2*idx+2);
    tree[idx] = merges(tree[2*idx+1],tree[2*idx+2]);
}

node get(int qs,int qe, int ss, int se, int idx) {
    if(qs>se||qe<ss)return node(-7e8,-7e8,-7e8,-7e8);
    if(qs<=ss&&qe>=se) {
        return tree[idx];
    }
    int mid = ss+(se-ss)/2;
    node l = get(qs,qe, ss, mid, 2*idx+1);
    node r = get(qs, qe, mid+1, se, 2*idx+2);
    return merges(l,r);
}

int main() {
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int &i:arr)cin>>i;
    build(0,n-1,arr,0);
    int m;
    cin>>m;
    while(m--) {
        int type,x,y;
        cin>>type>>x>>y;
        if(type) {
            cout<<get(x-1,y-1,0,n-1,0).best<<endl;
        } else {
            update(x-1,y,0,n-1,0);
        }
    }
}
