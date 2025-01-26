![img.png](img.png)
 
Longest Bitonic sequence = max(LIS[i]+LDS[i] -1)
![img_1.png](img_1.png)

a0, a1, a2, .....ai, ai+1, ai+2, ai+3....ai+n

LDS - Longest decreasing Sequence = 1 + LDS[j], 

    j > i and arr[i] > arr[j]

![img_2.png](img_2.png)