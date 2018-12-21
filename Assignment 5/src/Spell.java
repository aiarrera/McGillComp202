// Name: Dakksh Nandrajog
// ID: 260775826
import java.util.Random;

public class Spell {
    private String name;
    private double minDamage;
    private double maxDamage;
    private double spellSuccess;

    public Spell(String name, double minDamage, double maxDamage, double spellSuccess){
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.spellSuccess = spellSuccess;

        if(minDamage<0 || minDamage>maxDamage || spellSuccess <0 || spellSuccess > 1){ // Any argument for argument exception
            throw new IllegalArgumentException();
        }
    }

    public String getName(){
        return name;
    }

    public double getMagicDamage(int seed){
        Random damageGen = new Random(seed);
        double start = 0.0; // Random number is created between 0.0 and 1.0, using the seed
        double end = 1.0;
        double result = start + ((damageGen.nextDouble()) * (end-start));

        if(result > spellSuccess){ // If the result is more than the spellSuccess, then 0 is returned
            return 0;
        } else {
            return result;
        }
    }

    public String toString(){
        return name + "" + minDamage + "" + maxDamage + (spellSuccess*100)+"%";
    }


}
