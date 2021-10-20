import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends CalcImpl {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        CalcImpl obj = new CalcImpl();
        Registry registry = LocateRegistry.getRegistry(null);
        Calculation stub = (Calculation) UnicastRemoteObject.exportObject(obj,0);
        registry.bind("Calculation",stub);
        System.out.println("Server ready");
        Thread.sleep(Integer.MAX_VALUE);
    }
}