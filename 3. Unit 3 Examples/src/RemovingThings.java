import java.util.ArrayList;

public class RemovingThings {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 11; i++){
            list.add(i);
        }

        System.out.println(list);

        //Remove all even values from list
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                list.remove(i);
            }
        }

        System.out.println(list);

        //Remove all values from list
        int size = list.size();
        for(int i = list.size()-1; i >= 0; i--){
            list.remove(i);
        }

        System.out.println(list);

    }
}
