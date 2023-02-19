//HelloInterface.java
import java.rmi.Remote;
import java.rmi.*;
public interface HelloInterface extends Remote {
    public String say() throws RemoteException;

    public String send(String data) throws RemoteException;

    public int add(int one, int two) throws RemoteException;
}
