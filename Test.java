import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String s = "123";
        List<String> list = Stream.of(s.split("")).collect(Collectors.toList());
        System.out.println((int)')');
    }
}