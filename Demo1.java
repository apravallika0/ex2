package javasql;

import java.util.*;
import java.io.*;
import java.sql.*;

 


//import java.sql.Connection;
//import java.sql.DriverManager;

 

 
 public class Demo1
{
   public static void main(String[] args) throws Exception
   { 
    String continuedata = " ";
   System.out.println("Welcome");
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection connectionurl =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Pravs","2009");
              
  do
 {
     System.out.println("Select options form below menu: ");
   System.out.println("Press 1 to Select data\nPress 2 to insert data\nPress 3 to delete data\nPress 4 to update data");
   Scanner sc=new  Scanner(System.in);
   String DataInput= sc.nextLine();
   switch (DataInput)
  {
     case "1":
         ResultSet resultSet = null;
     
                 Statement statement = connectionurl.createStatement();
      {
                String selectsql = "SELECT * from Employee";
              resultSet = statement.executeQuery(selectsql);
             while (resultSet.next())
            {
                   System.out.println(resultSet.getString(1)+"   "+ resultSet.getString(2)+"  "+ resultSet.getString(3)+"    "+ resultSet.getString(4)+"    "+ resultSet.getString(5)+"    "+ resultSet.getString(6)+"    "+ resultSet.getString(7));
                
            }
  }
break;
case "2":
System.out.println("Enter ID :");
var id=sc.nextLine();
System.out.println(id);
System.out.println("Enter  Name :");
var name=sc.nextLine();
System.out.println(name);
System.out.println("Enter Gender:");
var gender=sc.nextLine();
System.out.println(gender);
System.out.println("Enter hire_date :");
var hire_date=sc.nextLine();
System.out.println(hire_date);
System.out.println("Enter Salary :");
var salary=sc.nextLine();
System.out.println(salary);
System.out.println("Enter commission :");
var Commission=sc.nextLine();
System.out.println(Commission);
System.out.println("Enter dept_id :");
var dept_id=sc.nextLine();
System.out.println(dept_id);
PreparedStatement stmt=connectionurl.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
stmt.setString(1, id);
stmt.setString(2, name);
stmt.setString(3, gender);
stmt.setString(4, hire_date);
stmt.setString(5, salary);
stmt.setString(6, Commission);
stmt.setString(7, dept_id);
stmt.executeUpdate();
System.out.println("Data Entered Successfully");
break;

 

case "3":
//Statement stmt = connectionurl.createStatement();
System.out.println("Enter an ID you want to delete");
var ID=sc.nextLine();
String Delquery= "delete from Employee where id = " + ID;
Statement stmt1 = connectionurl.createStatement();
stmt1.executeUpdate(Delquery);
System.out.println("Data Deleted successfully");
break;

 

case "4":

 

   System.out.println("Enter an ID you want to update");  
     ID = sc.nextLine();  
      
    id = sc.next();
    String query = "update Employee set id= "+ ID +" where id ='"+id+"'";
    PreparedStatement pst = connectionurl.prepareStatement(query);
    int x = pst.executeUpdate(query);
    System.out.println("updated rows are:"+x);
    break;

 

/*case "5":
   System.out.println("Enter an ID you want to update");  
     ID = sc.nextLine();  
     
    id = sc.next();
   System.out.println("Press 1 to Update id\nPress 2 to Update name\nPress 3 to Update gender\nPress 4 to Update hiredate\n Press 5 to Update salary\nPress 6 to update commission\nPress 7 to update deptid");
   String n;
   n = sc.next();
   switch(n){
case "1":
 query = "update Employee set id= "+ id +" where id ='"+id+"'";
 PreparedStatement pst1 = connectionurl.prepareStatement(query);
 x = pst1.executeUpdate(query);
System.out.println("updated rows are:"+x);
break;
case "2":
System.out.println("Enter name to update");
name = sc.next();
String query2 = "update Employee set name= "+ name +" where id ='"+id+"'";
PreparedStatement pst2 = connectionurl.prepareStatement(query2);
 x = pst2.executeUpdate(query2);
System.out.println("updated rows are:"+x);
break;
case "3":
System.out.println("Enter gender to update");
gender = sc.next();
String query3 = "update Employee set gender= "+ gender +" where id ='"+id+"'";
PreparedStatement pst3 = connectionurl.prepareStatement(query3);
x = pst3.executeUpdate(query3);
System.out.println("updated rows are:"+x);
break;
case "4":
System.out.println("Enter hire_date to update");
hire_date = sc.next();
String query4 = "update Employee set hire_date= "+ hire_date +" where id ='"+id+"'";
PreparedStatement pst4 = connectionurl.prepareStatement(query4);
 x = pst4.executeUpdate(query4);
System.out.println("updated rows are:"+x);
break;
case "5":
System.out.println("Enter salary to update");
salary = sc.next();
String query5 = "update Employee set salary= "+ salary +" where id ='"+id+"'";
PreparedStatement pst5 = connectionurl.prepareStatement(query5);
x = pst5.executeUpdate(query5);
System.out.println("updated rows are:"+x);
break;
case "6":
String commission;
System.out.println("Enter Commission to update");
commission = sc.next();
String query6 = "update Employee set commission= "+ commission +" where id ='"+id+"'";
PreparedStatement pst6 = connectionurl.prepareStatement(query6);
x = pst6.executeUpdate(query6);
System.out.println("updated rows are:"+x);
break;
case "7":
System.out.println("Enter Dept Id to update");
dept_id = sc.next();
String query7 = "update Employee set dept_id= "+ dept_id +" where id ='"+id+"'";
PreparedStatement pst7 = connectionurl.prepareStatement(query7);
 x = pst7.executeUpdate(query7);
System.out.println("updated rows are:"+x);
break;

 

    default:
        System.out.println("You entered wrong input");
        break;
}
break;*/
default :
System.out.println("You have selected wrong input!!!!");
break;
}
System.out.println("Enter y to continue: else press any other key to exit the program");
continuedata = sc.next();
if(continuedata.equals("y"))
System.out.println("You Have selected to continue");
}
while (continuedata.equals("y"));
System.out.println("You Have Exited the Program");
   }
}