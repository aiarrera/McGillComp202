//Student name: Dakksh Nandrajog
//ID: 260775826

public class ExamGrading {

    public static double[] gradeAllStudents(char[][]responses,char[]solutions){

    double[] answer = new double[responses.length]; // Creates a new array of length of the number of responses/students

    for(int i=0;i<responses.length;i++){
        for(int j = 0; j<responses[i].length;i++){
            if(responses[i].length != solutions.length){ // If responses are not equal to amount of solutions, IAE is thrown
                throw new IllegalArgumentException("Student "+i+" has not provided correct amount of answers." +
                        "Given: "+responses[i].length+" Expected: "+ solutions.length);
            } else if (responses[i][j] == solutions[j]) {
                answer[i] += (1.0/solutions.length)*100; // This will add the percentage of 1 right answer, for each right answer
            }
        }

    }

    return answer;

    }

    public static int numWrongSimilar(char[]responseOne,char[]responseTwo,char[]solutions){
        int cheat = 0;

        if(responseOne.length != responseTwo.length){
            throw new IllegalArgumentException("The array of responses are not the same length");
        } else if ( responseOne.length != solutions.length || responseTwo.length != solutions.length){
            throw new IllegalArgumentException("The array of responses are not corresponding to the solutions");
        } else {
            for(int i =0;i<responseOne.length;i++){
                if(responseOne[i] == responseTwo[i]){ // If the 2 responses for the same question are the same
                    if(responseOne[i] != solutions[i] && responseTwo[i] != solutions[i]){ // And if each of the answers are different from the solutions
                        cheat = cheat + 1; // Add one to the cheating count
                    }
                }
            }

        }

        return cheat;
    }

    public static int numMatches(char[][]responses,char[]solutions,int index,int simThres){
        int check = 0;

        for(int i = 0; i<responses.length; i++){
            if(i == index){
                continue;
            } else if (numWrongSimilar(responses[index],responses[i],solutions) >= simThres){ // Calling numWrongSimilar in the if statement allows
                check = check + 1;                                                            // my code to be more concise and use less variables
            }
        }

        return check;
    }

    public static int[][] findSimilarAnswers(char[][]responses,char[]solutions,int simThres){
        int [][] simAns = new int[responses.length][];

        for(int i =0;i<responses.length;i++){
            simAns[i] = new int[numMatches(responses,solutions,i,simThres)]; // This creates an array of jagged sizes, corresponding to numMatches response
            int k = 0;
            for(int j =0; j<responses.length;j++){
                if(i == j){
                    continue; // If the index is going to compare to itself, then continue
                } else if (numWrongSimilar(responses[i],responses[j],solutions) >= simThres){
                    simAns[i][k] = j; // Since k is at 0, we start inserting values from the 0th place
                    k++; // Increase k by 1, so the next entry goes in the next space
                }
            }
        }
        return simAns;
    }
}
