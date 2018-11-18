//Fill in your name and student number
//Name: Dakksh Nandrajog
//Student Number: 260775826

public class InputAnalyzer {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.out.println("You need to enter three arguments to this program. Try typing 'run InputAnalyzer 2.5 8 9' in Dr. Java, or 'java InputAnalyzer 2.5 8 9' on the command line.");
            return;
        } 
        double a = getInputDouble(args[0]);
        double b = getInputDouble(args[1]);
        double c = getInputDouble(args[2]);
        
        //========================
        //Enter your code below

        boolean nn;
        boolean odd;
        boolean dec;

        //These boolean variables allow me to save calculation statements for the final

        if (a < 0 || b <0 || c<0){
            nn = false;
            System.out.println("The numbers "+ a +", "+b+" and "+c+ " are all non negative: " +nn);
        } else{
            nn = true;
            System.out.println("The numbers "+ a +", "+b+" and "+c+ " are all non negative: "+nn );
        }


        if (a%2 == 0 && b%2 == 0 && c%2 == 0){
            odd = false;
            System.out.println("At least one between "+a+", "+b+" and "+c +" is odd: "+odd);
        } else{
            odd = true;
            System.out.println("At least one between "+a+", "+b+" and "+c +" is odd: "+ odd);
        }

        if (a < b && b < c ) {
            dec = true;
            System.out.println("The numbers "+a+", "+b+" and "+c +" are in strictly decreasing order: "+dec);
        } else{
            dec = false;
            System.out.println("The numbers "+a+", "+b+" and "+c +" are in strictly decreasing order: "+dec);
        }

        System.out.println("The numbers "+a+" ,"+b+" and "+c+" are either all non-negative or in a strictly decreasing order: "+ (nn || dec));
        System.out.println("The numbers "+a+" ,"+b+" and "+c+" are all non-negative and none of them are odd: "+ (nn && odd));
        
        
        
        //Enter your code above
        //========================
    }
    
    public static double getInputDouble(String arg)
    {
        try
        {
            return Double.parseDouble(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be a number!");
        }
        
        //error, return 0
        return 0;
    }
}