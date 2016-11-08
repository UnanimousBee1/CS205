

object Q2 {
  def main(args: Array[String]): Unit = {
    
    val stack1 = new scala.collection.mutable.Stack[Int]
    val stack2 = new scala.collection.mutable.Stack[Int]
    var test: List[Int] = List(1,2,3,4,5,6,7,8,9)
    var lst1: List[Int] = List()
    var lst2: List[Int] = List()
    
    while(test.length>0){
      if(test.length == 1) {
        
        stack2.push(test.head); 
        test=test.tail;
      }
      else{
        stack1.push(test.head);
        stack2.push(test.last);
        test=test.init.tail;
      }
    }
    
    
    while(test == Nil){
      if(stack1 != Nil)
        lst1=stack1.pop::lst1;
      
      else if(stack2 != Nil)
        lst2=lst2:+stack2.pop;
      
      else
        test=List(1);
    }
    
    println("List 1: "+lst1,"\n List 2:"+lst2)
  }
}