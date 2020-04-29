package project.practice.Lex;

/*
Problem statement :
All branches of a bank must have some common facilities that they extend to their customers. These facilities include opening a Savings account and issuing Vehicle Loan, House Loan, and Gold Loan.
So the head office has decided to create a contract that defines the facilities that every bank branch must implement.

Possible solution :
We will create an abstract class Branch and define four abstract methods:
Opening savings account
Issuing Vehicle Loan
Issuing House Loan
Issuing Gold Loan

Then the concrete subclass of the Branch will override all the methods and give their own implementation.

******************BUT******************
suppose a few years later the bank has decided to add more facilities like issuing a credit card to the customers and decided to implement it across all the branches. How to achieve it?
We will create a new abstract class and define a new abstract method i.e issuing the credit card and the concrete subclass of the Branch will be the child of the new abstract class also.
But multiple inheritance is not possible in Java.

This can be achieved via inheritance

 */

/* Later added as required */
interface MyBankNew{
    boolean applyCreditCard(Customer customer);
}

/* Extending the new interface MyBankNew which is a an added feature to the existing property */
interface MyBank extends MyBankNew {
    int CAUTION_MONEY = 2000;
    String createAccount(Customer customer);
    double issueVehicleLoan(String vehicleType, Customer customer);
    double issueHouseLoan(Customer customer);
    double issueGoldLoan(Customer customer);
}
class Customer {
    private String name;
    private String customerId;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name=name;
    }
    public String getCustomerId() {
        return customerId;
    }
    void setCustomerId(String customerId) {
        this.customerId= customerId;
    }
}

class MumbaiBranch implements MyBank {
    public String createAccount(Customer customer){
        return "Acc12345";
    }
    public double issueVehicleLoan(String vehicleType,Customer customer){
        if(vehicleType.equals("bike")) {
            return 100000;
        }
        else {
            return 500000;
        }
    }
    public double issueHouseLoan(Customer customer){
        return 200000;
    }
    public double issueGoldLoan(Customer customer){
        return 500000;
    }

    /* Mumbai branch could easily use the new feature added later */
    public boolean applyCreditCard(Customer customer){
        return true;
    }
}

class MultipleInheritanceViaInterfaceBankExecute{
    public static void main(String[] args){
        MyBank bank=new MumbaiBranch();
        Customer customer = new Customer();
        customer.setCustomerId("cust1001");
        customer.setName("Ajay");
        String accountNumber = bank.createAccount(customer);
        System.out.println("Account number is..." +accountNumber);
        double gloan = bank.issueGoldLoan(customer);
        System.out.println("Gold loan amount is..." +gloan);
        double hloan = bank.issueHouseLoan(customer);
        System.out.println("House loan amount is..." +hloan);
        double vloan = bank.issueVehicleLoan("bike", customer);
        System.out.println("Vehicle loan amount is..." +vloan);
        System.out.println("Caution money is..." +MyBank.CAUTION_MONEY);

        /* the new interface used here which was added later */
        MyBankNew bank1 = new MumbaiBranch();
        boolean credit = bank1.applyCreditCard(customer);
        System.out.println("Credit card request.." + credit);
    }
}
