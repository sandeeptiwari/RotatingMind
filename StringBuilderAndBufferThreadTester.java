public class StringBuilderAndBufferThreadTester{
	
	public static void main(String[] args)throws InterruptedException
	{
		//Thread 2
		Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();

		//main thread 1
        for (int i = 0; i < 100; i++)
        {
            Thread.sleep(10);
            StringContainer.addToSb("a");
        }

        System.out.println("1: " + StringContainer.getSb());
        System.out.println("1 length: " + StringContainer.getSb().length());
	}

}

class MyRunnable implements Runnable{
	
	public void run(){
		
		 for (int i = 0; i < 100; i++)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            StringContainer.addToSb("b");
        }

        System.out.println("2: " + StringContainer.getSb());
        System.out.println("2 length: " + StringContainer.getSb().length());
	}
}

/*
 * StringBuffer in the StringContainer. Since StringBuffer is thread-safe, at a time, only one thread can append to it, so the output is 
 * consistent - either both threads reported the length of the buffer as 200, like:
*/
class StringContainer
{
    private static final StringBuffer sb = new StringBuffer();

    public static StringBuffer getSb()
    {
        return sb;
    }

    public static void addToSb(String s)
    {
        sb.append(s);
    }
}

/*
 *UPDATE 2: There are two problems happening. The first problem of the contents of the StringBuilder not matching the length is 
 *			happening only in Eclipse and not when I run in command line (at least the 100+ times I ran it on command line it never happened).
 *			The second problem with ArrayIndexOutOfBoundsException should be to do with the internal implementation of StringBuilder class, 
 *			which keeps an array of chars and does an Arrays.copyOf when it expands the size. But it still beats me how a write is happening 
 *			before the size is expanded, no matter what the order of execution is.
 *			
 *			BTW, I am inclined to agree with @GreyBeardedGeek's answer that this whole exercise is a huge waste of time :-). 
 *			Sometimes we get to see only the symptoms i.e. the output of some code and wonder what is going wrong. This question declared a priori that 
 *			two threads are modifying a (very well-known) thread unsafe object.

 *UPDATE 3: Here is the official answer from Java Concurrency in Practice p. 
 *			35:In the absence of synchronization, the compiler, processor and runtime can do some downright weird things to the order in which operations 
 *			appear to execute. Attempts to reason about the order in which memory actions "must" happen in insufficiently synchronized multithreaded programs
 *			will almost certainly be incorrect.Reasoning about insufficiently synchronized concurrent programs is prohibitively difficult.
 *
 *
 */
class StringBuilderContainer
{
    private static final StringBuilder sb = new StringBuilder();

    public static StringBuilder getSb()
    {
        return sb;
    }

    public static void addToSb(String s)
    {
        sb.append(s);
    }
}