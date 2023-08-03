import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter r = new BufferedWriter(new FileWriter(new File("./0testCase.txt")));
        int[] data = new int[300000];
        for (int i = 0; i < data.length; i ++) {
            data[i] = new Random().nextInt();
        }
        r.write("'" + Arrays.toString(data) + "'");
        r.flush();
        r.close();
        
    }
}
