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

    public SubServer(Socket socket) {

        super("SubServer");
        this.socket = socket;

    }

    public void run(){
            //Read input and process here
    }
            //implement your methods here

    public void sendMessage(String message) {
        
    }
}