package question3;

import java.util.Observable;

import question3.tp_pile.PileI;
import question3.tp_pile.PilePleineException;
import question3.tp_pile.PileVideException;
public class PileModele<T> extends Observable implements PileI<T>
{
  private PileI<T> pile;
  //private List<T> list  ;

  /* a completer */

  public PileModele( PileI<T> pile )
  {
    this.pile= pile;
    //this.list = new ArrayList<T>() ;
  } // PileModele()

  public void empiler( T o ) throws PilePleineException
  {
      pile.empiler(o);
      setChanged();
      notifyObservers(o);
  } // empiler()

  public T depiler() throws PileVideException
  {
      T obj = pile.depiler();
      setChanged();
      notifyObservers(obj);
    return obj ;
  } // depiler()

  public T sommet() throws PileVideException
  {
    return pile.sommet();
  } // sommet()

  public int taille()
  {
    return pile.taille();
  } // taille()

  public int capacite()
  {
    return pile.capacite();
  } // capacite()

  public boolean estVide()
  {
    return pile.estVide();
  } // estVide()

  public boolean estPleine()
  {
    return pile.estPleine();
  } // estPleine()

  public String toString()
  {
    return pile.toString();
  } // toString()
  
} // PileModele

/** notez qu'un message d'alerte subsiste a la compilation (unsafe ...) 
 *  du a l'emploi de notifyObservers, incontournable et sans consequence ici
 */

