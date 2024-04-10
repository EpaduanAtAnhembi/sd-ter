package exemplo;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String IP = "127.0.0.1"; //localhost
        final int PORT = 12345;
        Socket socket = null;
        Scanner teclado = null;
        PrintStream output = null;

        try {
            socket = new Socket(IP, PORT);
            
            output = new PrintStream(socket.getOutputStream());
            teclado = new Scanner(System.in);

            System.out.print("Digite a mensagem: ");
            String mensagem = teclado.nextLine();
            output.println(mensagem);
           
            System.out.println("enviado.");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        // fase de encerramento a conexão
        try {
            teclado.close();
            output.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
