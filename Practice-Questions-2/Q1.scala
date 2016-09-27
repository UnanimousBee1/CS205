

object Q1 {
  def main(args: Array[String]): Unit = {

   
    
    def Split(lst: List[Int], ls1: List[Int], ls2: List[Int]): (List[Int],List[Int]) = {
     
      lst match{
        case Nil => (ls1,ls2)
        case hd::tail => 
          Split(lst.tail.init, ls1:+hd,lst.last::ls2)
        
      }

    }
    val list: List[Int] = List(1,2,3,4,5,6,7,8,9)
    if(list.length %2 != 0){
      val(l1,l2) = Split(list.tail,List(list.head),List())
      println(l1+"\n"+l2);}
    
    else{
      val(l1,l2) = Split(list,List(),List())
      println(l1+"\n"+l2);}
    
    
    
  }
}


//Use Fold to do this