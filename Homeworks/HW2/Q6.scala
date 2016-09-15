

object Q6 {
  
  
  def main(args: Array[String]): Unit = {

  
      val test:List[Int] = List(2,6,1,3,4,8,5);//Input lsit
      var ls1: List[Int] = List();//Pivot sorted list
      var count:Int = 1;
      var sortedList: List[Int] = List();
      
      def pivotSort(list: List[Int], x:Int): List[Int]={//Function definition
        if (count==1){
          if (list.isEmpty == true) {
            ls1=x::ls1;
            count += 1;
            return ls1;
          }
        }
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
      
      def quickSort(lst: List[Int]): List[Int]={
        lst match{
          case Nil => Nil;
          case hd::tail =>         ls1 = Nil
                           sortedList=pivotSort(sortedList,hd)
                           quickSort(tail)
        }
        
      }
      
      quickSort(test)
      println(test+"\n"+sortedList)
}
}