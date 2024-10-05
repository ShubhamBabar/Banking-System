package org.bankingsys;
import java.util.Scanner;


public class Services {
    Scanner sc= new Scanner(System.in);
    Bank b1=new Bank();

    //Default login status
    static boolean login=false;
    Customer c1 = new Customer();

    //Creating service method
    public void service(){

        System.out.println("\nBanking Services: Choose your options");

        //Handling Exception
        try {

            //login logic
            if(!login) {
                System.out.println("Login First!!!");
                System.out.print("Enter your account number : \n");
                String acc=sc.nextLine();
                System.out.print("Enter your pin : ");
                String pin=sc.nextLine();
                c1.Customer_con(acc);

                //Checking acc_no and Pin
                if(c1.account_no.equals(acc) && c1.password.equals(pin)) {
                    login=true;
                    System.out.println("Login Succesful!!");
                    service();
                }
                else {
                    System.out.println("Login Failed!! try again !!");
                    service();
                }

            }else {

                // banking services logic
                System.out.println("\nKnow customer details : 1");
                System.out.println("Balance Enquiry       : 2");
                System.out.println("Credit amount         : 3");
                System.out.println("Debit amount          : 4");
                System.out.println("Logout                : 5");

                switch(sc.nextInt()) {
                    case 1:
                        knowCustomer();

                        service();
                        break;
                    case 2:

                        knowBalance();
                        service();
                        break;
                    case 3:
                        addAmount(sc);
                        service();
                        break;
                    case 4:
                        debitAmount(sc);
                        service();
                        break;
                    case 5:
                        login=false;
                        service();
                        break;
                    default:
                        System.err.println("Please enter valid choise");
                        break;
                }
            }
        }catch(Exception e) {
            System.err.println("Wrong input!!");
            service();
        }

    }
    //Know customer details
    public void knowCustomer(){
        System.out.println("Bank name : "+c1.bankName);
        System.out.println("Branch name : "+c1.branch);
        System.out.println("Customer name : "+c1.customer_name);
        System.out.println("Account Number : "+c1.account_no);
    }

    //Balance Inquiry
    public void knowBalance(){
        System.out.println("Your account balance is : "+c1.balance);
    }

    //Credit amount
    public void addAmount(Scanner sc){
        System.out.print("Enter amount : ");
        int newamt =sc.nextInt();
        System.out.println("Rs "+newamt+" is credited in your accout.");
        c1.balance+=newamt;
    }

    //Debit amount
    public void debitAmount(Scanner sc){

        System.out.print("Enter amount : ");
        int newamt =sc.nextInt();
        double dif;

        //checking insufficient balance
        if((dif=c1.balance-newamt)>0) {
            System.out.println("Rs "+newamt+" is debited from your accout.");
            c1.balance-=newamt;
        }else {
            System.err.println("Insufficient balance!!!");
        }


    }


}
