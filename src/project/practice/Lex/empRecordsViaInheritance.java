package project.practice.Lex;
/*
A construction company wants to keep a record of the employees working in it. There are permanent employees as well as contract employees.
Contract employees work on an hourly basis whereas permanent employees are paid monthly salary.
 */

class Employee {

    private int empId;
    private String name;
    private double salary;

    public int getEmpId() {
        return empId;
    }

    void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

}

class PermanentEmployee extends Employee {
    private double basicPay;
    private double hra;
    private int exp;

    private double getBasicPay() {
        return basicPay;
    }

    void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    private double getHra() {
        return hra;
    }

    void setHra(double hra) {
        this.hra = hra;
    }

    private int getExp() {
        return exp;
    }

    void setExp(int exp) {
        this.exp = exp;
    }

    void calculateSalary() {
        double variableComponent;
        double exp = getExp();
        double basic = getBasicPay();
        variableComponent = (exp < 3) ? 0 : ((exp < 5) ? 5 : ((exp < 10) ? 7 : 12));
        setSalary((variableComponent * 0.01 * basic) + getHra() + basic);

    }
}

class ContractEmployee extends Employee {

    private double wages;
    private int hours;

    private double getWages() {
        return wages;
    }

    void setWages(double wages) {
        this.wages = wages;
    }

    private int getHours() {
        return hours;
    }

    void setHours(int hours) {
        this.hours = hours;
    }

    void calculateSalary() {
        setSalary(getHours() * getWages());
    }
}

public class empRecordsViaInheritance {
    public static void main(String[] args) {
        PermanentEmployee perEmp = new PermanentEmployee();
        ContractEmployee conEmp = new ContractEmployee();

        perEmp.setName("Anil");
        perEmp.setEmpId(101);
        perEmp.setBasicPay(10000);
        perEmp.setHra(1500);
        perEmp.setExp(3);
        perEmp.calculateSalary();

        conEmp.setName("Ankit");
        conEmp.setEmpId(102);
        conEmp.setWages(500);
        conEmp.setHours(10);
        conEmp.calculateSalary();

        System.out.println("Permanent Employee your salary is : " + perEmp.getSalary());
        System.out.println("Contract Employee your salary is : " + conEmp.getSalary());

    }

}