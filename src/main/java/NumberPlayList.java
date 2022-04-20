import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) myNumberList.add(i);
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("method 1:iterator value:" + i);
        }

        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("method 2 consumer implements:" + t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("method 3 for each anonymous class value:" + t);

            }
        });

        Consumer<Integer> myListAction = n -> {
            System.out.println("method 4 for each lamda implements value::" + n);
        };
        myNumberList.forEach(myListAction);

        myNumberList.forEach(n -> {
            System.out.println("method 5 for each lamda value::" + n);

        });//lamda
        List<Double>doubleList=new ArrayList<Double>();
        Function<Integer,Double> toDoubleFunction=n->n.doubleValue();
        Predicate<Integer> isEvenFunction=n->n>0&&n%2==0;
        List<Double> evenlist = new ArrayList<Double>();
        myNumberList.forEach(n->{
            doubleList.add(toDoubleFunction.apply(n));
        doubleList.forEach(n1->{
            if (isEvenFunction.test(n1.intValue()))
                evenlist.add(n1);
        });
                });

        myNumberList.forEach(n->{
            System.out.println("method 7 for each value of:" +n +"check even:"+isEvenFunction.test(n));
        });
        //java stream
        myNumberList.stream().forEach(n->{
            System.out.println(("Method 8 stream for each value::"+n));
        });
        }
}