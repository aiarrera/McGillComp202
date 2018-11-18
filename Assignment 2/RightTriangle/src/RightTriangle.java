public class RightTriangle {

    public static void main(String args[]){
        int count = Integer.parseInt(args[0]);

        if(count<0){
            System.out.println("Error: input value must be >=0");
        }
        else {
            for (int i = count; i > 0; i--) {
                for (int index = 0; index < i - 1; index++)
                    System.out.print(" ");
                for (int star = count; star > i - 1; star--)
                    System.out.print("*");
                System.out.println();
            }
        }
    }
}
