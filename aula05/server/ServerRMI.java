package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ServerRMI
 */
public class ServerRMI {

    public static void main(String[] args) {
        Registry registry;

        try {
            // cria um novo Registry e disponibiliza na porta 1099
            registry = LocateRegistry.createRegistry(1099);

            ClassMath objMath = new ClassMath(); 

            // registra o objeto para uso pelos clientes
            registry.rebind("calculadora", objMath);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}