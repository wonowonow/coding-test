import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 듣도 못한 사람 수
        int M = scanner.nextInt(); // 보도 못한 사람 수
        scanner.nextLine(); // 개행 문자 제거

        Set<String> unheard = new HashSet<>();
        List<String> result = new ArrayList<>();

        // 듣도 못한 사람 저장
        for (int i = 0; i < N; i++) {
            unheard.add(scanner.nextLine());
        }

        // 보도 못한 사람 확인 및 교집합 찾기
        for (int i = 0; i < M; i++) {
            String name = scanner.nextLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }
        
        Collections.sort(result);

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}