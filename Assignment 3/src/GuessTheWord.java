//Fill in your name and student number
//Name: Dakksh Nandrajog
//Student Number: 260775826

// do NOT touch the following import statement
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    
    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband", 
        "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher", 
        "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge", 
        "harmony", "problem","awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant", 
        "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain", 
        "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich", 
        "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter", 
        "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure", 
        "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling", 
        "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different", 
        "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education", 
        "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball", 
        "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government", 
        "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university", 
        "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard", 
        "understand", "leadership", "revolution"};  
    
    // this method takes an integer as input and returns a random String from the array above.
    // you can use it, but do NOT modified neither the method NOR the above array. 
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }
    
    //========================
    // Enter your code below
    
    public static void main(String[] args) {
        play(124);
    }

    public static boolean isValidGuess(char c){
        int ascii = (int) c; // This typecasts the character as an integer, where it is checked for being a lower-case letter.
        if(ascii > 96 && ascii < 123){
            return true;
        } else {
            return false;
        }
    }

    public static int[] generateArrayOfGuesses(String a){
        int[] zeroes = new int[a.length()]; // The array is of the size of the word
        for(int i = 0; i<zeroes.length;i++){ // This puts 0s in every place of the array
            zeroes[i]= 0;
        }
        return zeroes;
    }

    public static boolean checkAndUpdate(String a, int[] zeroes, char c){
        for(int i =0; i<a.length()+1; i++){
            if(c == a.charAt(i)){
                zeroes[i] = 1; // If the character is in the word, that place in the array becomes a 1
                return true;
            }
        }
        return false;
    }

    public static String getWordToDisplay(String a, int[] zeroes, char c){
        String finalWord = ""; // This is an empty string which will be printed at the end.
        char[] word = new char[a.length()];
        for(int i =0; i<a.length()+1; i++){
            if(c == a.charAt(i)){
                if(zeroes[i] == 0){
                    word[i] = Character.toUpperCase(c);
                } else {
                    word[i] = c;
                }
            } else {
                word[i] = '-';
            }
        }

        for(int i =0; i<word.length+1; i++){
            finalWord = finalWord + word[i]; // The string adds on 1 character at a time from each index.
        }

        return finalWord;
    }

    public static boolean isWordGuessed(int[] zeroes){
        boolean check = true;
        for(int i =0; i<zeroes.length; i++){
            if(zeroes[i] == 1){
                check = check && true; // Since the 'AND' operator requires every statement to be TRUE to be printed as TRUE,
            } else{                    // this will ensure that every index is a 1 to be printed TRUE
                check = check && false;
            }
        }
        return check;
    }

    public static void play(int a){
        char letter;
        int lives = 10;

        String randWord = getRandomWord(a);
        int[] zeroes = new int[generateArrayOfGuesses(randWord).length];

        System.out.println("Welcome to Guess The Word!");
        System.out.println("Your secret word has been generated. It has " +randWord.length()+" characters. You have 10 lives. Good luck." );


        Scanner sc = new Scanner(System.in);
        letter = sc.next().charAt(0);
        int ascii = (int) letter;
        if(sc.next().length() >1){
            System.out.println("You can only use one character. Try again!");
        } else if(isValidGuess(letter) == false){
            System.out.println("Use a valid, lower case English character.");
        } else {
            while(lives>0){
                letter = sc.next().charAt(0);
                if(checkAndUpdate(randWord,zeroes,letter) == false){
                    System.out.println(getWordToDisplay(randWord,zeroes,letter));
                    lives = lives-1;
                    if(lives == 0){
                        System.out.println("You have no lives left. Better luck next time. The secret word was: "+randWord);
                    }else {
                        System.out.println("You have " + lives + " left");
                    }
                }
                System.out.println(getWordToDisplay(randWord,zeroes,letter));
                checkAndUpdate(randWord,zeroes,letter);
                if(isWordGuessed(zeroes) == true){
                    System.out.println("Congratulations! You guessed the secret word!");
                }

            }


        }

    }


       
}
