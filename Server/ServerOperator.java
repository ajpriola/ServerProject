import java.util.*;

public class ServerOperator {
    
    public static void main(String[] args) {
        System.out.println("Enter a port number to create the server");
        Scanner reader = new Scanner(System.in);
        int port = reader.nextInt();
        try {
            ServerManager server = new ServerManager(port);
        } catch (Exception e) {
            System.out.println("Error: invalid input.");
        }
    }

}