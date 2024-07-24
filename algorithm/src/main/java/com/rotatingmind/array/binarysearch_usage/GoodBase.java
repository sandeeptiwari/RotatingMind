package com.rotatingmind.array.binarysearch_usage;


public class GoodBase {

   /* public:

    long long sumofbase (int mid , int i,int n)

    {

        long long sum,y;

        sum=0,y=1;

        for ( long long x=1;x<i;x++)

        {

            sum+=y;

            if (sum>=n) break ;

            else if (x<i && ((n-sum)/y)>mid) break;

            else y*=mid;

        }

        return sum;

    }

    string smallestGoodBase(string n) {

        long long hi,lo,mid; int num=stoll(n);

// for the max possible N value which is 10^18 and the min possible base value which is 2 we have a total of 63 digits

// str ans="";

        for (int i=63;i>0;i--)

        {

            lo=2,hi=num-1; // the possible values of a good base

            while (lo<=hi)

            {

                mid =(lo+hi)>>1;

                long long x=sumofbase(mid,i,num);

                if (x==num) return to_string(mid) ;

                else if (x>num) hi=mid-1; // since all the values to right of the mid value are of no use

                else lo=mid+1; // since all the values to the left are small are of no use

            }

        }

        return to_string(lo);

    }*/


}
