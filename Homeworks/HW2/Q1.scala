

object Q1 {
  def main(args: Array[String]): Unit = {
    
    def fact(num: Int): Int ={//Function definition
      if (num<=1)
        return 1;
      else
        num * fact(num-1); // Recursive function fact
      //THe function keeps multiplying till num becomes 1
    }
    
    println("factorial of 5 = " + fact(5));// function call
  }
}