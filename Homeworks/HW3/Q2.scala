

object Q2 {
  def main(args: Array[String]): Unit = {
    
    val stack1 = new scala.collection.mutable.Stack[List[Int]]
    val stack2 = new scala.collection.mutable.Stack[List[Int]]
    var test: List[Int] = List(1,2,3,4,5,6,7,8,9)
    var lst1: List[Int] = List()
    var lst2: List[Int] = List()
    
    while(test.length>0){
      if(test.length == 1) {
        lst2=test.head::lst2;
        stack2.push(lst2); 
        test=test.tail;
      }
      else{
        lst1=lst1:+test.head;
        lst2=test.last::lst2;
        stack1.push(lst1);
        stack2.push(lst2);
        test=test.init.tail;
      }
    }

    println(stack1.pop+"\n"+stack2.pop)
  }
}