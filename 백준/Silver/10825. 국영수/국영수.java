import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class S {
    String name;
    int kor;
    int eng;
    int math;

    public S(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<S> s = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            S data = new S(name, kor, eng, math);
            s.add(data);
        }

        s.sort((s1, s2) -> {
            if (s1.kor == s2.kor) {
                if (s1.eng == s2.eng) {
                    if (s1.math == s2.math) {
                        return s1.name.compareTo(s2.name);
                    } else {
                        return s2.math - s1.math;
                    }
                } else {
                    return s1.eng - s2.eng;
                }
            } else {
                return s2.kor - s1.kor;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (S student : s){
            sb.append(student.name).append('\n');
        }

        System.out.println(sb);
    }
}