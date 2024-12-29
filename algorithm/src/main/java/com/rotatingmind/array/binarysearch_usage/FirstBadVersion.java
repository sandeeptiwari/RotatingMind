package com.rotatingmind.array.binarysearch_usage;

public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int n) {
        badVersion = n;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int badVersion = 1;

        while(start <= end) {
            int mid = start + (end - start ) / 2; //6700 --> worked
            // int mid = (start + end) / 2; //6700 -- overflow
            System.out.println("End "+ end);
            System.out.println("mid " + mid);
            System.out.println("isBadVersion(mid)  " + isBadVersion(mid));
            System.out.println("Start  " + start);

            if(isBadVersion(mid)){
                badVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return badVersion;
    }

    public static void main(String[] args) {
        int n = 2126753390;
        FirstBadVersion firstBadVersion = new FirstBadVersion(n);
        long s = System.nanoTime();
        int res = firstBadVersion.firstBadVersion(n);
        long e = System.nanoTime();

        System.out.println("Result :: " + res + " Total Time Taken " + (e - s));
    }
}
