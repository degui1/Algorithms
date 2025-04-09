import java.util.*;

public class BreadthFirstSearch {
    private final Set<String> verifiedList = new HashSet<>();

    public boolean searchQueue(String name) {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("you", Arrays.asList("Alice", "Bob", "Claire"));
        graph.put("Alice", List.of("Peggy"));
        graph.put("Bob", Arrays.asList("Ana", "Peggy"));
        graph.put("Claire", Arrays.asList("Thom", "Jonny"));
        graph.put("Ana", List.of());
        graph.put("Peggy", List.of());
        graph.put("Thom", List.of());
        graph.put("Jonny", List.of());

        ArrayDeque<String> searchQueue = new ArrayDeque<>(graph.get("you"));

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();

            if (person != null && !verifiedList.contains(person)) {
                if (Objects.equals(person, name)) {
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    verifiedList.add(person);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        boolean wasPersonFound = breadthFirstSearch.searchQueue("Jonny");

        System.out.printf("Was the person find?: %b \n", wasPersonFound);
    }
}
