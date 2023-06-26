package coplit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아,
// 해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 합니다.
// 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.

//생성자 함수(Node)와 메소드(addChild)는 변경하지 않아야 합니다.

public class treeBFS {
    public static void main(String[] args) {
        treeBFS.tree root = new treeBFS.tree("1");
        treeBFS.tree rootChild1 = root.addChildNode(new treeBFS.tree("2"));
        treeBFS.tree rootChild2 = root.addChildNode(new treeBFS.tree("3"));
        treeBFS.tree leaf1 = rootChild1.addChildNode(new treeBFS.tree("4"));
        treeBFS.tree leaf2 = rootChild1.addChildNode(new treeBFS.tree("5"));
        ArrayList<String> output = bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5"]
    }
    private static ArrayList<String> bfs(tree node) {
        // 탐색을 위한 큐
        Queue<tree> queue = new LinkedList<>();
        // 결과
        ArrayList<String> result = new ArrayList<>();
        // 시작 노드
        queue.add(node);

        // 큐가 비어있지 않다면 반복
        while(!queue.isEmpty()) {
            // 새로운 변수에 시작 노드 할당
            tree cur = queue.poll();
            // 큐 값을 결과 리스트에 삽입
            result.add(cur.getValue());
            // 시작노드의 자식노드가 있다면
            if (cur.getChildrenNode() != null) {
                // 해당 자식 노드를 큐에 할당 후 while 반복
                queue.addAll(cur.getChildrenNode());
            }
        }
        return result;
    }
    //아래 클래스의 내용은 수정하지 말아야 합니다.
    private static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
