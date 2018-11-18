//Fill in your name and student number
//Name: Dakksh Nandrajog
//Student Number: 260775826

// do NOT touch these import statements 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class CountdownDays {
    
    // the method returns a String representing the current date in the following format: dd/mm/yyyy
    // you can use it, but do NOT modify it!
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
    
    //========================
    // Enter your code below
    
    public static void main (String[] args) {

    }
    
    public static String getSubstring(String s, int i, int j){
        String a = "";
        if (i > j){
            System.out.println("IllegalArgumentException");
        } else {
            for(int k = i; k < j+1; k++){
                a = a + s.charAt(k); // Every letter from the word between the ranges of i to j gets added to the empty string
            }
        }
        return a;
    }

    public static int getDay(String b){
        int c;
        c = Integer.parseInt(getSubstring(b,0,1));
        return c;
    }

    public static int getMonth(String b){
        int d;
        d = Integer.parseInt(getSubstring(b,2,3));
        return d;
    }

    public static int getYear(String b){
        int e;
        e = Integer.parseInt((getSubstring(b,4,7)));
        return e;
    }

    public static boolean isLeapYear(int year){
        if (year%100 == 0){
            if(year%400 == 0){
                return true;
            } else {
                return false;
            }
        } else if (year%4 ==0){
            return true;
        } else {
            return false;
        }
    }

    public static int getDaysInAMonth(int month, int year){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        }else if (month == 4 || month == 6 || month == 9 || month == 11){
            return 31;
        } else if (month == 2){
            boolean ly = isLeapYear(year); // This checks if this February is in a leap year, which would have 29 days.
            if (ly == true) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }

    public static boolean dueDateHasPassed(String year1, String year2){
        if(getYear(year1) > getYear(year2)){
            return true; // If the current year is greater, then it automatically says the due date has passed
        } else if(getMonth(year1) > getYear(year2)){
            return true; // Same as above
        } else if(getDay(year1) > getYear(year2)){
            return true; // Same as above
        } else {
            return false; // This means the due date hasn't passed
        }
    }

    public static int countDaysLeft(String year1, String year2){
        if(dueDateHasPassed(year1,year2)){
            return 0;
        } else {
           int daysLeft = 0;

           daysLeft = daysLeft + (getDaysInAMonth(getMonth(year1), getYear(year1))-getDay(year1)); // Days left in current month

           for(int i = getMonth(year1)+1; i<13; i++){
               daysLeft = daysLeft+getDaysInAMonth(i,getYear(year1)); // Days left in the year, per month
           }

           for(int i = getYear(year1)+1; i<getYear(year2);i++){
               if(isLeapYear(i)){
                   daysLeft = daysLeft + 366; // If it is a leap year, add 366 days
               } else{
                   daysLeft = daysLeft + 365; // If it is a normal year, add 365 days
               }
           }

           for(int i = 1; i<getMonth(year2); i++){
               daysLeft = daysLeft + getDaysInAMonth(i,getYear(year2)); // Days left from January to due month
           }

           daysLeft = daysLeft + getDay(year2); // Days left in the due month.
            return daysLeft;

        }

    }

    public static String displayCountdown(String year){
        if(dueDateHasPassed(getCurrentDate(),year) == false) {
            System.out.println("Today's date is: " + getCurrentDate());
            System.out.println("Due date: " + year);
            System.out.println("You have "+ countDaysLeft(getCurrentDate(),year) + "! You can do it!");
        } else {
            System.out.println("Today's date is: " + getCurrentDate());
            System.out.println("Due date: " + year);
            System.out.println("The date has passed! Better luck next time.");
        }
        return null;
    }
}
