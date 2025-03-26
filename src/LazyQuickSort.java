import java.util.ArrayList;
import java.util.List;

/*
 * LazyQuickSort because we always use the first element as pivot.
 * */
public class LazyQuickSort {
    public static List<Integer> quickSort(List<Integer> unsortedArray) {
        if (unsortedArray.size() < 2) {
            return unsortedArray;
        } else {
            int pivot = unsortedArray.getFirst();
            List<Integer> minor = new ArrayList<>();
            List<Integer> bigger = new ArrayList<>();

            for (int i = 1; i < unsortedArray.size(); i++) {
                int element = unsortedArray.get(i);

                if (element < pivot) minor.add(element);
                else if (element > pivot) bigger.add(element);
            }

            List<Integer> sortedList = new ArrayList<>(quickSort(minor));
            sortedList.add(pivot);
            sortedList.addAll(quickSort(bigger));

            return sortedList;
        }
    }

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>(List.of(3, 6, 8, 10, 1, 2, 50));
        System.out.print(quickSort(unsortedList));
    }
}
