package obinox.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread{
    private static final int PORT = 8080;
    private static final Map<Integer, Socket> clientSockets = new HashMap<>();
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                int clientId = generateClientId();
                clientSockets.put(clientId, clientSocket);
                System.out.println("Client connected: " + clientSocket.getInetAddress() + " (ID: " + clientId + ")");
                executor.execute(new ClientHandler(clientId, clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int generateClientId() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }

    static class ClientHandler implements Runnable {
        private final int clientId;
        private final Socket clientSocket;

        public ClientHandler(int clientId, Socket clientSocket) {
            this.clientId = clientId;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client " + clientId + ": " + inputLine);
                    out.write("wepoewpo");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientSockets.remove(clientId);
            }
        }
    }
}
