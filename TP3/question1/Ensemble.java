package question1;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Vector;

public class Ensemble<T> extends AbstractSet<T>
{
  private Vector<T> aTable; 

  public Ensemble() { this.aTable = new Vector<T>(); }
  
  @Override public int size() { return this.aTable.size(); }

  @Override public Iterator<T> iterator() { return this.aTable.iterator(); }

  @Override public boolean add( final T t )
  {  
	  if(this.contains(t)) return false ;
	  return aTable.add(t) ;
  } // add()
  
  public Ensemble<T> union( final Ensemble<? extends T> e )
  { 
    // a completer pour la question1-2
	  
	  Ensemble<T> ens = new Ensemble<T>() ;
	  ens.addAll(aTable) ;
	  ens.addAll(e) ;
	  
	  return ens ;
  } // union()
  
  public Ensemble<T> inter( final Ensemble<? extends T> e )
  {
    // a completer pour la question1-2
    
	  Ensemble<T> ens = new Ensemble<T>() ;
	  
	  ens.addAll(aTable) ;
	  //ens.removeIf(i -> !e.aTable.contains(i)) ;
	  ens.retainAll(e.aTable) ;
	  
    return ens ;
  } // inter()
  
  public Ensemble<T> diff( final Ensemble<? extends T> e )
  {
    // a completer pour la question1-2
	  
	  Ensemble<T> ens = new Ensemble<T>() ;
	  ens.addAll(aTable) ;
	  ens.removeAll(e) ;
	  //ens.removeIf(i -> e.aTable.contains(i)) ;
    return ens ;
  } // diff()
  
  Ensemble<T> diffSym( final Ensemble<? extends T> e )
  {
	  return this.union(e).diff(this.inter(e));
  } // diffSym()
} // Ensemble
