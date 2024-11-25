package OtherProjects;
public class GarbageCreator {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String s = "garbage" + i;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
