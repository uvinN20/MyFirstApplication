package ChatThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Chat_Client {

    static int port = 8875; // Matched with Chat_Server port

    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Simple Socket Client");
        System.out.println("\t\t ====================\n\n");

        Scanner scannerInput = new Scanner(System.in);
        InetAddress ipAddress = InetAddress.getLocalHost();
        Socket socket = new Socket(ipAddress, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        try {
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    break;
                }

                System.out.println("Server says: " + input);
                System.out.print("Client: ");

                String output = scannerInput.nextLine();
                out.println(output);
            }
        } finally {
            socket.close();
            out.close();
            in.close();
            scannerInput.close();
        }
    }
}