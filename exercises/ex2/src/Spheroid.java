import java.util.Scanner;
import java.lang.Math;

public class Spheroid {
    public static void main(String[] args) {
        Scanner stdin = new Scanner( System.in );

        double equatorial;
        System.out.println("Enter equatorial radius in km: ");
        equatorial = stdin.nextDouble();

        double polar;
        System.out.println("Enter polar radius in km: ");
        polar = stdin.nextDouble();

        double eccentricity;
        eccentricity = Math.sqrt(1 - ((polar * polar) / (equatorial * equatorial)));

        double volume;
        volume = ((4 * Math.PI * (Math.pow(equatorial, 2)) * polar) / 3);

        System.out.printf("Eccentricity = %.3f\n", eccentricity);
        System.out.printf("Volume = %g cubic km", volume);
    }
}
