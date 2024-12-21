import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    String item;
    String left;
    String right;

    Node(String item, String left, String right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Map<String, Node> tree = new HashMap<>();

    public static void preorder(Node node) {
        System.out.print(node.item);
        if (!node.left.equals(".")) {
            preorder(tree.get(node.left));
        }
        if (!node.right.equals(".")) {
            preorder(tree.get(node.right));
        }
    }

    public static void inorder(Node node) {
        if (!node.left.equals(".")) {
            inorder(tree.get(node.left));
        }
        System.out.print(node.item);
        if (!node.right.equals(".")) {
            inorder(tree.get(node.right));
        }
    }

    public static void postorder(Node node) {
        if (!node.left.equals(".")) {
            postorder(tree.get(node.left));
        }
        if (!node.right.equals(".")) {
            postorder(tree.get(node.right));
        }
        System.out.print(node.item);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            String item = inputs[0];
            String left = inputs[1];
            String right = inputs[2];
            tree.put(item, new Node(item, left, right));
        }

        preorder(tree.get("A"));
        System.out.println();
        inorder(tree.get("A"));
        System.out.println();
        postorder(tree.get("A"));
        System.out.println();

        scanner.close();
    }
}