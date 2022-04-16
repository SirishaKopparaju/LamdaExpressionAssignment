
@FunctionalInterface
interface ArithmeticOperation {
    public int calculate(int x,int y);
}
public class LambdaExpressionDemo {
    public static void main(String[] args) {
        ArithmeticOperation multiply=(x,y)->x*y;
        ArithmeticOperation addition=(x,y)->x+y;
        ArithmeticOperation divide=(x,y)->x/y;
        System.out.println(multiply.calculate(6,5));
        System.out.println(addition.calculate(6,5));
        System.out.println(divide.calculate(16,4));
    }

}
