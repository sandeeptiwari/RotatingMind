package com.rotatingmind.array;

import java.util.Scanner;

public class AlyonaAndFlowers {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s=sc.nextInt();
        long []a=new long[n];
        long []psum=new long[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        psum[0]=a[0];
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1]+a[i];
        }

        long sum=0, ans = 0;
        long tsum=0;
        int j=0,l,r;
        while( j<s){
            l= sc.nextInt();
            r= sc.nextInt();
            if(l==0){
                ans=psum[r];
            } else {
                ans=psum[r]-psum[l-1];
            }
            if(ans>0){
                tsum=tsum+ans;
            }
            j++;
        }
        System.out.print(tsum);


    }
}
