

object Q5 {
    def main(args: Array[String]): Unit = {
      
      val num: Int = 26;//Input number
      val test:List[Int] = List(17,2,95,16,30,22,77,35);//Input lsit
      var ls1: List[Int] = List();//Pivot sorted list
      def pivotSort(list: List[Int], x:Int): List[Int]={//Function definition
        list match{
          case Nil => Nil;
          case hd::tail => if (ls1.isEmpty == true){//Case when the sorted list is empty
                             ls1 = x::ls1//The element is added to the empty sorted list
                             pivotSort(list,x);
                           }
          //Compare each element of the main list to the element
                           else if(hd>x){//If head is greater append at the end of the list
                             ls1=ls1:+hd;
                             pivotSort(tail,x);//Pass tail and the element
                           }
                           else{//If head is smaller append at the start of the list
                             ls1=hd::ls1;
                             pivotSort(tail,x);//Pass tail and the element
                           }
        }
        return ls1
      }
      
      println("The element '"+num+"' at its right position in the list "+test)
      println("\nis :- "+pivotSort(test,num))//Function call
      
      
    }
}