//Fill in your name and student number
//Name: Dakksh Nandrajog
//Student Number: 260775826

public class CoinMachine {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("You need to enter two arguments to this program. Try typing 'run CoinMachine 400 215' in Dr. Java, or 'java VendingMachine 400 215' on the command line.");
            return;
        } 
        int cash = getInputInteger(args[0]);
        int price = getInputInteger(args[1]);
        
        //========================
        //Enter your code below

        int amount = cash - price;
        //This calculates the change from the initial values

        System.out.println("Amount recieved: "+ cash);
        System.out.println("Cost of the item: "+ price);
        System.out.println("Required change: "+ amount);

        System.out.println("Change: ");
        System.out.println((amount / 200) + " x twoonies");
        amount = amount % 200;
        System.out.println((amount / 100) + " x loonies");
        amount = amount % 100;
        System.out.println((amount / 25) + " x quarters");
        amount = amount % 25;
        System.out.println((amount / 10) + " x dimes");
        amount = amount % 10;
        System.out.println((amount / 5) + " x nickels");
        amount = amount % 5;

        //This allows me to save initializing of variables, increase speed, and optimize my lines of code

        //Enter your code above
        //========================
    }
    
    public static int getInputInteger(String arg) {
        try
        {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
        }
        
        //error, return 0
        return 0;
    }
}