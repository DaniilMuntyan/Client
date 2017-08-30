import java.io.*;
import java.net.*;
import java.util.*;

public class Resender extends Thread{
    private Scanner scanner;
    private String s;
    private PrintWriter out;
    private Socket socket;
    Resender(String s, PrintWriter out, Scanner scanner){
        this.scanner = scanner;
        this.socket = socket;
        this.out = out;
        this.s = s;
    }
    Resender(){}
    @Override
    public void run(){
        while(true){
            String toSend = scanner.nextLine();
            out.println("User " + this.s + " sent: " + toSend);
        }
    }
}