import java.util.ArrayList;
import java.util.List;

public class Recursive {
    public static int sum(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        return list.getFirst() + sum(list.subList(1, list.size()));
    }

    public static int count(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        return 1 + count(list.subList(1, list.size()));
    }

    public static void main(String[] args) {
        System.out.println(sum(new ArrayList<>(List.of(1, 2, 5))));
        System.out.println(count(new ArrayList<>(List.of(1, 2, 5))));
    }
}
