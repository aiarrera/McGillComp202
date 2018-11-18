public class Farm {
    private Sheep[] sheep;
    private Dog dog;
    private String name;

    public Farm(String name, Dog dog, Sheep[] sheepArr){
        this.name =  name;
        this.dog = dog;

        sheep = new Sheep[sheepArr.length];
        for(int i =0; i<sheepArr.length;i++){
            sheep[i] = sheepArr[i]; // Add sheep to an array
        }
        if(dog.herd() > sheepArr.length){
            throw new IllegalArgumentException("Maximum number of sheep for this dog: "+dog.herd()+ " Sheep you have provided: "+sheepArr.length );

        }
    }

    public String getName(){
        return name;
    }

    public int getNumSheep(){
        int numOfSheep = sheep.length;
        return numOfSheep; // Take the length of the sheep array, and return as length

    }

    public void printFarm(){
        System.out.println("Name: "+ getName());
        System.out.println("Dog: "+ dog.getName());
        for(int j = 0; j<sheep.length;j++){
            System.out.println(sheep[j].getName()+""+sheep[j].getAge()); // Will print out the sheep and the age for that specific array space
        }
    }

    public double getWool(){
        for(int k = 0;k<sheep.length;k++){
            return sheep[k].shear(); // Returns the shear() for each entry of the array
        }
        return 1.0;
    }

}
