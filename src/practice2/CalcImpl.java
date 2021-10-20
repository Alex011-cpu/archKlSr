import java.rmi.RemoteException;

public class CalcImpl implements Calculation{

    @Override
    public Double[] solveEquation(double a, double b, double c) throws RemoteException {
        Double root1 = null;
        Double root2 = null;
        double determinant = b * b - 4 * a * c;
        if (a == 0 ) {
            return new Double[]{root1, root2};
        }
        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
        } return new Double[]{root1, root2};
     }
}

