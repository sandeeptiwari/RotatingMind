`arr = [4, 5, 2, 10, 8]`


Initial Setup:

    stack = [] (empty at the start)
    
    result = [-1, -1, -1, -1, -1] (initialized with -1)
    
    Loop iterates right to left (from index n-1 to 0).

Step 1: Processing arr[4] = 8

    Stack before: [] (empty)
    
    No greater element exists on the right.
    
    Result: result[4] = -1
    
    Stack after: [8] (Push 8 into stack)

Step 2: Processing arr[3] = 10

Stack before: [8]

    Since stack.peek() = 8 is less than 10, pop 8.
    
    Stack is now empty, so no greater element exists.
    
    Result: result[3] = -1
    
    Stack after: [10] (Push 10 into stack)

Step 3: Processing arr[2] = 2

    Stack before: [10]
    
    stack.peek() = 10 is greater than 2, so do not pop.
    
    Result: result[2] = 10 (10 is the next greater element)
    
    Stack after: [10, 2] (Push 2 into stack)

Step 4: Processing arr[1] = 5

    Stack before: [10, 2]
    
    stack.peek() = 2 is less than 5, so pop 2.
    
    Now, stack.peek() = 10 is greater than 5, so do not pop.
    
    Result: result[1] = 10 (10 is the next greater element)
    
    Stack after: [10, 5] (Push 5 into stack)

Step 5: Processing arr[0] = 4

    Stack before: [10, 5]
    
    stack.peek() = 5 is greater than 4, so do not pop.
    
    Result: result[0] = 5 (5 is the next greater element)
    
    Stack after: [10, 5, 4] (Push 4 into stack)

**Final Output:**

[5, 10, 10, -1, -1]
Final Stack and Result Array States

    Index (i)	arr[i]	Stack Before	Action Taken	                    Stack After	    result[i]
    4	        8	        []	        No greater element (stack empty)    [8]	                -1
    3	        10	        [8]	        Pop 8, No greater element left	    [10]	            -1
    2	        2	        [10]	    10 is greater, store 10	             [10, 2]	        10
    1	        5	        [10, 2]	    Pop 2, 10 is greater, store 10                      	[10, 5]     	    10
    0	        4	        [10, 5]	    5 is greater, store 5	             [10, 5, 4]	        5

**Understanding the Stack Mechanism**

The stack stores elements in decreasing order.

If a smaller element appears, we pop it (since it can never be a next greater element).

The top of the stack is always the next greater element for the current number.

If the stack is empty, there's no greater element, so we assign -1.