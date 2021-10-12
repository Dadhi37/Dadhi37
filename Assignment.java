package assignment;
import java.util.Scanner;
import java.util.ArrayList;
public class Assignment {
    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        ArrayList<StudentsPIN>Studentlist= new ArrayList<>();// List to store students id and pins
        char D;
        do{
            System.out.println("Enter Student ID: ");
            int a = keyboard.nextInt();  // Taking student Id from user
            System.out.println("Enter Student PIN: ");
            int b = keyboard.nextInt();  // Taking PIN from user
            StudentsPIN S1 = new StudentsPIN(a,b);
            Studentlist.add(S1);  // adding data to the list
            
            System.out.println("Add more Student ID and PINs(Y or N)?: ");  //Asking users if they want to add more student IDs.
              D = keyboard.next().charAt(0);
        }while(D=='y'||D=='Y');  // Loop will keep going until user types Y i.e. yes
        
        System.out.println("\n\nSaved Student IDs and PINs are as follows: \n");
        System.out.println("ID | PIN ");
        System.out.println("==========================");
        for (int i = 0; i < Studentlist.size(); i++)                      //loop to display studentlist details
           {
            StudentsPIN Details = Studentlist.get(i);
             Details.display();  // will display saved IDs and Pins in tabular format
        }
        
         //Question 2 validation part
        
        System.out.println("\n\nFor Validation as asked by Question 2");
        char da;
        int validId;
        int validPin;
        do{
        System.out.println("\nEnter Student ID: "); 
        validId=keyboard.nextInt();              // asking user to enter student ud they want to validate
        
        Boolean check= false;
        for(int i=0; i< Studentlist.size();i++ ){
            StudentsPIN data= Studentlist.get(i);
            if(data.getStudentId()==validId)     // Validating the entered student id with our saved ids.
            {
                check=true;
                System.out.println("\nEntered student ID is valid.");
                System.out.println("\nEnter PIN: ");      // Asking user to enter respective PIN of the ID
                validPin=keyboard.nextInt();
                if(data.getPIN()==validPin){   // validating the PIN for the entered Student ID
                    System.out.println("\nPIN entered is valid.");
                }
                else{
                    System.out.println("You have entered an Invalid PIN");
                }
            }
        }
        if(check==false){
            System.out.println("\n\n!!!\nSorry...The studentID doesnot exist.");
        }
        System.out.println("\n\nDo you want to validate more student IDs ( Y or N )?");  // Will ask if the user wants to validate more id
        da=keyboard.next().charAt(0);
        }while(da=='y'|| da=='Y');
}}
class StudentsPIN {// class studentsPIN is defined
    int StudentId;
    int PIN;

public StudentsPIN(int a, int b){
StudentId = a;
PIN = b;
}
  
public void display(){ //function to display Student id and pin on the screen
System.out.println(StudentId +" | "+ PIN);
}
  
int getStudentId(){ //getter function to get Student ID
return StudentId;
}
  
int getPIN(){ // getter function to get pin
return PIN;
}
}
