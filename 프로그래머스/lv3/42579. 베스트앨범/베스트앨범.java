import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {

    }

    public class Music implements Comparable<Music> {
        private int played;
        private int id;
        private String genre;

        public Music(int played, String genre, int id) {
            this.played = played;
            this.id = id;
            this.genre = genre;
        }

        @Override
        public int compareTo(Music o) {
            if (this.played == o.played) return this.id - o.id;
            return o.played - this.played;
        }

        public String getGenre() {
            return genre;
        }
    }

        public int[] solution(String[] genres, int[] plays) {
            return IntStream.range(0, genres.length)
                    .mapToObj(i -> new Music(plays[i],genres[i], i))
                    .collect(Collectors.groupingBy(Music::getGenre))
                    .entrySet().stream()
                    .sorted((a,b) -> sum(b.getValue()) - sum(a.getValue()))
                    .flatMap(x -> x.getValue().stream().sorted().limit(2))
                    .mapToInt(x -> x.id).toArray();
        }

        private int sum(List<Music> value) {
            int answer = 0;
            for (Music music : value) {
                answer += music.played;
            }
            return answer;
        }
    ////
}