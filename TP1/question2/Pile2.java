package question2;

import java.util.Stack;

import question1.PilePleineException;
import question1.PileVideException;

public class Pile2 implements PileI, Cloneable
{
  /** par delegation : utilisation de la class Stack */
  private Stack<Object> stk;

  /** la capacite de la pile */
  private int capacite;
  
  /** Creation d'une pile.
   * @param taille la taille de la pile, la taille doit etre > 0
   */
  public Pile2( final int pCapacite )
  {
	  stk = new Stack<Object>() ;
	  this.setCapacite(pCapacite <= 0 ? CAPACITE_PAR_DEFAUT : pCapacite);
  } // Pile2(.)
  
  // constructeur fourni
  public Pile2()
  {
    this(CAPACITE_PAR_DEFAUT);    
  } // Pile2()

  public void empiler( final Object pO ) throws PilePleineException
  {
	  if(estPleine()) throw new PilePleineException() ;
	  stk.push(pO) ;
  } // empiler(.)
  
public Object depiler() throws PileVideException
  {
	  if(estVide()) throw new PileVideException() ;
	  return (Object) stk.pop();
  } // depiler()
  
public Object sommet() throws PileVideException
  {
	  if(estVide()) throw new PileVideException() ;
    return (Object) stk.lastElement() ;
  } // sommet()
  
  public int taille()
  {
    return stk.size() ;
  } // taille()
  
  public int capacite()
  {
    return getCapacite() ;
  } // capacite()
  
  public boolean estVide()
  {
	  return stk.isEmpty() ;
  }
    
  
  public boolean estPleine()
  {
    return taille() == getCapacite() ;
  }
  
  /** Retourne une representation en String d'une pile, 
   * contenant la representation en String de chaque element.
   * @return une representation en String d'une pile
   */ 
  @Override public String toString()
  {
    String str = "]";
	for(Object o : stk) 
		str = ", "+o.toString() + str ;
		//str += o.toString()+ ", " ;
	
	//if(!this.estVide()) str = str.substring(0, str.length()-2) ; 
	if(!this.estVide()) str = str.substring(2, str.length()) ; 
    return "[" + str ;
    
  } // toString()
  
  @Override public boolean equals( final Object obj )
  {
	  if(obj == null) return false ;
	  if(!(obj instanceof Pile2)) return false ;
	  Pile2 p = (Pile2) obj ; 
	  
	  if(p.getCapacite() != this.getCapacite()) return false ;
	  if(p.taille() != this.taille()) return false ;
	  
	  for(int i=0 ; i < taille() ; i++) {
		  if(!this.stk.get(i).equals(p.stk.get(i))) return false ;
	  }
	  
    return true ;
  } // equals(.)
  
  
  // fonction fournie
  @Override public int hashCode()
  {
    return this.toString().hashCode();
  } // hashCode()
  
  // fonction fournie
  @SuppressWarnings("unchecked")
  @Override public Object clone() throws CloneNotSupportedException
  {
    Pile2 vP = new Pile2( this.capacite() );
    vP.stk = (Stack<Object>)this.stk.clone();
    return vP;
  }




public int getCapacite() {
	return capacite;
}

public void setCapacite(int capacite) {
	this.capacite = capacite;
}
} // Pile2
