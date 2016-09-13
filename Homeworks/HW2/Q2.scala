

object Q2 {
  def main(args: Array[String]): Unit = {
    var ls1:List[Int] = List();//First half of the split
    var ls2:List[Int] = List();//second half of the split list
    var count:Int = 1;         //backup counter
    
    def Split(lst: List[Int]): List[Int] = {
      if(lst.isEmpty==true){
        return ls1;
      }
      else{
      if (count == 0){//alternating the appending of the lists
                          ls1=ls1:+lst.head;//adding head to list 1
                          count=count+1;
                          Split(lst.tail)}//passing the rest of the list
        else{//alternating the appending of the lists
          ls2=lst.last::ls2;//adding last element to list 2
          count=count-1
          
          Split(lst.init)}//Passing everything but the last element of the list
      }

    }
    var list = List(1,2,3,4,5,6,7)
    println("diff lists = "+ list);
    Split(list)
    println(ls1+"\n"+ls2);
    
  }
}