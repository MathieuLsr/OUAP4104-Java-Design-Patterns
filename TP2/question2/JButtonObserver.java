package question2;

//import java.awt.event. // a completer
//import java.awt.event. // a completer
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Decrivez votre classe JButtonObserver ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class JButtonObserver implements ActionListener 
{ // a completer
  private String nom;
  private TextArea contenu;

  /**
   * Constructeur d'objets de classe JButtonObserver
   */
  public JButtonObserver( String nom, TextArea contenu )
  {
    this.nom= nom;
    this.contenu= contenu;
  } // JButtonObserver()

  /** affichage d'un message dans la zone de texte
   * ce message est de la forme observateur this.nom : clic du bouton nom_du_bouton
   * exemple : observateur jbo1 : clic du bouton A
   * @param ???
   */
      public void actionClick(String nameButton)
      { // a completer
        String message= "observateur "+nom+" : clic du bouton "+nameButton;
        //System.out.println("."+contenu.getText()+".") ;
        //System.out.println(contenu.getText().equalsIgnoreCase("")) ;
        if(!contenu.getText().equalsIgnoreCase("")) contenu.append("\n"); 
        contenu.append(message);
      } // actionXXXXXXX()

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(!(e.getSource() instanceof JButton)) return ;
        String name = e.getActionCommand();
        actionClick(name);
        
    }
  
} // JButtonObserver
