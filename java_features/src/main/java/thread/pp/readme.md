1. HDD is mechanical device and block read by touching 
2. When talk mechanical devices data like file :: parallel reads and random seeks
 make like much more worst reading process than sequential read.
3. Thread is just a kind of task reside into program

Thread: 

we can not catch thread exception into parent thread because 
both is running in separate stack

Concurrency vs Parallelism::

If we have two processor one process will focus on task-1 and other process will focus on task-2: parallelism

But if we had 1 processor and in that case time slicing will occur which is known as concurrency
 - multiple task can be start and progess at same time
 - System is more responsive reduce CPU idle time
 - build fault tolerance and resilience sw
