import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, List<String>> save = new HashMap<>();
        
        save.put(1, Arrays.asList("1"));
        save.put(2, Arrays.asList("1+1", "2"));
        save.put(3, Arrays.asList("1+2", "1+1+1", "2+1", "3"));
        
        for (int i = 4; i < 12; i++) {
            List<String> currentList = new ArrayList<>();
            for (String j : save.get(i - 1)) {
                currentList.add(j + "+1");
            }
            for (String j : save.get(i - 2)) {
                currentList.add(j + "+2");
            }
            for (String j : save.get(i - 3)) {
                currentList.add(j + "+3");
            }
            save.put(i, currentList);
        }
        
        List<String> resultList = save.get(n);
        if (k <= resultList.size()) {
            Collections.sort(resultList);
            System.out.println(resultList.get(k - 1));
        } else {
            System.out.println(-1);
        }
        
        scanner.close();
    }
}