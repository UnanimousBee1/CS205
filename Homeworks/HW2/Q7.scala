

object Q7 {
  
  
  def main(args: Array[String]): Unit = {
    
    var mainNum:Int = 3;//main number
    var powerNum:Int = 16;//main power
    var count:Int = 1;//To count the power
    var backPow:Int = 1;//backup power
    var backNum:Int = 1;//backup for the main number
    var back:Int =1 //backup variable
    
    def fastPower(x: Int, n: Int): Int ={// Function definition
      var p: Int = 1;
                    
      if (n==0){//Base case for even power
        
        return backNum
      }
      
      if (n==1){//Base case for odd power
        return backNum*mainNum
      }
      

      if (count>n){//When power count goes above the desiered new parameters are passed to the function
        backNum=backNum*x;
        count = 1;
        fastPower(mainNum,n-backPow)
      }
      
      
      else{//if count is still less than desiered power
        back = x;
        p=x*x;
        if (count==1)
          count += 1;       
        else {
          backPow = count;
          count = count*2;
          if (count>n) p=back//check for count going above desiered power
        }
        fastPower(p,n)
      }
    }
    println(mainNum+" to the power "+ powerNum+" = "+ fastPower(mainNum,powerNum))
  }
}