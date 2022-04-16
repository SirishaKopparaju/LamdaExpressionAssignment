
@FunctionalInterface
interface ArithmeticOperation {
    public int calculate(int x,int y);
    public static int addition(int x, int y) {
        return x + y;
    }
        public static int multiply(int x,int y){
            return x*y;

        }

    public static int divide(int x,int y){
        return x/y;

    }


}
public class LambdaExpressionDemo {
    public static void main(String[] args) {
        ArithmeticOperation multiply=(x,y)->x*y;
        ArithmeticOperation addition=(x,y)->x+y;
        ArithmeticOperation divide=(x,y)->x/y;
        System.out.println(multiply.calculate(6,5));
        System.out.println(addition.calculate(6,5));
        System.out.println(divide.calculate(16,4));
        System.out.println(ArithmeticOperation.addition(6,7));
        System.out.println(ArithmeticOperation.multiply(6,7));
        System.out.println(ArithmeticOperation.divide(6,2));


    }

}
