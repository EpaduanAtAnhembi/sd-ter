package server;

import java.net.Socket;
import java.util.Random;

import util.Communication;
import util.Message;
import util.Response;

public class PlayMatch extends Thread {
    private Communication communicationPlayer1, communicationPlayer2;

    public PlayMatch(Socket client1) {
        communicationPlayer1 = new Communication(client1);
        communicationPlayer2 = null;
    }

    @Override
    public void run() {
        if (communicationPlayer2 == null) {
            playSingle();
        } else {
            playDuo();
        }
    }

    private void playSingle() {
        Random random = new Random();
        Response response;

        try {
            Message messagePlayer1 = (Message) communicationPlayer1.receive();

            Message messageServer = new Message("Server", random.nextInt(6));

            boolean isEven = (messagePlayer1.getPoints() + messageServer.getPoints()) % 2 == 0;

            if (isEven) {
                response = new Response("Servidor", messageServer.getPoints() + " X " + messagePlayer1.getPoints());
            } else {
                response = new Response(messagePlayer1.getPlayerName(), messagePlayer1.getPoints() + " X " + messageServer.getPoints());
            }

            communicationPlayer1.send(response);

        } catch (Exception e) {

        } finally {
            try {
                communicationPlayer1.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playDuo() {
    }
}
