package client;

import java.rmi.Naming;

import lib.InterfaceMath;

public class Client {
    public static void main(String[] args) {
        InterfaceMath math;

        try {
            math = (InterfaceMath) Naming.lookup("rmi://127.0.0.1:1099/calculadora");
            double resp = math.somar(15, 20);
            System.out.println("A soma é " + resp);

            math = (InterfaceMath) Naming.lookup("rmi://127.0.0.1:1099/calculadora");
            resp = math.subtrair(15, 20);
            System.out.println("A diferença é " + resp);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
