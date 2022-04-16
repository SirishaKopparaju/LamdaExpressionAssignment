import java.util.function.Predicate;

public class PredicateTest {
    static void pred(int number,Predicate<Integer> Predicate)
    {
        if(Predicate.test(number)){
            System.out.println("Number"+number);
        }
    }
    public static void main(String[] args) {
        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(10));
        Predicate<Integer> greaterthanten = (i) -> i > 10;
        Predicate<Integer> lowerthantwenty = (i) -> i < 20;
        boolean result = greaterthanten.or(lowerthantwenty).test(15);
        System.out.println(result);
        boolean result2 = greaterthanten.and(lowerthantwenty).negate().test(14);
        System.out.println(result2);
        pred(10, (i) ->i > 7);
    }



    }

