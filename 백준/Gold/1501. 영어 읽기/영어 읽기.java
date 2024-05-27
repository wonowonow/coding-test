import java.util.*;
import java.io.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            String key = convertToKey(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            String[] strs = br.readLine().split(" ");
            int answer = 1;
            boolean haesuk = false;

            for (int j = 0; j < strs.length; j++) {

                String key = convertToKey(strs[j]);

                for (String k : map.keySet()) {

                    if (k.equals(key)) {
                        List<String> list = map.get(k);
                        int count = 0;
                        for (String s : list) {

                            if (isSame(s, strs[j])) {
                                count++;
                                haesuk = true;
                            }

                        }
                        answer *= count;
                    }
                }
            }
               
            if (!haesuk) {
                System.out.println(0);
            } else {
                System.out.println(answer);
            }
        }
    }

    public static String convertToKey(String str) {
        
        if (str.length() == 1) {
            return str;
        }
        
        return str.substring(0, 1) + "_" + str.substring(str.length() - 1) + "_" + str.length();
    }

    public static boolean isSame(String st1, String st2) {
        char[] st1CharArr = st1.toCharArray();
        char[] st2CharArr = st2.toCharArray();
        Arrays.sort(st1CharArr);
        Arrays.sort(st2CharArr);
        return Arrays.equals(st1CharArr, st2CharArr);
    }
    
}