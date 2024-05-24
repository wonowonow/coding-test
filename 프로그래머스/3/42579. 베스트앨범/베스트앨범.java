import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<PopularAlbumOfGenre> popularAlbumOfGenre = new ArrayList<>();
        Map<String, Integer> genrePlayCnt = new HashMap<>();
        Map<String, PriorityQueue<Genre>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlayCnt.put(genres[i], genrePlayCnt.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new PriorityQueue<>((o1, o2) -> {
                    if (o1.play == o2.play) {
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }));
            }
            
            map.get(genres[i]).add(new Genre(plays[i], i));
        }
        
        for (String key : map.keySet()) {
            PriorityQueue<Genre> q = map.get(key);
            List<Genre> genreList = new ArrayList<>();
            if (q.size() > 1) {
                genreList.add(q.poll());
                genreList.add(q.poll());
            } else {
                genreList.add(q.poll());
            }
            
            popularAlbumOfGenre.add(new PopularAlbumOfGenre(key, genreList));
        }
        
        Collections.sort(popularAlbumOfGenre, (o1, o2) -> {
            return genrePlayCnt.get(o2.genre) - genrePlayCnt.get(o1.genre);
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for (PopularAlbumOfGenre popular : popularAlbumOfGenre) {
            for (Genre g : popular.plays) {
                answer.add(g.idx);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Genre {
        int play;
        int idx;
        
        public Genre(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
    
    class PopularAlbumOfGenre {
        String genre;
        List<Genre> plays;
        
        public PopularAlbumOfGenre(String genre, List<Genre> plays) {
            this.genre = genre;
            this.plays = plays;
        }
    }
}