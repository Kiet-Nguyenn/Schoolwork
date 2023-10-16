import java.util.Locale;

public class Stringercise {
    public static void main (String args[]){
            String str = "Kiet";
            System.out.println("1. " + str);
            str += " Huu";
            System.out.println("2. " + str);
            str = str.concat(" Nguyen");
            System.out.println("3. " + str);
            str = str.toLowerCase();
            System.out.println("4. " + str);
            str = str.toUpperCase();
            System.out.println("5. " + str);
            System.out.println("6. " + str.length());
            System.out.println("7. " + str.substring(0,4) + "\n" + str.substring(5,8) + "\n" + str.substring(9,15));
            System.out.println("8. " + str.charAt(0) + str.charAt(5) + str.charAt(9));
            System.out.println("9. " + str.indexOf("HUU"));
            System.out.println("10. " + str.replace("K","X"));

            int num1 = 5;
            int num2 = 15;
            int num3 = 21;
            String number1 = Integer.toString(num1);
            String number2 = Integer.toString(num2);
            String number3 = Integer.toString(num3);
            System.out.println("11. " + number1 + ", " + number2 + ", " + number3);
            System.out.println("12. " +  number1.compareTo("17") + ", " + number2.compareTo("17") + ", " + number3.compareTo("17"));
            System.out.println("13. " + (Integer.parseInt(number1) + Integer.parseInt(number2) + Integer.parseInt(number3)));

    }
}
