//HelloServer.java
import java.io.*;
import java.rmi.*;
public class HelloServer {
    public static void main(String[] args) {
        try {
            Hello robj = new Hello("Hello World");
            // Naming.rebind("Hello", robj);
            Naming.rebind("Hello", robj);
            System.out.println("Hello Server is ready");
        } catch (Exception e) {
            System.out.println("Hello Server Error" + e);
        }
    }
}
