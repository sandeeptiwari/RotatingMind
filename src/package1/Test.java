package package1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    
    public static void main(String...args){
        /*Set<String> s =  new HashSet<String>();
        Boolean []   b =  new Boolean [5];
        b[0]=s.add   ("e");
        b[1]=s.add   ("a");
        b[2]=s.add   ("b");
        b[3]=s.add   ("a");
        b[4]=s.add   ("c");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        System.out.println(s);*/

       /* Set s =  new TreeSet();
        s.add ("1");
        s.add (new Integer(5));
        s.add (new String("2"));*/
        //s.add (new Object());
        //classCastException will ocure
        //What is the output?
        //System.out.print (s);

        try  {
              int a = 1/0;
            System.out.println ("A");
        }catch (ArithmeticException e){
            System.out.println("BB-");
        }
        catch (RuntimeException re)   {
            System.out.println("B");
        } catch ( Exception e ) {
            System.out.println("C");
        }  finally  {
            System.out.println("d");
        }
        //System.out.println("e");
    }
}
