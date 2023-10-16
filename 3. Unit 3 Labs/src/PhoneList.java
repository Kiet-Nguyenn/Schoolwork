import java.sql.SQLOutput;
import java.util.*;

public class PhoneList
{
    private ArrayList<Contact> phoneList = new ArrayList<Contact>();

    public void getContactInfo()
    { //get user values to initialize phoneList with Contact objects.
        Scanner key = new Scanner(System.in);
        String ans = "";
        String name;
        String phone;
        while(!ans.equalsIgnoreCase("n")) {
            System.out.print("Enter name --> ");
            name = key.nextLine();
            System.out.print("Enter Phone Number --> ");
            phone = key.nextLine();
            phoneList.add(new Contact(name, phone));
            System.out.print("\nContinue [Y or N]? ");
            ans = key.nextLine();
        }
    }

    public void printContactInfo()
    { //print values from phoneList
        System.out.println("       Contact List\n-----------------------------");
        for(int i = 0; i < phoneList.size(); i++){
            System.out.print(phoneList.get(i).getName());
            for(int k = phoneList.get(i).getName().length() - 1; k < 16; k++){
                System.out.print(" ");
            }
            System.out.println(phoneList.get(i).getPhone());
        }
    }

    public static void main(String[] args)
    {
        PhoneList app = new PhoneList();
        app.getContactInfo();
        app.printContactInfo();
    }
}