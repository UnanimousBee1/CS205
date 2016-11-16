  class Tree();

 case class EmptyTree() extends Tree;
 
 case class NodeTree(data: Int, left:Tree, right:Tree) extends Tree;


object Q8 {
   def main(args: Array[String]): Unit = {
     
     var newTree = new Tree
     
     //-------------------------------------------------------------------------------------------------------
     def stringify(tree: Tree): String = {
       tree match{
         case EmptyTree() => "";
         case NodeTree(x:Int, y:Tree, z:Tree) => stringify(y) +" "+ x.toString() + " " +stringify (z);
         
       }
     }
     //-------------------------------------------------------------------------------------------------------
      def InsTree(tree: Tree,n: Int): Tree = {
        tree match{
          case EmptyTree() => NodeTree(n, EmptyTree(), EmptyTree())
          case NodeTree(x:Int, y: Tree, z:Tree) => if(n<=x)  NodeTree(x:Int, InsTree(y,n), z:Tree) 
                                                   else      NodeTree(x:Int, y, InsTree(z,n))
        }
      }
     
     
     //-------------------------------------------------------------------------------------------------------
     def doubleEle(tree: Tree ): Tree = {
       tree match{
         case EmptyTree() => EmptyTree();
         case NodeTree(x:Int, y:Tree, z:Tree) => NodeTree(x*2, doubleEle(y), doubleEle(z));
         
       }

     }
     //-------------------------------------------------------------------------------------------------------
     def MapTree(tree: Tree,f: Int => Int): Tree = {
       tree match{
         case EmptyTree() => EmptyTree();
         case NodeTree(x:Int, y:Tree, z:Tree) => NodeTree (f(x), MapTree(y,f), MapTree(z,f))
       }
       
     }
     //-------------------------------------------------------------------------------------------------------     
     def Sum(tree: Tree): Int = {
       tree match{
         case EmptyTree() => 0
         case NodeTree(x:Int, y:Tree, z:Tree) => x+Sum(y)+Sum(z)      
       }   
     }
     //-------------------------------------------------------------------------------------------------------     
     def FoldTree(n: Int, tree: Tree, f: (Int , Int) => Int): Int = {
       tree match{
         case EmptyTree() => n
         case NodeTree(x:Int, y:Tree, z:Tree) => FoldTree(FoldTree(f(x,n),y,f),z,f)
       }
     }
     //-------------------------------------------------------------------------------------------------------     
     def cont(lst1:List[Int],lst2:List[Int],orig: List[Int]): Boolean ={
       (lst1,lst2) match {
         case (Nil,_) => false
         case (_,Nil) => true
         case (hd1::tail1, hd2::tail2) => if(hd1==hd2)
                                            cont(tail1,tail2,orig)
                                          else
                                            cont(tail1,orig,orig)
       }
     }
  
     //-------------------------------------------------------------------------------------------------------     

   val test: Tree =  NodeTree(7, NodeTree(5, EmptyTree(), NodeTree(8, EmptyTree(), EmptyTree())), EmptyTree())
   val ls: List[Int] = List(1,2,3,4,5)
   println("Tree: "+stringify(test))
   //println("Tree: "+ MapTree(test,x=>x*3))
   //println("Sum: "+ Sum(test))
   //println("Ins: "+ InsTree(test,4))
   //println("Fold: "+ FoldTree(0,test,(x,y)=>x+y))
   val test2 = List(1,2,3,4,5,6)
   val test3 = List(2,3,4)
   println(cont(test2,test3,test3))
   }
  
}
