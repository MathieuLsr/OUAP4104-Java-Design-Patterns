package question3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**  
 * Decrivez votre classe Controleur ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class Vue extends JPanel implements Observer
{// � completer 
  /**
     * 
     */
    private static final long serialVersionUID = -6763441239443191271L;
private JLabel etatPile;
  private PileModele<Integer> pile;

  public Vue( PileModele<Integer> pile )
  {
    super();
    this.pile= pile;
    this.etatPile= new JLabel( "entrez des nombres entiers" );
    setLayout( new FlowLayout( FlowLayout.LEFT ) );
    add( etatPile );
    setBackground( Color.green );
    // inscription aupres du modele comme observateur
    pile.addObserver(this);
  } // Vue()

    @Override
    public void update( Observable obs, Object arg ) {
        etatPile.setText( pile.toString() ); // ou obs.toString()
    } // update()


} // Vue
