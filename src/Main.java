import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File ("D:/test.txt");
        FileOutputStream stream = new FileOutputStream (file);
        stream.write ("hello".getBytes ());
        System.out.println("Hello DataStructsAndAlgorithmn!");
    }
}
