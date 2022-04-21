import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        List<Double> doubleList = new ArrayList<Double>();
        Function<Integer, Double> toDoubleFunction = n -> n.doubleValue();
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
        List<Double> evenlist = new ArrayList<Double>();
        myNumberList.forEach(n -> {
            doubleList.add(toDoubleFunction.apply(n));
            doubleList.forEach(n1 -> {
                if (isEvenFunction.test(n1.intValue()))
                    evenlist.add(n1);
            });
        });

        myNumberList.forEach(n -> {
            System.out.println("method 7 for each value of:" + n + "check even:" + isEvenFunction.test(n));
        });
        //java stream
        myNumberList.stream().forEach(n -> {
            System.out.println(("Method 8 stream for each value::" + n));
        });
        //processing stream and apply the operations and store it
        List<Double> StreamList = myNumberList.stream()
                .filter(isEvenFunction)
                .map(toDoubleFunction)
                .collect(Collectors.toList());
        System.out.println(("method 9 printing Double list:" + StreamList));

        //listing the first even number
        Integer first = myNumberList.stream().filter(isEvenFunction)
                .peek(n -> System.out.println("peek even number" + n))
                .findFirst()
                .orElse(null);
        System.out.println("method 10 first even" + first);
        Integer min =myNumberList.stream()
                .filter(isEvenFunction)
                .min((n1,n2)->n1-n2).orElse(null);
        System.out.println("method 11 min even"+min);
        Integer max = myNumberList.stream().filter(isEvenFunction)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println("method 12 max even:"+max);
        //find sum n avg
        Integer sum = myNumberList.stream()
                .reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("method 11 avg of"+sum+"/"+count+"="+sum/count);
        boolean allEven = myNumberList.stream().filter(isEvenFunction).allMatch(isEvenFunction);
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean noneMultOfSix = myNumberList.stream().noneMatch(i->i>0&&i%6==0);
        System.out.println("allEven:"+allEven+"oneEven:"+oneEven+"noneMultOfSix"+noneMultOfSix);
        List<Integer> sortedList = myNumberList.stream()
                .sorted((n1,n2)->n2.compareTo(n1))
                .collect(Collectors.toList());
        System.out.println("method 12 sorted list"+sortedList);
    }
}