import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    private static List<String> list;

    public static void main(String[]args){
        list = new ArrayList<>();
        list.add("Hallo");
        list.add("Java");
        list.add("Strings");
        list.add("Welt");

        for(String str : list){
            System.out.println(str);
        }
        list.forEach((String s) -> System.out.println(s));
        list.forEach(System.out::print);

        NumberTester number = new NumberTester("Tester.csv");
        number.testFile();
    }
}
