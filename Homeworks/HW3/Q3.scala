

object Q3 {
  
  var sum:Int = 0
  
  var i:Int = 0
  trait Runnable {
def run(): Unit
}
  
  
class mythread(x: List[Int]) extends Thread with Runnable{
override def run():Unit = {
  while(i!=x.length){
    sum = sum+x(i); i += 1
  }
}
}

def main(args: Array[String]): Unit = {
  
  val x1 = 1 to 250 toList
  val x2 = 250 to 500 toList
  val x3 = 500 to 750 toList
  val x4 = 750 to 1000 toList
  
  
  val t1 = new Thread(new mythread(x1))
  val t2 = new Thread(new mythread(x2))
  val t3 = new Thread(new mythread(x3))
  val t4 = new Thread(new mythread(x4))
  t1.start;t2.start;t3.start;t4.start
  println(sum)
}
}