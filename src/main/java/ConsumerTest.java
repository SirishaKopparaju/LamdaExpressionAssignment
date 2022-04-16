import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> displaydata=a->System.out.println(a);
        displaydata.accept(String.valueOf(10));
        Consumer<List<Integer>> modify = list->
        {
            for(int i=0;i<list.size();i++)
                list.set(i, list.get(i)*list.get(i));

        };
        Consumer<List<Integer>>
                display=list->list.stream().forEach(a->System.out.println(a+""));
        List<Integer> list =new ArrayList<Integer>();
        list.add(10);
        list.add(2);
        list.add(3);
        modify.accept(list);
        display.accept(list);

    }
}
