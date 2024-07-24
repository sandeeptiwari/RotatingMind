package com.rotatingmind.array.sorting;

public class SpecialElection {

    public static void main(String[] args) {
        /**
         * int t;
         *
         * cin >> t;
         *
         * while (t--)
         *
         * {
         *
         * int n;
         *
         * cin >> n;
         *
         * int arr[n];
         *
         * for (int i = 0; i < n; i++)
         *
         * cin >> arr[i];
         *
         * int ans[n];
         *
         * memset(ans, 0, sizeof(ans));
         *
         * int prefixSum[n];
         *
         * prefixSum[0] = arr[0];
         *
         * for (int i = 1; i < n; i++)
         *
         * prefixSum[i] = arr[i] + prefixSum[i - 1];
         *
         * // Vote in forward direction
         *
         * for (int i = 0; i < n - 1; i++)
         *
         * {
         *
         * int low = i + 1;
         *
         * int high = n - 1;
         *
         * int sum;
         *
         * int right = n - 1;
         *
         * while (low <= high)
         *
         * {
         *
         * int mid = (low + high) / 2;
         *
         * sum = prefixSum[mid - 1] - prefixSum[i];
         *
         * if (arr[i] >= sum)
         *
         * {
         *
         * right = mid;
         *
         * low = mid + 1;
         *
         * }
         *
         * else
         *
         * {
         *
         * if (arr[i] >= sum - arr[mid - 1])
         *
         * {
         *
         * // ans[mid - 1]++;
         *
         * // ans[i]--;
         *
         * right = mid - 1;
         *
         * break;
         *
         * }
         *
         * else
         *
         * high = mid - 1;
         *
         * }
         *
         * }
         *
         * ans[right]++;
         *
         * ans[i]--;
         *
         * }
         *
         * // Vote in backward direction
         *
         * for (int i = n - 1; i >= 1; i--)
         *
         * {
         *
         * int low = i - 1;
         *
         * int high = 0;
         *
         * int sum;
         *
         * int left = -1;
         *
         * while (high <= low)
         *
         * {
         *
         * int mid = (low + high) / 2;
         *
         * sum = prefixSum[i - 1] - prefixSum[mid];
         *
         * if (arr[i] >= sum)
         *
         * {
         *
         * low = mid - 1;
         *
         * left = mid;
         *
         * }
         *
         * else
         *
         * {
         *
         * if (arr[i] >= sum - arr[mid + 1])
         *
         * {
         *
         * // ans[mid + 1]++;
         *
         * // ans[i]--;
         *
         * left = mid + 1;
         *
         * break;
         *
         * }
         *
         * else
         *
         * high = mid + 1;
         *
         * }
         *
         * }
         *
         * left--;
         *
         * ans[i - 1]++;
         *
         * if (left >= 0)
         *
         * ans[left]--;
         *
         * }
         *
         * // Take suffix sum of answer array
         *
         * for (int i = n - 2; i >= 0; i--)
         *
         * ans[i] = ans[i] + ans[i + 1];
         *
         * // Print out n integers
         *
         * for (int i = 0; i < n; i++)
         *
         * cout << ans[i] << " ";
         *
         * cout << endl;
         *
         * }
         *
         * }
         *
         *
         *
         *
         * Likes . 0
         * Ashish Singh
         * Timestamp: 00:00
         * Here is my brute force solution. Is this correct?
         *
         * #include<bits/stdc++.h>
         * using namespace std;
         *
         * int main()
         * {
         *     int n;
         *     cin>>n;
         *
         *     int arr[n];
         *     for(int i;i<n;i++)
         *         cin>>arr[i];
         *
         *     int ans[n];
         *     memset(ans, 0, sizeof(ans));
         *
         *     //Vote in forward direction
         *     for(int i=0;i<n-1;i++)
         *     {
         *         int sum=0;
         *         for(int j=i+1;j<n;j++)
         *         {
         *             if(arr[i]>=sum)
         *                 ans[j]++;
         *             else
         *                 break;
         *
         *             sum+=arr[j];
         *         }
         *     }
         *
         *     //Vote in backward direction
         *     for(int i=n-1;i>=1;i--)
         *     {
         *         int sum=0;
         *         for(int j=i-1;j>=0;j--)
         *         {
         *             if(arr[i]>=sum)
         *                 ans[j]++;
         *             else
         *                 break;
         *
         *             sum+=arr[j];
         *         }
         *     }
         *
         *     for(int i=0;i<n;i++)
         *         cout<<ans[i]<<" ";
         *     cout<<endl;
         *
         *
         *     ===========================================
         *     int i,n,l,h,m,flag=0,f=0;
         *     cin>>n;
         *     vector<int> Influence(n),PfxSum(n),votes(n,0);
         *     for(i=0;i<n;i++)
         *       cin>>Influence[i];
         *       PfxSum[0]=Influence[0];
         *       for(i=1;i<n;i++)
         *          PfxSum[i]=PfxSum[i-1]+Influence[i];
         *
         *     for(i=0;i<n;i++)
         *     {
         *         if(i>0&&i<n-1)
         *         {
         *
         *             l=0;h=i-1;
         *             while(l<=h)
         *             {
         *                 if(i==1)
         *                 {
         *                     votes[0]+=1;
         *                     break;
         *                 }
         *                 m=(l+h)/2;
         *
         *
         *                 if(PfxSum[i-1]-PfxSum[m]<Influence[i])
         *                 {
         *                    h=m-1;
         *                 }
         *
         *                 else
         *                 {
         *                     if(PfxSum[i-1]-PfxSum[m+1]<=Influence[i])
         *                     {
         *
         *                         votes[i-1]+=1;
         *                         votes[m]-=1;
         *                         flag=1;
         *                         break;
         *                     }
         *                     else
         *                     {
         *                        l=m+1;
         *                     }
         *                 }
         *             }
         *             if(m==0&flag==0)
         *             {
         *                votes[i-1]+=1;
         *
         *             }
         *
         *             l=i+1,h=n-1;
         *             if(i==n-2)
         *             {
         *                 votes[n-1]+=1;
         *                 votes[i]-=1;
         *                 continue;
         *             }
         *             while(l<=h)
         *             {
         *
         *                 m=(l+h)/2;
         *                 if(PfxSum[m-1]-PfxSum[i]<Influence[i])
         *                 {
         *                    l=m+1;
         *                 }
         *
         *                 else
         *                 {
         *                    if(PfxSum[m-2]-PfxSum[i]<=Influence[i])
         *                    {
         *                        votes[m-1]+=1;
         *                        votes[i]-=1;
         *                        f=1;
         *                        break;
         *                    }
         *                    else
         *                    {
         *                         h=m-1;
         *                    }
         *
         *                 }
         *             }
         *             if(m==n-1&&f==0)
         *                {
         *                 votes[n-1]+=1;
         *                }
         *         }
         *         else if(i==0)
         *         {
         *             l=i+1,h=n-1;
         *             while(l<=h)
         *             {
         *                 m=(l+h)/2;
         *                 if(PfxSum[m-1]-PfxSum[i]<Influence[i])
         *                 {
         *                        l=m+1;
         *                 }
         *
         *                 else
         *                 {
         *                    if(PfxSum[m-2]-PfxSum[i]<=Influence[i])
         *                    {
         *
         *                        votes[m-1]+=1;
         *                        votes[0]-=1;
         *
         *                        break;
         *                    }
         *                    else
         *                    {
         *                       h=m-1;
         *                    }
         *
         *                 }
         *             }
         *         }
         *         else
         *         {
         *            l=0;h=i-2;
         *             while(l<=h)
         *             {
         *                 m=(l+h)/2;
         *                 if(PfxSum[i-1]-PfxSum[m]<Influence[i])
         *                 {
         *                           h=m-1;
         *                 }
         *
         *                 else
         *                 {
         *                     if(PfxSum[i-1]-PfxSum[m+1]<=Influence[i])
         *                     {
         *
         *                         votes[i-1]+=1;
         *                         votes[m]-=1;
         *                         break;
         *                     }
         *                     else
         *                     {
         *                         l=m+1;
         *                     }
         *
         *                 }
         *             }
         *         }
         *
         *     }
         *        for(i=n-1;i>0;i--)
         *        {
         *          votes[i-1]+=votes[i];
         *        }
         *
         *         for(i=0;i<n;i++)
         *         cout<<votes[i]<<" ";
         *         cout<<endl;
         *
         *
         *     return 0;
         */
    }
}
