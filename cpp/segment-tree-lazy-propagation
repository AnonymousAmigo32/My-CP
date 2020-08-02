#include<bits/stdc++.h>

using namespace std;
#define ll unsigned long long

vector<ll> tree(4e5+2,0);
vector<ll> lazy(4e5+2,0);

void updateq(int ss,int se, int idx, int qs, int qe, ll v) {
    if(lazy[idx]!=0) {
        tree[idx] += (se-ss+1)*lazy[idx];
        if(se!=ss) {
            lazy[2*idx+1]+=lazy[idx];
            lazy[2*idx+2]+=lazy[idx];
        }
        lazy[idx]=0;
    }
    if(se<ss||ss>qe||se<qs) return;
    if(ss>=qs&&se<=qe) {
        tree[idx]+=(se-ss+1)*v;
        if(ss!=se) {
            lazy[2*idx+1]+=v;
            lazy[2*idx+2]+=v;
        }
        return;
    }
    int mid = (se+ss)/2;
    updateq(ss, mid, 2*idx+1, qs,qe,v);
    updateq(mid+1,se, 2*idx+2, qs,qe, v);
    tree[idx] = tree[2*idx+1]+tree[2*idx+2];
}

ll getq(int ss,int se, int idx, int qs, int qe) {
if(se<ss||ss>qe||se<qs) {
        return 0;
    }
    if(lazy[idx]!=0) {
        tree[idx] += (se-ss+1)*lazy[idx];
        if(se!=ss) {
            lazy[2*idx+1]+=lazy[idx];
            lazy[2*idx+2]+=lazy[idx];
        }
        lazy[idx]=0;
    }
    if(ss>=qs&&se<=qe) {
        return tree[idx];
    }
    int mid = (se+ss)/2;
    ll l = getq(ss, mid, 2*idx+1, qs,qe);
    ll r = getq(mid+1,se, 2*idx+2, qs,qe);
    return r+l;
}

int main() {
    int t;
    cin>>t;
    while(t--) {
        int n,c;
        cin>>n>>c;
        while(c--) {
            ll op,p,q;
            cin>>op>>p>>q;
            --p;--q;
            if(q<p) {
                swap(p,q);
            }
            if(op) {
                //updateq(0,n-1,0,p,q,0);
                cout<<getq(0,n-1,0,p,q)<<"\n";
            } else {
                ll v;
                cin>>v;
                updateq(0,n-1, 0, p,q,v);
            }
        }
        fill(tree.begin(),tree.end(),0);
        fill(lazy.begin(),lazy.end(),0);
    }
}
