package ChatThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat_Server {

    private static final int port = 8875;

    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Chat Server");
        System.out.println("\t\t======================\n");

        ServerSocket serverSocket = new ServerSocket(port);
        int current_clients = 0;

        try {
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client is connected.............\n\n");

                Server_Threads ct = new Server_Threads(client, current_clients + 1);
                ct.start();
                current_clients++;
            }
        } finally {
            serverSocket.close();
        }
    }
}