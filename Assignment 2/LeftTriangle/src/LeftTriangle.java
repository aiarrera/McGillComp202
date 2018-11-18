public class LeftTriangle {

    public static void main(String args[]){
        int num = Integer.parseInt(args[0]);

        if(num<0){
            System.out.println("Error: input value must be >= 0");
        }
        else {
            for (int count = 0; count < num; count++) {
                for (int j = 0; j < count + 1; j++)
                    System.out.print("*");
                System.out.println();
            }
        }
    }
}
