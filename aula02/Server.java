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
        final int PORT = 4321;
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

        String mensagem = " ";
        // laço externo não derrba o servidor
        while (!mensagem.equalsIgnoreCase("exit")) {
            try {
                // laço interno, derruba o servidor
                // while (!mensagem.equalsIgnoreCase("exit")) {
                System.out.println("Aguardando dados...");

                dados = new byte[1024];
                pacote = new DatagramPacket(dados, dados.length);
                serverSocket.receive(pacote);
                mensagem = new String(pacote.getData()).trim();
                int n1 = Integer.parseInt(mensagem);

                dados = new byte[1024];
                pacote = new DatagramPacket(dados, dados.length);
                serverSocket.receive(pacote);
                mensagem = new String(pacote.getData()).trim();
                int n2 = Integer.parseInt(mensagem);

                System.out.println("Soma = : " + (n1 + n2));

            } catch (IOException e) {
                System.out.println("Erro ao receber os dados");
    
            } catch (Exception e) {
                System.out.println("Erro nos dados");
            }
        }
    }

}