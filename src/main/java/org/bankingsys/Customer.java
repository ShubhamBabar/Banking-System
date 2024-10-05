package org.bankingsys;

import java.sql.*;
import java.util.Scanner;


public class Customer {
        //Default Customer Details
    Scanner sc=new Scanner(System.in);
    String bankName="ABC Bank Limited";
    String branch="ABC Branch";

    String customer_name="Shubham Dattatray Babar";
    String account_no="100000";

    String password="1000";
    Double balance=0.0;
    ResultSet rs;
    //connection established
    public void Customer_con(String acc){

        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_sys","root","Shubhamroot#123");
            Statement st=cn.createStatement();
            rs=st.executeQuery("Select * from Customers where account_no ="+acc);
            rs.next();
            customer_name =rs.getString("customer_name");
            password =rs.getString("password");
            account_no=rs.getString("account_no");
            balance=rs.getDouble("Balance");


        }catch(Exception e){
            System.out.println("Wrong Input!!");
        }
        //Calling Services
        //System.out.println(name+ ac + pass);
    }

}
