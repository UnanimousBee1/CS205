import collection.mutable.HashMap

/*Create a class structure to represent a logical formula as defined earlier. You need to
create a base class and a set of derived classes each representing one logical operator.*/

class lformula;
case class VAR(a: String) extends lformula
case class AND(a:lformula, b:lformula) extends lformula
case class OR(a:lformula, b:lformula) extends lformula
case class NEG(a:lformula) extends lformula

object Q2 {
  def main(args: Array[String]): Unit = {
    var test: lformula = AND(OR(VAR("x"),VAR("y")),NEG(VAR("z")));//test variable as given in the question
    val x = HashMap[String,Boolean]("x"->true,"y"->false,"z"->false);//Map for assignment
    var logic:Int = 0
    var back: List[Boolean] = Nil
    
/*Write a function ListFreeVariables that takes a formula as an input and returns the
list of free variables present in that formula*/
    
    def ListFreeVariables(form: lformula): List[String] ={//function for finding free variables
      form match{
        case VAR(a) => List(a);
        case AND(a,b) => ListFreeVariables(a):::ListFreeVariables(b)
        case OR(a,b) => ListFreeVariables(a):::ListFreeVariables(b)
        case NEG(a) => ListFreeVariables(a)
      }
    }
    
/*Write a function IsSatisfiable that takes a formula and an assignment to free variables
as an input and checks if the formula is satisfiable under this assignment.*/
    
    def IsSatisfiable(form: lformula, assign: HashMap[String,Boolean]): Boolean ={
      
      form match{
      case VAR(a)   => assign(a)
      case AND(a,b) => if(IsSatisfiable(a,assign)==true && IsSatisfiable(b,assign)==true) true
                       else false
      case OR(a,b)  => if(IsSatisfiable(a,assign)==false && IsSatisfiable(b,assign)==false) false
                       else true
      case NEG(a)   => if(IsSatisfiable(a,assign) == true) false
                       else true
      }    
    }
    
/*Write a function ListAllAssignments that takes a formula and returns the set of all
possible assignments to free variables present in that formula. For example, if the formula
contains free variables x, y and z then there are 8 possible assignments (2^3) of True or
False to these variables. This function should return all those assignments. [Bonus:30]*/
    
    def ListAllAssignments(form: lformula,z:List[String], assign: HashMap[String,Boolean]): List[Boolean] ={
      for(i <- 0 to z.length-1){
      assign(z(i))==true  
      back=back:+IsSatisfiable(form,assign)
      assign(z(i))==false
      back=back:+IsSatisfiable(form,assign)
      }
      return back
    }
    
    
    println("List of all free variables: "+ListFreeVariables(test),"\nIs the function satisfiable: "+IsSatisfiable(test,x))
    println("BONUS QUESTION: "+ListAllAssignments(test,ListFreeVariables(test),x))
  
  }
}