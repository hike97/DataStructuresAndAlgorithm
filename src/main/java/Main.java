import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        File file = new File ("D:/test.txt");
//        FileOutputStream stream = new FileOutputStream (file);
//        stream.write ("hello".getBytes ());
//        System.out.println("Hello DataStructsAndAlgorithmn!");

    }
}
//        File file = new File ("D:/test.txt");
//        FileOutputStream stream = new FileOutputStream (file);
//        stream.write ("hello".getBytes ());
//        System.out.println("Hello DataStructsAndAlgorithmn!");
//        List<String> list = Arrays.asList ("1", "2", "3", "3", "2", "1");
//        list.stream ().collect (Collectors.toSet ()).forEach (System.out::println);
        List<Book> list = new ArrayList<> ();
        {
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 200));
            list.add(new Book("Learning Freemarker", 150));
            list.add(new Book("Spring MVC", 300));
            list.add(new Book("Spring MVC", 300));
        }
//        list.stream ().collect (Collectors.toSet ()).forEach (System.out::println);
//        long l = list.stream().distinct().count();
//        System.out.println("No. of distinct books:"+l);
//        list.stream().distinct().forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));

        list.stream().filter(distinctByKey(b -> b.getName()))
                .forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));

    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<> ();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    static class Book {
        private String name;
        private int price;
        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public int getPrice() {
            return price;
        }
        @Override
        public boolean equals(final Object obj) {
            if (obj == null) {
                return false;
            }
            final Book book = (Book) obj;
            if (this == book) {
                return true;
            } else {
                return (this.name.equals(book.name) && this.price == book.price);
            }
        }
        @Override
        public int hashCode() {
            int hashno = 7;
            hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
            return hashno;
        }
    }
}

