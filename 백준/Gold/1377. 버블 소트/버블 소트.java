import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Data[] arr = new Data[Integer.parseInt(br.readLine())];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            
            return o1.getNum() - o2.getNum();
        });
        
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i].getIdx() - i > max) {
                max = arr[i].getIdx() - i;
            }
        }
        
        System.out.print(max + 1);
    }

    static class Data {
        private int num;
        private int idx;

        public Data(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int getNum() {
            return this.num;
        }

        public int getIdx() {
            return this.idx;
        }
    }
}