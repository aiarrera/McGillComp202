// Name: Dakksh Nandrajog
// ID: 260775826
import java.util.Random;
import java.util.Scanner;

public class BattleGame {
    private static Random rand = new Random();

    public static void playGame(String playerFN, String monsterFN, String spellFile){
        try { // The entire program is between a try/catch statement to prevent the game from being run if Characters are not found,
            Character player = FileIO.readCharacter(playerFN); // and will not crash the program
            Character monster = FileIO.readCharacter(monsterFN);

            if (FileIO.readSpells(spellFile) == null) {
                System.out.println("The game will be played without spells");
            } else {
                Character.setSpells(FileIO.readSpells(spellFile)); // Only the player is allowed spells, so the according are set.
                Character.displaySpells();
            }
            Scanner scan = new Scanner(System.in);

            System.out.println("Name: " + player.getName());
            System.out.println("Current health: " + player.getCurrHealth());
            System.out.println("Attack value: " + player.getAttackValue());
            System.out.println("Number of wins: " + player.getNumWins());

            System.out.println("Name: " + monster.getName());
            System.out.println("Current health: " + monster.getCurrHealth());
            System.out.println("Attack value: " + monster.getAttackValue());
            System.out.println("Number of wins: " + monster.getNumWins());

            while (player.getCurrHealth() > 0 && monster.getCurrHealth() > 0) { // To ensure the game stops if one characters health drops below 0
                if (scan.next().equals("attack")) { // The player first attacks, and then the monster
                    int rSeed = rand.nextInt();
                    double pAttack = player.getAttackDamage(rSeed);
                    System.out.println(player.getName() + " attacks for " + pAttack + " damage!");
                    if (monster.takeDamage(pAttack) > 0) {
                        System.out.println(monster.getName() + "'s current health is" + monster.takeDamage(pAttack));
                    } else {
                        System.out.println(monster.getName() + " has been knocked out!");
                        return;
                    }

                    double mAttack = monster.getAttackDamage(rSeed);
                    System.out.println(monster.getName() + " attacks for " + mAttack + " damage!");
                    if (player.takeDamage(mAttack) > 0) {
                        System.out.println(player.getName() + "'s current health is" + player.takeDamage(mAttack));
                    } else {
                        System.out.println(player.getName() + " has been knocked out!");
                        return;
                    }
                } else if (scan.next().equals("quit")) {
                    System.out.println("Goodbye!");
                    return;
                } else {
                    int rSeed = rand.nextInt();
                    double pAttackSpell = player.castSpell(scan.next(), rSeed);
                    if (pAttackSpell <= 0) {
                        System.out.println(player.getName() + " tried to cast " + scan.next() + ", but they failed.");
                    } else {
                        System.out.println(player.getName() + " casts " + scan.next() + " dealing " + pAttackSpell + " damage");
                        if (monster.takeDamage(pAttackSpell) > 0) {
                            System.out.println(monster.getName() + "'s current health is" + monster.takeDamage(pAttackSpell));
                        } else {
                            System.out.println(monster.getName() + " has been knocked out!");
                            return;
                        }

                        double mAttack = monster.getAttackDamage(rSeed);
                        System.out.println(monster.getName() + " attacks for " + mAttack + " damage!");
                        if (player.takeDamage(mAttack) > 0) {
                            System.out.println(player.getName() + "'s current health is" + player.takeDamage(mAttack));
                        } else {
                            System.out.println(player.getName() + " has been knocked out!");
                            return;
                        }

                    }
                }
            }

            if (monster.getCurrHealth() <= 0) { // If the monster's health is below 0, that means the player has won
                System.out.println(player.getName() + " has won!");
                player.increaseWins();
                FileIO.writeCharacter(player, playerFN); // The information is updated in player's file.
                System.out.println("Games won for " + player.getName() + ": " + player.getNumWins());
            } else if (player.getCurrHealth() <= 0) { // And if player's current health is below 0, then the monster has won
                System.out.println(monster.getName() + "has won!");
                monster.increaseWins();
                FileIO.writeCharacter(monster, monsterFN); // The information is updated in monster's file
                System.out.println("Games won for " + monster.getName() + ": " + monster.getNumWins());
            }
        } catch (Exception e){ // This will be printed in case of any errors.
            System.out.println("The game can not be played");
        }

    }
}
