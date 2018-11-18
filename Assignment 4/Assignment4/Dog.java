public class Dog {
    private String name;
    private final String breed;


    public Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public String getName(){
        return name;
    }

    public int herd(){
        if(breed.toLowerCase().contains("collie")){ // Using the contains and toLowerCase method in one sentence makes code concise and execute efficiently
            return 20;
        } else if (breed.toLowerCase().contains("shepherd")){ // This pattern continues for the entire collection of if/else if statements
            return 25;
        } else if (breed.toLowerCase().contains("kelpies") || breed.toLowerCase().contains("teruvens")){
            return 30;
        } else{
            return 10;
        }
    }
}
