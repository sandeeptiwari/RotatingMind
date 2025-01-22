![img.png](img.png)

2,3,(24): BCX
2,3,2,4: BCBD
(23),2,4: WBD
(23),(24): WX
=> we have total 4 ways to decode it:
![img_1.png](img_1.png)
Here remaining string is our state, whatever remaining is a suffix and suffix is fixed for every state
          cnt(0)
            /  \
         cnt(1) cnt(2)
 
**Note:** Here one glitch is we wont have 2 choices in every cases e.g.

            314 -> 3 we cant take here 31 as second choices, because choices 1--26
             |
            (14)
         1- A/  \ 14 -> N
            4   ""
![img_2.png](img_2.png)


E.g -> 0425 : 0  because no chars start from 0
       4021 : 0

f(i) = f(i + 1) + f(i + 2)

whenever call n-1 return empty string
ans = 0
if(possi1) {
   ans += f(i+1)
} 
if (possi2) {
  ans += f(i+2)
}

return ans;

possible1and2: S[i] - '0' 1<= num <= 26
4810693

i at 1
(s[i]-'0') * 10 + s[i+1] - '0'

bool isValid(int code, int len) {
  if (len1) ret code >= 1 && code <=9
  else code >=10 && code <=26
}

implementation as:

![img_3.png](img_3.png)