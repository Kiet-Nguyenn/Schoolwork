import java.util.*;
import java.io.*;

public class SortNames {
    // instance variables
    private ArrayList<String> list;

    // constructor
    public SortNames() {
        list = new ArrayList<>();

        readFile();

        printList();

        selectionSort();

        System.out.println();
        System.out.println("====================");
        System.out.println("    Sorted List");
        System.out.println("====================");
        System.out.println();

        printList();
    }

    // Sorts the ArrayList using the selection sort algorithm
    public void selectionSort() {
        for(int i = 0; i < list.size() - 1; i++){
            int min = i;
            for(int k = i + 1; k < list.size(); k++){
                if(list.get(k).compareTo(list.get(min)) < 0){
                    min = k;
                }
            }

            if(min != i){
                String temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }

    }

    public void readFile() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("nameList.txt"));
        } catch (IOException ex) {
            System.out.println("File not found");
        }

        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            list.add(name);
        }

    }

    public void printList() {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortNames app = new SortNames();
    }


}