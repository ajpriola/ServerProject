import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class SubServer extends Thread{

    private Socket socket = null;
    private ServerManager manager;

    public SubServer(Socket socket, ServerManager manager) {

        super("SubServer");
        this.socket = socket;
        this.manager = manager;

    }

    public void run(){
        //Read input and process here
        try {
            while(true) {
                //Read message from client
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();
                manager.recieveMessage(message);
            }
        } catch (Exception e) {

        }
    }
    //implement your methods here

    public void sendMessage(String message) {

    }
}