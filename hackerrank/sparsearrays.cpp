#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, q;
    cin>> n;
    vector<string> strings(n);
    for(int i = 0 ; i < n ; i++){
        cin>>strings[i];
    }
    cin>>q;
    vector<string>queries(q);
    
    for(int i = 0 ;i < q; i++){
        cin>>queries[i];
    }
    
    for(int qi = 0 ; qi < q; qi++){
        int found = 0;
        for(int si = 0 ; si < n; si++){
            if(queries[qi].compare(strings[si]) == 0)
                found++;
        }
        cout<<found<<"\n";
    }
    return 0;
}
