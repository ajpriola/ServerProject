import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerManager {

    private static Socket[] socketList;
    private int currentConnections = 0;
    private int serverLim = 5;
    private int port;
    private boolean running = false;
    private boolean accepting = true;
    ServerSocket serverSocket = null;

    public ServerManager(int portInput) {
        this.port = portInput;
        socketList = new Socket[serverLim];
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("ServerManager: SERVER CREATED");
        } catch (Exception e) {
            System.out.println("ServerManager: ERROR CREATING SERVER");
        }
        startServer();
    }

    public void startServer() {
        running = true;
        while(running) {
            if(accepting) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    SubServer sub = new SubServer(clientSocket);
                    sub.start();
                } catch (Exception e) {
                    System.out.println("ServerManager: ERROR CREATING NEW CONNECTION");
                }
            }

        }
        //No longer running
        try {
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("ServerManager: ERROR STOPPING SERVER");
        }
    }

    public void stopServer() {
        running = false;
    }

    public void addConnection() {
        currentConnections++;
    }

    public void removeConnection() {
        currentConnections--;
    }

}