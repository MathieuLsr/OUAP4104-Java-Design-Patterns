package question3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import question3.tp_pile.PilePleineException;
import question3.tp_pile.PileVideException;

/** 
 * Decrivez votre classe Controleur ici.
 *  
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class Controleur extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -5333346137265077064L;
	private JButton push, add, sub, mul, div, clear;
  private PileModele<Integer> pile;
  private JTextField donnee;
  private List<JButton> listButtons ;

  public Controleur( PileModele<Integer> pile )
  {
    super();
    this.setPile(pile);
    this.donnee= new JTextField( 8 );

    this.push= new JButton( "push" );
    this.add= new JButton( "+" );
    this.sub= new JButton( "-" );
    this.mul= new JButton( "*" );
    this.div= new JButton( "/" );
    this.clear= new JButton( "[]" );
    this.listButtons = Arrays.asList(add, sub, mul, div) ;

    setLayout( new GridLayout( 2, 1 ) );
    add( donnee );
    donnee.addActionListener( null /* null est a remplacer */);
    JPanel boutons= new JPanel();
    boutons.setLayout( new FlowLayout() );
    boutons.add( push );
    setButtonsEnabled(false);
    
    for(JButton b : listButtons) {
    	b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateButtonsEnabled();
			}
		});
    }
    
    push.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Integer i = operande() ;
				if(i == null) return ;
				pile.empiler(i);
				donnee.setText("");
				updateButtonsEnabled();
			} catch (NumberFormatException | PilePleineException e1) {
				e1.printStackTrace();
			}
		}
	});
    
    
    boutons.add( add );
    add.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(pile.taille() < 2) return ;
				int i = pile.depiler() + pile.depiler() ;
				//while(!pile.estVide()) i += pile.depiler() ;
				pile.empiler(i);
			} catch (PileVideException | PilePleineException e1) {
				e1.printStackTrace();
			}
		}
	});
    boutons.add( sub );
    sub.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(pile.taille() < 2) return ;
				int i1 = pile.depiler() ;
				int i2 = pile.depiler() ;
				/*
				for ( int k= pile.taille() - 1; k >= 0; k-- ) {
				      if ( k == 0 ) i = pile.depiler() - i ;
				      else i += pile.depiler() ;
				}
				*/
				pile.empiler(i2 - i1);
			} catch (PilePleineException | PileVideException e1) {
				e1.printStackTrace();
			}
		}
	});
    
    boutons.add( mul );
    mul.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(pile.taille() < 2) return ;
				int i = pile.depiler() * pile.depiler();
				//while(!pile.estVide()) i *= pile.depiler() ;
				pile.empiler(i);
			} catch (PilePleineException | PileVideException e1) {
				e1.printStackTrace();
			}
		}
	});
    boutons.add( div );
    div.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(pile.taille() < 2) return ;
				
				int i1 = pile.depiler() ;
				int i2 = pile.depiler() ;
				
				if(i1 == 0) {
					pile.empiler(i2);
					pile.empiler(i1);
					return ;
				}
				
				pile.empiler(i2/i1);
				
				/*
				int i = 0 ;
				List<Integer> list = new LinkedList<Integer>() ;
				
				for ( int k= pile.taille() - 1; k >= 0; k-- ) {
				    int depile = pile.depiler()  ;  
					list.add(depile) ;
				    if ( k == 0 ) {
				    	  if(i == 0) {				    		  
				    		  for(int j=list.size()-1 ; j>= 0 ; j--)
				    			  pile.empiler(list.get(j));

				    		  return ;
				    	  }
				    	  i = depile / i ;
				     }
				     else i += depile ;
				}
				pile.empiler(i);
				/*
				if(pile.estVide()) return ;
				int i = pile.depiler() ;
				while(!pile.estVide()) {
					int diviseur = pile.depiler() ;
					if(diviseur == 0) continue ;
					i /= diviseur ;
				}
				pile.empiler(i);
				*/
			} catch (PilePleineException | PileVideException e1) {
				e1.printStackTrace();
			}
		}
	});
    
    boutons.add( clear );
    clear.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			while(!pile.estVide())
				try {
					pile.depiler() ;
				} catch (PileVideException e1) {
					e1.printStackTrace();
				}
			updateButtonsEnabled();
			
		}
	});
    add( boutons );
    boutons.setBackground( Color.red );
    actualiserInterface();
  } // Controleur()

  protected void updateButtonsEnabled() {
	  	if(pile.taille() < 2) setButtonsEnabled(false) ;
		else setButtonsEnabled(true);
  }
  
  protected void setButtonsEnabled(boolean b) {
	  for(JButton button : listButtons)
		  button.setEnabled(b);
}

public void actualiserInterface()
  {
    // a completer
  } // actualiserInterface()

  private Integer operande() throws NumberFormatException
  {
	  try {
		  return Integer.parseInt( donnee.getText() );
	  } catch(NumberFormatException e){
	  }
	  return null ;
    
  } // operande()

public PileModele<Integer> getPile() {
	return pile;
}

public void setPile(PileModele<Integer> pile) {
	this.pile = pile;
}

  // a completer
  // en cas d'exception comme division par zero, mauvais format de nombre
  // la pile doit rester en l'etat (intacte)

} // Controleur
