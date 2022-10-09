public class CircleDemo {
    public static void main(String[] args) {
        Circle test = new Circle(4.5);
        System.out.printf("Radius = %.3f\n", test.getRadius());
        System.out.printf("Area = %.3f\n", test.area());
        System.out.printf("Perimeter = %.3f\n", test.perimeter());
    }

}
