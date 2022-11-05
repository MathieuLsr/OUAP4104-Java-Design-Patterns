package question2;

import java.awt.TextArea;
//import java.awt.event.// a completer
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Decrivez votre classe JMouseObserver ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class JMouseObserver implements MouseListener
{
  private String nom;
  private TextArea contenu;

  /**
   * Constructeur d'objets de classe JButtonObserver
   */
  public JMouseObserver( String nom, TextArea contenu )
  {
    this.nom= nom;
    this.contenu= contenu;
  } // JMouseObserver(()

  public void mouseClicked( MouseEvent e )
  {
      
  }

  /** affichage d'un message dans la zone de texte
   * ce message est de la forme observateur this.nom : souris entree en (X,Y)
   * exemple : observateur jmo1 : souris entree en (15,20)
   * @param MouseEvent 
   */
  public void mouseEntered( MouseEvent e )
  { // a completer
    if(!(e.getComponent() instanceof JButton)) return ;
    String message= "observateur "+nom+" : souris entrée en ("+e.getX()+","+e.getY()+")\n" ;
    //if(!contenu.getText().equalsIgnoreCase("")) contenu.append("\n"); 
    contenu.append(message);
  } // mouseEntered()

  public void mouseExited( MouseEvent e )
  {
  }

  public void mousePressed( MouseEvent e )
  {
  }

  public void mouseReleased( MouseEvent e )
  {
  }

} // JMouseObserver
