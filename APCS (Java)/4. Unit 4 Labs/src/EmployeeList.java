import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeList {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Add employees to database.");
        String input = "";
        int type = 0;
        String name = "";
        int id = 0;
        int wage = 0;
        int hours = 0;
        int salary = 0;


        while(!input.equalsIgnoreCase("N")){
            System.out.print("Select Employee Type: \n1. Hourly\n2. Salary\nEnter Selection -> ");
            type = key.nextInt();
            key.nextLine();

            System.out.print("Enter Employee Name: ");
            name = key.nextLine();
            System.out.print("Enter Employee ID: ");
            id = key.nextInt();
            key.nextLine();

            if(type == 1){
                System.out.print("Enter Hourly Wage: ");
                wage = key.nextInt();
                key.nextLine();
                System.out.print("Enter Hours Worked: ");
                hours = key.nextInt();
                key.nextLine();

                employees.add(new HourlyEmployee(name, id, wage, hours));
                System.out.println("Added " + employees.get(employees.size()-1));
            }

            if(type == 2){
                System.out.print("Enter Salary: ");
                salary = key.nextInt();
                key.nextLine();

                employees.add(new SalariedEmployee(name, id, salary));
                System.out.println("Added " + employees.get(employees.size()-1));
            }



            System.out.print("\nEnter another employee? (y/n) ");
            input = key.nextLine();
        }

        System.out.println("\nEmployee Earnings: " );
        //Print all employee earnings from list.
        for(int i = 0; i < employees.size(); i++){
            employees.get(i).printEarnings();
            System.out.println();
        }
    }

}