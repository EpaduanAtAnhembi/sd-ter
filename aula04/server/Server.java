package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int portServer = 5509;
        Scanner input = new Scanner(System.in);
        String inputData;

        System.out.printf("Informe a porta do servidor(default: %d): ", portServer);
        inputData = input.nextLine();
        portServer = inputData.length() > 0 ? Integer.parseInt(inputData) : portServer;

        try {
            serverSocket = new ServerSocket(portServer);
            input.close();

            while (true) {
                System.out.println("Aguardando cliente...");
                Socket player = serverSocket.accept();
                System.out.println("Conectado com " + player);

                PlayMatch playMatch = new PlayMatch(player);
                playMatch.start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
