package com.leetcode.test.HotAlgorithms;

public class SegmentTree {

    String s;       //公共变量，为了好写。

    //----------------------- 线段树 start --------------------------//
    SegTreeNode [] tree;

    void push_up(int root){
        int ll = 2 * root + 1;
        int rr = 2 * root + 2;

        tree[root].size = tree[ll].size + tree[rr].size;
        tree[root].l_ch = tree[ll].l_ch;
        tree[root].r_ch = tree[rr].r_ch;
        tree[root].l_max = tree[ll].l_max;
        tree[root].r_max = tree[rr].r_max;
        tree[root].all_max = Math.max(tree[ll].all_max, tree[rr].all_max);
        //----看中间能否合并
        if (tree[ll].r_ch == tree[rr].l_ch){
            if (tree[ll].l_max == tree[ll].size){
                tree[root].l_max += tree[rr].l_max;
            }
            if (tree[rr].r_max == tree[rr].size){
                tree[root].r_max += tree[ll].r_max;
            }
            tree[root].all_max = Math.max(tree[root].all_max, tree[ll].r_max + tree[rr].l_max);
        }
    }

    void build(int root, int l, int r){
        tree[root].l = l;
        tree[root].r = r;

        if (l == r){
            tree[root].size = 1;
            tree[root].l_ch = s.charAt(l);
            tree[root].r_ch = s.charAt(r);
            tree[root].l_max = 1;
            tree[root].r_max = 1;
            tree[root].all_max = 1;
            return ;
        }

        int mid = l + r >> 1;
        int ll = 2 * root + 1;
        int rr = 2 * root + 2;
        build(ll, l, mid);
        build(rr, mid + 1, r);
        push_up(root);
    }

    void update(int root, int i, char c){
        if (tree[root].l == tree[root].r){
            tree[root].l_ch = c;
            tree[root].r_ch = c;
            return ;
        }

        int mid = tree[root].l + tree[root].r >> 1;
        int ll = 2 * root + 1;
        int rr = 2 * root + 2;
        if (i <= mid){
            update(ll, i, c);
        }
        else{
            update(rr, i, c);
        }
        push_up(root);
    }

    // int query()
    // {
    // }
//-------------------------------- 线段树 end ---------------------------------//


    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s;
        int n = s.length();
        tree = new SegTreeNode [4 * n];
        for (int i = 0; i < 4 * n; i ++){
            tree[i] = new SegTreeNode();
        }

        build(0, 0, n - 1);

        int k = queryCharacters.length();
        int [] res = new int[k];
        for (int ki = 0; ki < k; ki ++){
            int i = queryIndices[ki];
            char c = queryCharacters.charAt(ki);
            update(0, i, c);
            int cur = tree[0].all_max;
            res[ki] = cur;
        }

        return res;
    }


    class SegTreeNode{
        int l;          //左界
        int r;          //右界
        int size;       //区间的长度
        char l_ch;      //左边界的字母
        char r_ch;      //右边界的字母
        int l_max;      //左边界在内的，最大（符合条件的）长度（也可以理解为左缀）
        int r_max;      //右缀
        int all_max;    //整个区间的最大（符合条件的）长度

        SegTreeNode () {}
    }
}
