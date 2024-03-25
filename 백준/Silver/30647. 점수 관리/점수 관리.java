import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class User implements Comparable<User>{
    private String name;
    private int score;
    private boolean isHidden;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public int compareTo(User other) {
        if (this.score == other.score) {
            return this.name.compareTo(other.name);
        }
        return other.score - this.score;
    }
}
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder json = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            json.append(line);
        }

        // Json 파싱 (표준 라이브러리만 사용)
        json = new StringBuilder(json.toString().trim().replaceAll("\\[|\\]", "")); // 대괄호 제거
        String[] userStrings = json.toString().split("\\},\\{");

        ArrayList<User> users = new ArrayList<>();
        for (String userString : userStrings) {
            userString = userString.replaceAll("\\{|\\}", ""); // 중괄호 제거
            String[] keyValuePairs = userString.split(",");
            User user = new User();

            for (String pair : keyValuePairs) {
                String[] entry = pair.split(":");
                String key = entry[0].trim().replaceAll("^\"|\"$", ""); // 따옴표 제거
                String value = entry[1].trim().replaceAll("^\"|\"$", ""); // 따옴표 제거

                switch (key) {
                    case "name" :
                        user.setName(value);
                        break;
                    case "score" :
                        user.setScore(Integer.parseInt(value));
                        break;
                    case "isHidden" :
                        user.setHidden(value.equals("1"));
                        break;
                }
            }

            users.add(user);
        }

        // 점수 기준 내림차순 (user 클래스에서 구현됨)
        Collections.sort(users);

        int rank = 1;
        for (int i = 0; i < users.size(); i++) {
            if (i > 0 && users.get(i).getScore() != users.get(i - 1).getScore()) {
                rank = i + 1;
            }
            if (!users.get(i).isHidden()) {
                System.out.println(rank + " " + users.get(i).getName() + " " + users.get(i).getScore());
            }
        }
    }
}