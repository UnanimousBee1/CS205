
object Q4 {
 

  def main(args: Array[String]): Unit = {
    
    var ls1:List[Int] = List(); // Defining a backup list ls1
    var test: List[Int] = List(532,4,123,5,75,8,90)
    var sortedlist:List[Int] = List();//Defining a sorted list
      
  def sortInsert(lst: List[Int], num: Int): List[Int]={
      lst match{ //Using match
        case Nil => ls1=num::ls1;//case for empty list
        case hd::tail => if(hd > num) {ls1=ls1:+num:+hd;//adds the number to its sorted location
                                       ls1=ls1:::tail;}//adds the rest of the list
                         else if(lst.length==1)ls1=ls1:+hd:+num;
                         else 
                           {
                           ls1=ls1:+hd;
                           sortInsert(tail,num);//tail recursive function
                           }
      }
      return ls1
    }
  
  


    def InsertionSort(UnsortedList: List[Int]): List[Int] = {//Function definition

      if(UnsortedList.isEmpty == true)
             return sortedlist; 
      else{
     sortedlist=sortInsert(sortedlist,UnsortedList.head)
     ls1=Nil;
     InsertionSort(UnsortedList.tail)
     }
    }
    
    println(test)
    InsertionSort(test)
    println("The sorted list is: ")
    println(sortedlist)
  }
}