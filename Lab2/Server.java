import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[] args) throws IOException {
    
        ServerSocket ss = new ServerSocket(8000);
        Socket socket = ss.accept();

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage = "", serverMessage="";

        while(!clientMessage.equals("stop") && !serverMessage.equals("stop")){
            System.out.println("Waiting for client's reply....");
            clientMessage = din.readUTF();
            System.out.println("Client: "+clientMessage);
            System.out.println("Enter Message:");
            serverMessage = br.readLine();
            dout.writeUTF(serverMessage);
            dout.flush();
        }

        din.close();
        socket.close();
        ss.close();




        
    }
}