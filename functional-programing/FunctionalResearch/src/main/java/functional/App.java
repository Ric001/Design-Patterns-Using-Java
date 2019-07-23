package functional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        supplyLocalDate();
        supplyStringBuilders();
        consumePrintln();
        biConsume();
    }

    private static void supplyLocalDate() {
        Supplier<LocalDate> s1 = LocalDate::now; 
        Supplier<LocalDate> s2 = LocalDate::now;

        System.out.println(s1.get());
        System.out.println(s2.get());
    }

    private static void supplyStringBuilders() {
        Supplier<StringBuilder> builder = StringBuilder::new;
        Supplier<StringBuilder> b2 = () -> new StringBuilder();
        System.out.println(b2);
        System.out.println(builder.get());
        System.out.println(b2.get());
    }

    private static void consumePrintln() {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = (String value) -> System.out.println(value);
        
        c1.accept("value");
        c2.accept("valueII");
    }

    private static void biConsume() {
        Supplier<HashMap<String, String>> mapSupplier = HashMap::new;
        Map<String, String> map = mapSupplier.get();
        BiConsumer<String, String> biconsumerMap = map::put;
        
        biconsumerMap.accept("Hello", "Hello");
        biconsumerMap.accept("Cant stop", "The feeling");
        
        System.out.println(map);
    }
}
