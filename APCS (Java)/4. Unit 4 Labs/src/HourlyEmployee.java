class HourlyEmployee extends Employee {
    private int hourlyWage;
    private int hoursWorked;

    public HourlyEmployee(){
    }

    public HourlyEmployee(String name, int employeeId, int hourlyWage, int hoursWorked) {
        super(name, employeeId);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void printEarnings(){
        super.printEarnings();
        System.out.println(hoursWorked + " hours @ $" + hourlyWage + ".00 = " + (hoursWorked*hourlyWage));
    }

    @Override
    public String toString(){
        return super.toString() + ", Wage: " + hourlyWage;
    }
}