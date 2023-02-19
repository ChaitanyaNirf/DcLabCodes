// Hello.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {

    private String message;

    public Hello(String msg) throws RemoteException{
        message = msg;
    }
    
    

    @Override
    public String say() throws RemoteException {
        return message;
    }

    @Override
    public String send(String data) throws RemoteException {
        return data;
    }

    @Override
    public int add(int one, int two) throws RemoteException {
        return one+two;
    }
    
}
