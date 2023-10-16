import java.util.ArrayList;

import static java.lang.System.out;

public class NumberAnalyzer {
    private ArrayList<Integer> list;

    public NumberAnalyzer() {
    }

    public NumberAnalyzer(String numbers) {
        list = new ArrayList<>();
        while (numbers.indexOf(' ') != -1) {
            list.add(Integer.parseInt(numbers.substring(0, numbers.indexOf(' '))));
            numbers = numbers.substring(numbers.indexOf(' ') + 1);
        }
        list.add(Integer.parseInt(numbers));

        out.println(list);
    }

    public void setList(String numbers) {
        list = new ArrayList<>();
        while (numbers.indexOf(' ') != -1) {
            list.add(Integer.parseInt(numbers.substring(0, numbers.indexOf(' '))));
            numbers = numbers.substring(numbers.indexOf(' ') + 1);
        }
        list.add(Integer.parseInt(numbers));

        out.println(list);
    }

    public int countOdds() {
        int oddCount = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 != 0){
                oddCount++;
            }
        }

        return oddCount;
    }

    public int countEvens() {
        int evenCount = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                evenCount++;
            }
        }

        return evenCount;
    }

    public int countPerfects() {
        int perfectCount = 0;
        int total = 0;
        for(int i = 0; i < list.size(); i++){
            for(int k = 1; k < list.get(i); k++){
                if(list.get(i) % k == 0){
                    total += k;
                }
            }
            if(total == list.get(i)){
                perfectCount++;
            }
            total = 0;
        }

        return perfectCount;
    }

    public String toString() {
        return "";
    }
}