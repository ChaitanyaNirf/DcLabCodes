import java.net.*;
import java.io.*;
 
public class Client{
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8000);

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage="", serverMessage ="";

        while(!clientMessage.equals("stop") && !serverMessage.equals("stop")){
            System.out.println("Enter response: ");
            clientMessage = br.readLine();
            dout.writeUTF(clientMessage);
            dout.flush();
            System.out.println("Waiting for Server's Reply...");
            serverMessage = din.readUTF();
            System.out.println("Server says: "+ serverMessage);

        }

        dout.close();
        socket.close();
    
    }
}