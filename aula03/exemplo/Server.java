package exemplo;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
         final int PORT = 12345;
        ServerSocket serverSocket;
        Socket clientSocket = null;
        Scanner input = null;
        String resposta;

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Aguardando cliente...");
                clientSocket = serverSocket.accept();

                input = new Scanner(clientSocket.getInputStream());

                System.out.println("Aguardando mensagem do cliente...");
                resposta = input.nextLine();

                System.out.println("Recebido: " + resposta);

                input.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        // serverSocket.close();
    }
}
