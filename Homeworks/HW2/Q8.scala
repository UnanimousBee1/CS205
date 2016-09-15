

object Q8 {
   def main(args: Array[String]): Unit = {
   
     var mainList: List[Int]=List(1,2,3);
     var permutations: Int = 1;
     var count: Int = 1;
     var finalList: List[List[Int]]= List(List());
     
     def fact(num: Int): Int ={//Function definition
      if (num<=1)
        return 1;
      else
        num * fact(num-1); // Recursive function fact
      //THe function keeps multiplying till num becomes 1
    }
     
     def permutationGen(list: List[Int]): List[List[Int]]={
       if(count==permutations) return finalList
       
       else{
         
       }
       
       return finalList
     }
     
     permutations = fact(mainList.length)
     println(permutations);
     permutationGen(mainList);
     //finalList=finalList:+List(1,2,3)
     println(finalList);
     println(mainList(2));
     
     
   }
  
}