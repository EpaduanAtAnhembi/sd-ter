package exemplo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Server
 */
public class Server {
    public static void main(String[] args) {
        final int PORT = 4322;
        DatagramPacket pacote;
        byte[] dados = new byte[1024];
        DatagramSocket serverSocket;

        pacote = new DatagramPacket(dados, dados.length);

        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("Server disponível");
        } catch (SocketException e) {
            // e.printStackTrace();
            System.out.println("Erro. Porta em uso");
            return;
        }

        try {
            System.out.println("Aguardando dados...");
            serverSocket.receive(pacote);
            String mensagem = new String(pacote.getData());
            System.out.println("Dados recebidos: " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}