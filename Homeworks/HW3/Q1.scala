class Queue[+A];//Main class queue

case class EmptyQueue[A]() extends Queue[A];//Class foe empty queue

case class NonEmptyQueue[A] (first: A, rest: Queue[A]) extends Queue[A]{//Class for non empry queue
  /*override def equals(obj: Any): Boolean = (this,obj) match{
case _ @ NonEmptyQueue(s: A, r: Queue[A]) => (this==s)
case _ => false
  }*/
}

object Q1 {
  def main(args: Array[String]): Unit = {
    
    def EnQueue[A](queue: Queue[A], i: A): Queue[A]= {// Function for adding an element to the queue
      queue match{
        case EmptyQueue() => NonEmptyQueue(i,EmptyQueue());//If queue is empty, element is straight away added
        case NonEmptyQueue(a,rest) => NonEmptyQueue(i,queue);//Else element is placed behind the rest of the queue
      }
      
    }
    
    
    def Deque[A](queue: Queue[A],nqueue: Queue[A], finalQueue: Queue[A]): Queue[A] ={//Function to remove an element from the front of the queue
      queue match{
        case EmptyQueue() => EmptyQueue();//Empty queue will return an empty queue as there is no element to remove
        
        case NonEmptyQueue(a,rest) if rest!=EmptyQueue() => Deque[A](rest, NonEmptyQueue(a,nqueue),EmptyQueue())//If rest of the queue is not empty then first element is added to a dummy queue
        
        case NonEmptyQueue(a,rest) if rest==EmptyQueue() => nqueue match{//When rest of the queue is empty then the element is removed as it is not added to the dummy queue
          case NonEmptyQueue(x,y) => Deque[A](queue, y,NonEmptyQueue(x,finalQueue))//Dummy queue is reversed as it has elements stored in the reverse order due to recursion
          case EmptyQueue() => return finalQueue;//Final queue is returned
        }
          } 
    }
    
    var nq: Queue[Int] = NonEmptyQueue(1,NonEmptyQueue(2,NonEmptyQueue(3,EmptyQueue())))
    println("Main Queue: "+nq)
    nq=EnQueue(nq,0)
    println("\nAdd element 0: "+nq)
    nq=Deque(nq,EmptyQueue(),EmptyQueue())
    println("Remove last element: "+nq )
    
    
    
  }
}



