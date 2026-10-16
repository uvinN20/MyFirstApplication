package ChatThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server_Threads extends Thread {
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner scannerInput;
    private int client_id;

    public Server_Threads(Socket client_socket, int cid) throws IOException {
        this.client = client_socket;
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.scannerInput = new Scanner(System.in);
        this.client_id = cid;
    }

    @Override
    public void run() {
        try {
            out.println("Welcome To Chat Application");

            while (true) {
                String input = in.readLine();
                if (input == null) {
                    break;
                }

                System.out.println("Client " + client_id + " says: " + input);
                System.out.print("Server: ");
                String output = scannerInput.nextLine();

                out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) client.close();
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}