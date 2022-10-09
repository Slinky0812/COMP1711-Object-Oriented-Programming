import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Dataset {
    private ArrayList<Double> data;

    public Dataset(String filename) throws IOException {
        data = new ArrayList<Double>();
        try (Scanner input = new Scanner (Paths.get(filename))) {
            while (input.hasNextDouble()) {
                double value = input.nextDouble();
                data.add(value);
            }
            input.close();
        }
    }

    public int size() throws ArithmeticException {
        int length = data.size();

        return length;
    }

    public double meanValue() {
        double mean;
        double total = 0;

        if (data.size() == 0) {
            throw new ArithmeticException ("No data in the file");
        }

        for (int i = 0; i < data.size(); i++) {
            total = total + data.get(i);
        }

        mean = (total / data.size());
        return mean;
    }

}

