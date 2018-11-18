import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
  //The provided code generates random ages for sheep, and picks random names from the below array
  //You can modify this list of names as you wish (add/remove/replace elements).
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
    "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
    "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
    "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
    "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
    "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
    "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
    "George VI","Elizabeth II"};
  private static Random r = new Random(123);
  
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  
  public static void main(String[] args){
    //Student Name: Dakksh Nandrajog
    //Student Number: 260775826
    //Your code goes here.

    Scanner sc = new Scanner(System.in); // Initializes scanner for user inputs

    System.out.println("Name of farm: ");
    String farmName = sc.nextLine();
    System.out.println("Name of dog: ");
    String dogName = sc.nextLine();
    System.out.println("Dog breed: ");
    String dogBreed = sc.nextLine();
    System.out.println("Number of sheep: ");
    int numSheep = sc.nextInt();


    Dog dog = new Dog(dogName, dogBreed);
    Sheep[] sheepArr = new Sheep[numSheep];
    for(int i = 0;i<numSheep;i++){
      Sheep sheepAtInd = new Sheep(getRandomName(), getRandomAge()); // Uses both provided methods above
      sheepArr[i] = sheepAtInd; // Adds the name and age to an array for sheep
    }

    Farm farm = new Farm(farmName,dog,sheepArr);

    farm.printFarm();

    double finalWeight = (farm.getWool()*numSheep); // Mulitplies the getWool method with number of sheep
    System.out.println("Sheared weight : "+ finalWeight);
    System.out.println("Value: "+ "$"+(finalWeight*1.45));

  }
}
