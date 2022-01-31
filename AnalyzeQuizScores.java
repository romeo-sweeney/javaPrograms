// Roméo Sweeney
// Analyzing quiz scores using different function from BinarySearch library

import java.util.Scanner;

public class AnalyzeQuizScores {

   public static void main(String[] args) {


      Scanner sc = new Scanner(System.in);
      
      int numStudents = sc.nextInt();
      
      String[] firstNames = new String[numStudents];
      String[] lastNames = new String[numStudents];
      int[] scores = new int[numStudents];
      
      for (int i = 0; i < numStudents; i++) {
         firstNames[i] = sc.next();
         lastNames[i] = sc.next();
         scores[i] = sc.nextInt();
      }
      
      sc.close();
      
      // Phase 1
      if(BinarySearch.exists(scores, 0, scores.length, 87)){
         System.out.println("Someone did score 87.");
      }else{
         System.out.println("No one scored 87.");
      }
      if(BinarySearch.exists(scores, 0, scores.length, 80)){
         System.out.println("Someone did score 80.");
      }else{
         System.out.println("No one scored 80.");
      }
   
      // Phase 2
      int count = 0;
      int lowerIdx = BinarySearch.lowerBound(scores, 0, scores.length, 93);
      int upperIdx = BinarySearch.upperBound(scores, 0, scores.length, 93);
      // or(int i = lowerIdx; i < upperIdx; i++){
      //    count++;
      // }
      System.out.printf("%d students scored 93.\n", (upperIdx-lowerIdx));
   
      // Phase 3
      int lowerIdx1 = BinarySearch.lowerBound(scores, 0, scores.length, 80);
      int upperIdx1 = BinarySearch.upperBound(scores, 0, scores.length, 89);
      
      System.out.println("The following students received Bs:");
      for (int i = lowerIdx1; i < upperIdx1; i++){
         System.out.printf("%s %s\n", firstNames[i], lastNames[i]);
      }
      
      //Phase 4
      System.out.println("The following students scored 79:");
      
      if(BinarySearch.exists(scores, 0, scores.length, 79)){
         int lowerIdx2 = BinarySearch.lowerBound(scores, 0, scores.length, 79);
         int upperIdx2 = BinarySearch.upperBound(scores, 0, scores.length, 79);
         for(int i = lowerIdx2; i < upperIdx2; i++){
            System.out.printf("%s %s\n", firstNames[i], lastNames[i]);
         }
      }
   }
}
