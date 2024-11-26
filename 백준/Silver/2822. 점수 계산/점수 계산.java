import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        
        // Taking input for scores
        for (int i = 0; i < 8; i++) {
            scores.add(scanner.nextInt());
        }
        
        ArrayList<Integer> selectedIndexes = new ArrayList<>();
        int answer = 0;
        
        // Selecting maximum scores
        for (int i = 0; i < 5; i++) {
            int maxScore = Collections.max(scores);
            answer += maxScore;
            int index = scores.indexOf(maxScore);
            selectedIndexes.add(index + 1); // Store 1-based index
            scores.set(index, -1); // Mark this score as used by setting it to -1
        }
        
        // Sort the indexes before printing
        Collections.sort(selectedIndexes);
        System.out.println(answer);
        for (int index : selectedIndexes) {
            System.out.print(index + " ");
        }
    }
}