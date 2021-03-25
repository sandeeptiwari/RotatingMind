package design_pattern.singlton;

public class InnerSingleton {
   private InnerSingleton() {}

    public static class Holder {
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return Holder.INSTANCE;
    }

}
