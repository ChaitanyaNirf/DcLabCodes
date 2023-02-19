//HelloClient.java
import java.rmi.Naming;
import java.util.*;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            // String data = scanner.nextLine();
            int one = scanner.nextInt();
            int two = scanner.nextInt();
            HelloInterface Hello = (HelloInterface) Naming.lookup("//localhost/Hello");
            System.out.println(Hello.add(one, two));
            scanner.close();
        } catch (Exception e) {
            System.out.println("FAILED " + e);
        }
    }
}
