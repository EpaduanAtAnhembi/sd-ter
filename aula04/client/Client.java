package client;

import java.net.Socket;
import java.util.Scanner;

import util.Communication;
import util.Message;
import util.Response;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Socket socket = null;
        Communication communication;
        Message message;
        String ipServer = "127.0.0.1";
        int portServer = 5509;
        String playerName, playerInput;
        int fingers;

        try {

            System.out.printf("Informe o IP do servidor(default: %s): ", ipServer);
            playerInput = input.nextLine();
            if (playerInput.length() > 0) {
                ipServer = playerInput;
            }
            
            System.out.printf("Informe a porta do servidor(default: %d): ", portServer);
            playerInput = input.nextLine();
            if (playerInput.length() > 0) {
                portServer = Integer.parseInt(playerInput);
            }

            socket = new Socket(ipServer, portServer);
            
            communication = new Communication(socket);

            System.out.println("Qual seu nome?");
            playerName = input.nextLine();

            System.out.println("Quantos dedos?");
            fingers = input.nextInt();

            message = new Message(playerName, fingers);
            communication.send(message);

            Response response = (Response) communication.receive();

            System.out.println("Resposta: " + response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
                input.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}