import java.util.Scanner;

public class Weight {
    public static void main(String[] args) {
        Scanner stdin = new Scanner( System.in );
        double weightInMetric;
        double totalImperialWeight;
        int weightInPounds;
        double weightInOunces;

        System.out.println("Enter Weight in Kilograms: ");
        weightInMetric = stdin.nextDouble();

        totalImperialWeight = weightInMetric * 35.274;
        weightInPounds = (int) (totalImperialWeight / 16);
        weightInOunces = ((totalImperialWeight / 16) - weightInPounds) * 16;

        System.out.printf("Equivalent imperial weight is %d lb %.1f oz", weightInPounds, weightInOunces);
    }
}