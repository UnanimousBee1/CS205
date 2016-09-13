

object Q3 {
  
def main(args: Array[String]): Unit = {
    var ls1:List[Int] = List(); // Defining a backup list ls1
        var test: List[Int] = List(1,2,3,4,5,7);var n = 6;

    
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
    println("Inserting number 6 in the list: "+sortInsert(test,n))//function call
    test=ls1;
  }
}