public class JITOptimization {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(JITOptimization::loop).start();
        Thread.sleep(1000);
        new Thread(JITOptimization::terminate).start();
    }

    public static void terminate(){
        flag = false;
        System.out.println("flag has been changed");
    }

    public static void loop(){
        boolean printOne = true;
        boolean flag = getFlag();
        while(flag){
            if(printOne) {
                printOne = false;
                System.out.println("I am in the loop");
            }
        }
        System.out.println("I am outside the loop");
    }

    private static boolean getFlag() {
        return flag;
    }
}
