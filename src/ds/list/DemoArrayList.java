package ds.list;

public class DemoArrayList {

    public static void main(String[] args) {
        CustomArrayList<Integer> lists = new CustomArrayList<>();
        lists.add(1);
        lists.add(10);
        lists.add(100);
        lists.add(100);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
