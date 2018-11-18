import java.util.Random;

public class Sheep {
    private String name;
    private int age;
    private boolean hasWool;
    private static Random numberGenerator = new Random(123); // This makes sure that the seed for the numberGenerator is 123, as told


    public Sheep(String name, int age){
        this.name = name;
        this.age = age;
        this.hasWool = true; // This makes sure the default value for hasWool is true
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double shear(){
        if(hasWool == true){
            double start = 6;
            double finish = 10; // If the sheep has wool, then initialize starting and ending values for the RNG

            double wool = start + (numberGenerator.nextDouble() * (finish-start)); // Makes sure the RNG produces values between 6 and 10
            if((wool == 0) || (hasWool == false)){
                return 0;
            } else {
                return wool;
            }
        }

        hasWool = false; // Makes hasWool to false
        return 0; // And will return 0
    }


}
