import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient extends Thread{
    private Scanner scanner;
    private final int PORT = 1699;
    private BufferedReader in;
    private PrintWriter out;
    @Override
    public void run() {
        scanner = new Scanner(System.in);
        String address = "127.0.0.1";
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Please, enter your name: ");
            String s = scanner.nextLine();
            out.println("NAME" + s);
            String initName = in.readLine();
            System.out.println(initName);
            out = new PrintWriter(socket.getOutputStream(), true);
            Resender resender = new Resender(s, out, scanner);
            resender.start();
            while (true) {
                String line = in.readLine();
                System.out.println(line);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public static void main(String... args){
        ChatClient client = new ChatClient();
        System.out.println("Start");
        client.start();
    }
}
