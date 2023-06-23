package coplit;

import java.util.ArrayList;

//임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아,
// 해당 노드를 시작으로 깊이 우선 탐색(DFS, Depth First Search)을 합니다.
// 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.

//생성자 함수(Node)와 메소드(addChild)는 변경하지 않아야 합니다.

public class treeDFS {
    public static void main(String[] args) {
        treeDFS.tree root = new treeDFS.tree("1");
        treeDFS.tree rootChild1 = root.addChildNode(new treeDFS.tree("2"));
        treeDFS.tree rootChild2 = root.addChildNode(new treeDFS.tree("3"));
        treeDFS.tree leaf1 = rootChild1.addChildNode(new treeDFS.tree("4"));
        treeDFS.tree leaf2 = rootChild1.addChildNode(new treeDFS.tree("5"));
        ArrayList<String> output = dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "5", "3"]
    }
    public static ArrayList<String> dfs(tree node) {
        // 결과
        ArrayList<String> values = new ArrayList<>();
        // 시작 노드
        values.add(node.getValue());

        // 자식 노드가 있으면
        if (node.getChildrenNode() != null) {
            // 자식노드 만큼 반복
            for (int i = 0; i < node.getChildrenNode().size(); i++) {
                // 재귀 사용해서 도달하는 자식 노드를 cur에 할당
                ArrayList<String> cur = dfs(node.getChildrenNode().get(i));
                // 처리가 완료되면 cur을 결과 리스트로
                values.addAll(cur);
            }
        }
        return values;
    }
    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
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
