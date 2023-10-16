class SalariedEmployee extends Employee {
    private int salary;

    public SalariedEmployee(){
    }

    public SalariedEmployee(String name, int employeeId, int salary) {
        super(name, employeeId);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void printEarnings(){
        super.printEarnings();
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString(){
        return super.toString() + ", Salary: " + salary;
    }
}