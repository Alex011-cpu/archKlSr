import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(null);
        Calculation stub = (Calculation) registry.lookup("Calculation");
        int cont = 1;
        Scanner scanner = new Scanner(System.in);
        while (cont == 1) {
            Double[] result = stub.solveEquation(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
            System.out.println("Roots:");
            Arrays.stream(result).forEach(System.out::println);
            System.out.println("Cont?:\n1 - Yes\n2 - No");
            cont = scanner.nextInt();
            System.out.println();
        }
    }
}
