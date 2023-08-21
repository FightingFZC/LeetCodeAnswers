public class Test {
    public static void main(String[] args) {
        int i = 1, j = i, k = j;
        int t = 10;
        while (t -- > 0) {
            System.out.printf("%d, %d, %d %n", i, j, k);
        }

    }
}