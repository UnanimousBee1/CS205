class Expr;
case class Num(a: Int) extends Expr
case class Plus(a:Expr,b:Expr) extends Expr
case class Minus(a:Expr, b:Expr) extends Expr
case class Mult(a:Expr, b:Expr) extends Expr 



object Q7 {
  def main(args: Array[String]): Unit = {
   def Eval(expr: Expr): Int = {
     expr match{
       case Num(a) => a
       case Plus(a,b) => Eval(a)+Eval(b) 
       case Minus(a,b) => Eval(a)-Eval(b)
       case Mult(a,b) => Eval(a)*Eval(b)
     }
   }
   val test: Expr = Plus(Num(3),Mult(Num(4),Num(5)))
   println("ans = "+ Eval(test))
  }
}