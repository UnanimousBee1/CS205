

object Q3 {
  
println("Enter the number of threads: ")
val NumThreads = readInt()

var t:Array[Thread] = new Array[Thread](NumThreads)
var sum:Array[Int] = new Array[Int](NumThreads)  

var SUM = 0
var m = 10000/NumThreads
var k=0


class mythread(x: List[Int],i: Int) extends Runnable{
override def run():Unit = {
  
   for( a <- 0 to x.length-1){
    sum(i) = sum(i)+x(a); 
  }

}
}

def main(args: Array[String]): Unit = {

  for (j<-0 to NumThreads-1){//Creating number of user defined threads
    if(k+(m*2)>10000){//If the number of threads is not divisible by 1 million then left elements are added to last thread
      t(j) = new Thread(new mythread(k+1 to 10000 toList,j))
      println("Thread "+(j+1)+" = ",k+1 to 10000 toList)
      
    }
    else{//Equally distributing elements to all threads
      t(j) = new Thread(new mythread(k+1 to k+m toList,j))
      println("Thread "+(j+1)+" = ",k+1 to k+m toList)
      k=k+m 
      
      }
  }
  
  for (j<-0 to NumThreads-1){//Executing threads
    t(j).start
  }
  

for (j<-0 to NumThreads-1){//Waiting for the threads to end
    t(j).join()
  }

for (j<-0 to NumThreads-1){//Adding sum of all threads
    SUM=sum(j)+SUM
  }

println("\n\n Sum of first 10,000 natural numbers: "+SUM)

  }
}
