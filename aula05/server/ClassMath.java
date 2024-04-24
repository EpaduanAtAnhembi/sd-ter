package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lib.InterfaceMath;

public class ClassMath extends UnicastRemoteObject implements InterfaceMath {

    protected ClassMath() throws RemoteException {
        System.out.println("Objeto Math foi criado");
    }

    @Override
    public double somar(double n1, double n2) throws RemoteException {
        System.out.printf("calculando a soma %f + %f \n", n1, n2);
        return n1 + n2;
    }

    @Override
    public double subtrair(double n1, double n2) throws RemoteException {
        System.out.printf("calculando a diferença %f + %f \n", n1, n2);
        return n1 - n2;
    }
    
}
