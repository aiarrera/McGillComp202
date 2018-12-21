// Name: Dakksh Nandrajog
// ID: 260775826
import java.util.ArrayList;
import java.util.Random;

public class Character {
    private String name;
    private double attackValue;
    private double maxHV;
    private double currHV;
    private int numWins;
    private static ArrayList <Spell> spells;


    public Character(String name, double attackValue, double maxHV, int numWins){
        this.name = name;
        this.attackValue = attackValue;
        this.maxHV = maxHV;
        this.numWins = numWins;
        currHV = maxHV; // To make sure current health is equal to maximum health at first
    } // Standard constructor of object as explained in assignment

    public String getName(){
        return name;
    }

    public double getAttackValue(){
        return attackValue;
    }

    public double getMaxHealth(){
        return maxHV;
    }

    public double getCurrHealth(){
        return currHV;
    }

    public int getNumWins(){
        return numWins;
    }

    public String toString(){
        return name + "" + currHV;
    }

    public double getAttackDamage(int seed){
        Random numGen = new Random(seed);
        double start = 0.7;
        double finish = 1.0;
        double rand = start + (numGen.nextDouble() * (finish-start)); // Ensures the random value is between 0.7 and 1.0
        return attackValue*rand;
    }

    public double takeDamage(double dam){
        return currHV - dam;
    }

    public void increaseWins(){
        numWins = numWins+1;
    }

    public static void setSpells(ArrayList<Spell> Spells){
        // This can also be done with a for loop, but ArrayList provides a method to do this action.
        spells.addAll(Spells);
    }

    public static void displaySpells(){
        for(int i =0; i<spells.size(); i++){
            System.out.println(spells.get(i).toString()); // Prints each spell once on a new line
        }

    }

    public double castSpell(String name, int seed){
        for(int i =0; i<spells.size(); i++){
            if (name.toLowerCase().equals(spells.get(i).getName())){ // Compares the lowercase version of the name to the name of the spell
                Spell cast = spells.get(i); // If they're equal, there is a spell created with the same constructors
                return cast.getMagicDamage(seed); // Returns the getMagicDamage with the provided seed
            }
        }
        return -1; // Or returns -1
    }
}
