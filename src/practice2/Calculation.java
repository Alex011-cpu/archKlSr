import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculation extends Remote {
    Double[] solveEquation(double a, double b, double c) throws RemoteException;
}
