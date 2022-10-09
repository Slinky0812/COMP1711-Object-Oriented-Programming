public class CircleDemo {
    public static void main(String[] args) {
        Circle test = new Circle(1);
        System.out.printf("Radius = %.3f\n", test.getRadius());
        System.out.printf("Area = %.3f\n", test.area());
        System.out.printf("Perimeter = %.3f\n", test.perimeter());
        System.out.printf("%s\n", test.toString());

        Circle test2 = new Circle(1.00005);
        boolean value = test2.equals(test);
        System.out.printf("%s", value);
    }
}
