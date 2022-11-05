package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;
/**
 * Decrivez votre classe PileVector ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class Pile3 implements PileI
{
	
  private Vector<Object> v;
  private int capacite ;

  public Pile3( final int pCapacite )
  {
	  v = new Vector<Object>() ;
	  this.setCapacite(pCapacite < 0 ? CAPACITE_PAR_DEFAUT : pCapacite);


    // a completer
  } // Pile3(.)
  
  public Pile3()
  {
    this(CAPACITE_PAR_DEFAUT);
  } // Pile3()
  
  public void empiler( final Object pO ) throws PilePleineException
  {
	  if(estPleine()) throw new PilePleineException() ;
	  v.add(pO) ;
  } // empiler(.)
  
  public Object depiler() throws PileVideException
  {
	  if(estVide()) throw new PileVideException() ;
	  return v.remove(v.size()-1) ;
  } // depiler()
  
  public Object sommet() throws PileVideException
  {
	  if(estVide()) throw new PileVideException() ;
    return v.lastElement() ;
  } // sommet()
  
  public int taille()
  {
    return v.size() ;
  } // taille()
  
  public int capacite()
  {
    return getCapacite() ;
  } // capacite()
  
  public boolean estVide()
  {
	  return v.isEmpty() ;
  }
    
  
  public boolean estPleine()
  {
    return taille() == getCapacite() ;
  }
  
  @Override public String toString()
  {
	  String str = "]";
		for(Object o : v) 
			str = ", "+o.toString() + str ;
			//str += o.toString()+ ", " ;
		
		//if(!this.estVide()) str = str.substring(0, str.length()-2) ; 
		if(!this.estVide()) str = str.substring(2, str.length()) ; 
	    return "[" + str ;
	  
	  /*
	  	String str = "[";
		for(Object o : v) str += o.toString()+ ", " ;
		if(!this.estVide()) str = str.substring(0, str.length()-2) ;
	    return str + "]";
	    */
  } // toString()
  
  @Override public boolean equals( final Object obj )
  {
	  if(obj == null) return false ;
	  if(!(obj instanceof Pile3)) return false ;
	  Pile3 p = (Pile3) obj ; 
	  
	  if(p.getCapacite() != this.getCapacite()) return false ;
	  if(p.taille() != this.taille()) return false ;
	  
	  for(int i=0 ; i < taille() ; i++) {
		  if(!this.v.get(i).equals(p.v.get(i))) return false ;
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
    Pile3 vP = new Pile3( this.capacite() );
    vP.v = (Vector<Object>)this.v.clone();
    return vP;
  }

public int getCapacite() {
	return capacite;
}

public void setCapacite(int capacite) {
	this.capacite = capacite;
}
}
