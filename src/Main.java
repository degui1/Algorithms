import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int searchMinor(List<Integer> list) {
        int minor = list.getFirst();
        int minor_index = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int element = list.get(i);
            if (element < minor) {
                minor = element;
                minor_index = i;
            }
        }

        return minor_index;
    }

    private static List<Integer> selectionSort(List<Integer> list) {

        List<Integer> sortedArray = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int minor = searchMinor(list);
            sortedArray.add(list.remove(minor));
        }

        return sortedArray;
    }

    private static int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        int interactions = 0;

        while (low <= high) {
            interactions++;

            int middle = (low + high) / 2;
            int shoot = list[middle];

            if (shoot == item) {
                System.out.printf("interactions: %s", interactions);
                return middle;
            } else if (shoot > item) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int [] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int item = 6;

        System.out.printf("index: %d", binarySearch(list, item));

        List<Integer> unsortedArray = new ArrayList<>(Arrays.asList(3, 8, 5, 12, 9, 6, 7, 2, 10));

        System.out.printf("sortedArray %s", selectionSort(unsortedArray).toString());
    }
}

