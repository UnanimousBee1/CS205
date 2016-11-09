/*Write a function Substring in scala that takes a string, say str, and two integer indices i and
j as arguments. It returns the substring of str starting from the index i upto (not including)
j. For example, if the input string is ”Class test” and i and j are respectively 2 and 4 then the
function Substring(str,i,j) should return ”as”. Your function should not use any string
manipulation function directly*/

object Q1 {
  def main(args: Array[String]): Unit = {
    var last: String = ""
    
    def Substring(str: String,i: Int,j: Int ): String ={
      for(x<-i to j-1){
        last = last:+str(x)
      }
      return last
    }
    var test: String = "Class test";
    println(Substring(test,2,4))
   
  }
}



