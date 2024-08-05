import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Car> db = new HashMap<>(); // "차량번호" / 시간 및 주차 여부
        List<Car> list = new ArrayList<>();
        
        for (String record : records) {
            
            String[] details = record.split(" ");
            String[] times = details[0].split(":");
            int hour = Integer.parseInt(times[0]) * 60;
            int minute = Integer.parseInt(times[1]);
            int time = hour + minute;
            
            String carNumber = details[1];
            
            String con = details[2];
            
            if (db.containsKey(carNumber)) {
                Car car = db.get(carNumber);
                
                if (con.equals("IN")) {
                    car = new Car(carNumber, time, car.totalTime, true, car.totalPrice);
                } else {
                    car = new Car(carNumber, time, car.totalTime + time - car.time, false, car.totalPrice);
                }
                
                db.put(carNumber, car);
            } else {
                db.put(carNumber, new Car(carNumber, time, 0, true, 0));
            }
        }
        
        for (String carNumber : db.keySet()) {
            Car car = db.get(carNumber);
            int totalPrice = valetCal(fees, car);
            
            list.add(new Car(carNumber, car.time, car.totalTime, false, totalPrice));
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
        });
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).totalPrice;
        }
        
        return answer;
    }
    
    public int valetCal(int[] fees, Car car) {
        int result = 0;
        int totalTime = car.totalTime;
        if (car.isValet) {
            totalTime = totalTime + (24 * 60 - 1) - car.time;
        }
        
        if (totalTime <= fees[0]) {
            return fees[1];
        }
        
        int quotient = (totalTime - fees[0]) / fees[2];
        int remainder = (totalTime - fees[0]) % fees[2];

        if (remainder > 0) {
            quotient++;
        }

        result = fees[1] + (quotient * fees[3]);
        
        return result;
    }
    
    class Car {
        String number;
        int time;
        int totalTime;
        boolean isValet;
        int totalPrice;
        
        public Car(String number, int time, int totalTime, boolean isValet, int totalPrice) {
            this.number = number;
            this.time = time;
            this.totalTime = totalTime;
            this.isValet = isValet;
            this.totalPrice = totalPrice;
        }
    }
}