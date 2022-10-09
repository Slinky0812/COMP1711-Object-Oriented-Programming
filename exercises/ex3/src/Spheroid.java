import java.util.Scanner;
import java.lang.Math;

public class Spheroid {
    public static void main(String[] args) {
        Scanner stdin = new Scanner( System.in );

        double equatorial;
        double polar;

        System.out.println("Enter equatorial radius in km: ");
        equatorial = stdin.nextDouble();
        if (equatorial <= 0) {
            System.out.println("Error: equatorial radius must be larger than 0");
            System.exit(0);
        }

        System.out.println("Enter polar radius in km: ");
        polar = stdin.nextDouble();
        if (polar <= 0) {
            System.out.println("Error: polar radius must be larger than 0");
            System.exit(0);
        }

        if (polar > equatorial) {
            System.out.println("Error: equatorial radius must be larger than polar radius");
            System.exit(0);
        }

        double eccentricity;
        eccentricity = Math.sqrt(1 - (Math.pow(polar, 2) / (Math.pow(equatorial, 2))));

        double volume;
        volume = ((4 * Math.PI * (Math.pow(equatorial, 2)) * polar) / 3);

        System.out.printf("Eccentricity = %.3f\n", eccentricity);
        System.out.printf("Volume = %g cubic km", volume);
    }
}