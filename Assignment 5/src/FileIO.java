// Name: Dakksh Nandrajog
// ID: 260775826
import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static Character readCharacter(String filename){
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String currLine = br.readLine();
            String[] read = new String[4];

            for(int i =0; i<4;i++){
                read[i] = currLine; // Adds each current line to an array
                currLine = br.readLine(); // And moves on to next line
            }

            br.close();
            fr.close();

            String name = read[0]; // Assigns value from the arrays
            double attackValue = Double.parseDouble(read[1]); // Parses them into doubles as it is a String array
            double maxHV = Double.parseDouble(read[2]);
            int numWins = Integer.parseInt(read[3]);

            return new Character(name, attackValue, maxHV, numWins); // new Character is created from .txt file, and is returned


        } catch (FileNotFoundException e){ // Individual catches for possible exceptions rather than generalized catch statement
            System.out.println("The file is not found");
            return null;
        } catch (IOException f){
            System.out.println("There is an IO error");
            return null;
        }

    }

    public static ArrayList<Spell> readSpells(String sFile){
        try{
            FileReader sf = new FileReader(sFile);
            BufferedReader bsf = new BufferedReader(sf);

            ArrayList<Spell> spellRead = new ArrayList<>();
            String currLine = bsf.readLine();
            while(currLine != null){
                String[] parts = currLine.split("\t"); // Splits each line by the tab character, and puts it into an array
                String name = parts[0]; // The array values are used as constructors
                double minDamage = Double.parseDouble(parts[1]);
                double maxDamage = Double.parseDouble(parts[2]);
                double spellSuccess = Double.parseDouble(parts[3]);

                Spell read = new Spell(name,minDamage,maxDamage,spellSuccess); // New spell is created from this constructor
                spellRead.add(read);

                currLine = bsf.readLine(); // Ready to read next line.
            }

            bsf.close();
            sf.close();

            return spellRead;

        } catch (FileNotFoundException e){ // Individual catches for possible exceptions rather than generalized catch statement
            System.out.println("The file is not found");
            return null;
        } catch (IOException f){
            System.out.println("There is an IO error");
            return null;
        }
    }

    public static void writeCharacter(Character input, String filename){
        try{
            File file = new File(filename); // Creates a new file with the provided filename
            FileWriter fw = new FileWriter(filename, true); // Only appends to the existing file, instead of creating new one each time.
            BufferedWriter bw = new BufferedWriter(fw);

            String[] character = new String[4];
            character[0] = input.getName(); // Array is organized in order of how they have to be printed to file.
            character[1] = String.valueOf(input.getAttackValue());
            character[2] = String.valueOf(input.getMaxHealth());
            character[3] = String.valueOf(input.getNumWins());

            for(int i = 0; i<4; i++){ // Loop makes code concise and reduces redundancy
                bw.write(character[i]);
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException f){ // Catches possible IOException
            System.out.println("There is an IO error");
        }

    }

}
