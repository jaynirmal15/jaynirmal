/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psaunionfind;

import java.util.Scanner;

/**
 *
 * @author Jay
 */
public class PSAUnionFind {

    /**
     * @param args the command line arguments
     */
    private int[] id;
    private int[] sz;
   private int count;

    public PSAUnionFind(int N) {
        id = new int[N];
         count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;

        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private int count() {

        return count;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
       
        PSAUnionFind uf =  new PSAUnionFind(N);
        for(int i=0;i<10;i++)
        {
            int p =sc.nextInt();
            int q = sc.nextInt();
            if(uf.connected(p, q))
            {
                return;
            }
            else{
            uf.union(p, q);
            
            }
        }
        System.out.print(uf.count + "companenets");
    }

}
