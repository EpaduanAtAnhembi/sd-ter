package exemplo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4321;
        DatagramSocket clientSocket;
        InetAddress endereco;
        Scanner teclado = new Scanner(System.in);

        try {
            clientSocket = new DatagramSocket();
            endereco = InetAddress.getByName("127.0.0.1");
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        try {
            String mensagem  = " ";
            while (! mensagem.equalsIgnoreCase("exit")) {

                System.out.println("Digite a mensagem:");
                mensagem = teclado.nextLine();

                byte[] dados = mensagem.getBytes();

                DatagramPacket pacote = new DatagramPacket(dados,
                        dados.length, endereco, PORT);

                clientSocket.send(pacote);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
