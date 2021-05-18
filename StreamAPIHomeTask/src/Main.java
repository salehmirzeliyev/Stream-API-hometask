import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> plist = Arrays.asList(new Person(1,"Saleh", "Mirzeliyev","25")
                                        ,new Person(2,"Kamran", "Mirzeliyev","29")
                                        ,new Person(3, "Ali", "Aliyev","14")
                                        ,new Person(4,"Ayten", "Qurbanova","15"));
        System.out.println("siyahi");
        plist.stream().forEach(System.out::println);
        System.out.println("==================");

        Function<Person, Integer> intAge = p -> Integer.parseInt(p.getAge());
        Predicate<Person> over18 = p -> intAge.apply(p)>18;
        System.out.println("18 yasdan boyuk olanlar:");
        plist.stream().filter(over18).forEach(System.out::println);
        System.out.println("========================");

        float averageAge =(float) plist.stream().reduce(0, (avg, p) -> avg += intAge.apply(p), (avg, b) -> avg+=b)/ plist.size();
        System.out.println("siyahidaki insanlarin yaslarinin ededi ortasi:" + averageAge);
        System.out.println("=======================");

        float sumAgeOver18 = (float) plist.stream().filter(over18).reduce(0, (sum, p) -> sum += intAge.apply(p), (sum, a) -> sum += a);
        System.out.println("yasi 18-den yuxari olanlarin yaslari cemi: " + sumAgeOver18);
        System.out.println("=======================");

    }
}
