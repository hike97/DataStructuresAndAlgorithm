import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) throws IOException {
//        File file = new File ("D:/test.txt");
//        FileOutputStream stream = new FileOutputStream (file);
//        stream.write ("hello".getBytes ());
//        System.out.println("Hello DataStructsAndAlgorithmn!");

//        List<Book> list = new ArrayList<> ();
//        {
//            list.add(new Book("Core Java", 200));
//            list.add(new Book("Core Java", 200));
//            list.add(new Book("Learning Freemarker", 150));
//            list.add(new Book("Spring MVC", 300));
//            list.add(new Book("Spring MVC", 300));
//        }
//          list.stream().filter(distinctByKey(b -> b.getName()))
//                .forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));

//        int a[] = {4, 3, 6, 5, 1, 2};
//        int b[] = Arrays.copyOf(a, 4);
//        int c[] = Arrays.copyOfRange(a, 2, 4 + 1);
//
//        for (int i = 0; i < b.length; i++)
//            System.out.print(b[i] + " ");
//        System.out.println();
//
//        for (int i = 0; i < c.length; i++)
//            System.out.print(c[i] + " ");
//        System.out.println();
        byte[] bytes = "秦始皇".getBytes ();
        System.out.println (Arrays.toString (bytes));

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

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<> ();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
//        File file = new File ("D:/test.txt");
//        FileOutputStream stream = new FileOutputStream (file);
//        stream.write ("hello".getBytes ());
//        System.out.println("Hello DataStructsAndAlgorithmn!");
//        List<String> list = Arrays.asList ("1", "2", "3", "3", "2", "1");
//        list.stream ().collect (Collectors.toSet ()).forEach (System.out::println);

//        list.stream ().collect (Collectors.toSet ()).forEach (System.out::println);
//        long l = list.stream().distinct().count();
//        System.out.println("No. of distinct books:"+l);
//        list.stream().distinct().forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));





