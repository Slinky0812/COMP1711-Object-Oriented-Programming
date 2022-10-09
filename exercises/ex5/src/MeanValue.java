public class MeanValue {
    public static double meanValue(double[] data) {
        int i;
        double total;
        i = 0;
        total = 0;
        while (i < data.length) {
            total = total + data[i];
            i += 1;
        }
        double mean;
        mean = total / data.length;
        return mean;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.print("Usage: java MeanValue <values...>");
            System.exit(1);
        }

        double[] values = new double[args.length];
        for (int j = 0; j < args.length; j++) {
            values[j] = Double.parseDouble(args[j]);
        }
        double average;
        average = meanValue(values);
        System.out.printf("Mean value = %.3f", average);
    }
}