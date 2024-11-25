package OtherProjects;
public class NoGarbage {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("garbage");
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
