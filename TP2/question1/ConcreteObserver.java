/**/ package question1;

/**/ import java.util.Observable;
/**/ import java.util.Observer;
/**/ import java.util.Stack;

/**
 * Decrivez votre classe ConcreteObserver ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
/**/ public class ConcreteObserver implements Observer
/**/ {
/**/   private Stack<Observable> senders;
/**/   private Stack<Object> arguments;

/**/   public ConcreteObserver()
/**/   {
/**/     senders= new Stack<Observable>();
/**/     arguments= new Stack<Object>();
/**/   }


		/**
		 * @param Observable pour l'objet qui observe, Arg un Object qui a été observé  
		 */
/**/   public void update( Observable observable, Object arg )
/**/   {
/**/     // affichage a commenter avant de soumettre a JNews :
/**/     //System.out.println( observable.toString() );
/**/     senders.push( observable );
/**/     arguments.push( arg );
/**/   }

/**/   public Stack<Observable> senders()
/**/   {
/**/     return senders;
/**/   }

/**/   public Stack<Object> arguments()
/**/   {
/**/     return arguments;
/**/   }
  
/**/ } // ConcreteObserver
