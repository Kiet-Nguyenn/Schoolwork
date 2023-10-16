import java.util.ArrayList;

public class StockExchange {


    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(7);list.add(1);list.add(5);list.add(3);list.add(6);list.add(4);
        System.out.println(list);
        System.out.println(getMaxProfit(list));

        ArrayList list2 = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list2.add((int)(Math.random()*50));
        }
        System.out.println("\nRandom List: " + list2);
        System.out.println("Get max profit: " + getMaxProfit(list2));
    }

    /** Return the max profit from the list of prices.
     *
     */
    public static int getMaxProfit(ArrayList<Integer> priceList){
        int maxProfit = 0;
        int profit = 0;
        int lowestPrice = priceList.get(0);

        for(int i = 0; i < priceList.size(); i++) {
            if (priceList.get(i) < lowestPrice) {
                lowestPrice = priceList.get(i);
            }
            profit = priceList.get(i) - lowestPrice;
            if (profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}