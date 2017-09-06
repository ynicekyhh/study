package algorithm;

import java.util.Scanner;

public class JollyJumpers 
{
   public static void main(String[] args) 
   {
      Scanner s = new Scanner(System.in);
      
      while(s.hasNextInt())
      {
         int inputCnt = s.nextInt();
         int[] inputVal = new int[inputCnt];
         int[] subVal = new int[inputCnt-1];
         String result = "Jolly";
   
         // Input
         for(int i=0; i<inputCnt; i++)
         {
            inputVal[i] = s.nextInt();
            
            if(i > 0)
               subVal[i-1] = Math.abs(inputVal[i]-inputVal[i-1]);
         }
   
         // SORT
         int temp = 0;
         boolean changeYn = true;
         while(changeYn)
         {
            changeYn = false;
            for(int i=1; i<subVal.length; i++)
            {
               if(subVal[i-1] > subVal[i])
               {
                  temp = subVal[i-1];
                  subVal[i-1] = subVal[i];
                  subVal[i] = temp;
                  changeYn = true;
               }
               else if(subVal[i-1] == subVal[i])
                  result = "Not jolly";
            }
         }

         // confirm
         for(int i=1; i<=subVal.length; i++)
         {
            if(subVal[i-1] != i)
            {
               result = "Not jolly";
               break;
            }
         }
         
         System.out.println(result);
      }
   }

}