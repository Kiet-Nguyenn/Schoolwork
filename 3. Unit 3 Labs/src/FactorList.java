import java.util.ArrayList;
import java.util.Scanner;

public class FactorList {
    public ArrayList<Integer> getListOfFactors(int num){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < num; i++){
            if(num % i == 0){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        FactorList test = new FactorList();
        System.out.print("Enter Number: ");
        int input = key.nextInt();
        key.nextLine();
        System.out.println(test.getListOfFactors(input));
    }
}
