package question4;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.SoldeDebiteurException;
import question2.CompositeValide;
import question2.DebitMaximal;
import question2.Main;

public class IHM extends JFrame
{
    private JTextArea  aTResultat = new JTextArea( "", 7, 60 );
    private JButton    aBDebiter  = new JButton( "d�biter"   );
    private JButton    aBCrediter = new JButton( "cr�diter"  );
    private JTextField aTSomme    = new JTextField( 4 );

    private GroupeDeContributeurs g; // ne pas modifier cette ligne, 
                                     // les tests JNEWS utilisent cet identifiant (g)

    public IHM()
    {
        this.setTitle( "Cotisant" );
        Container vContainer = this.getContentPane();
        this.aTSomme.setText( "40" );
        vContainer.setLayout( new BorderLayout() );

        vContainer.add( aTResultat, BorderLayout.NORTH );
        JPanel vP = new JPanel( new FlowLayout() );
        vP.add( this.aTSomme );
        vP.add( this.aBDebiter  );
        vP.add( this.aBCrediter );
        vContainer.add( vP, BorderLayout.SOUTH );

        this.g = new GroupeDeContributeurs( "g" );
        this.g.ajouter( new Contributeur( "g_a", 100 ) );
        this.g.ajouter( new Contributeur( "g_b",  50 ) );
        this.g.ajouter( new Contributeur( "g_c", 150 ) );
        GroupeDeContributeurs vG1 = new GroupeDeContributeurs( "g1" );
        vG1.ajouter( new Contributeur( "g1_a1",  70 ) );
        vG1.ajouter( new Contributeur( "g1_b1", 200 ) );
        this.g.ajouter( vG1 );

        try {
            this.aTResultat.setText( Main.arbreXML( this.g ) ); //actualiser();
        } catch( final Exception pE ) {
            // System.err.println( pE );
        }

        this.aBDebiter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int solde = Integer.parseInt(aTSomme.getText()) ;
				
				if (g.accepter( new CompositeValide() )) {
			          //System.out.println(Main.arbreXML(g));
			          if (g.accepter( new DebitMaximal() ) >= solde) {
			              try {
							g.debit(solde);
							aTResultat.setText( Main.arbreXML(g) );
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			          }
			      } else {
			          //System.out.println("Composite invalide"); 
			      }
				
				
			}
		});
        this.aBCrediter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int solde = Integer.parseInt(aTSomme.getText()) ;
				
				if (g.accepter( new CompositeValide() )) {
			          try {
							g.credit(solde);
							aTResultat.setText( Main.arbreXML(g) );
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				}
				
			}
		});

        this.pack();
        this.setVisible( true );
    } // IHM()
    
    public static void main(String[] args) {
		IHM.main();
	}

    public static void main() // ce n'est pas la veritable methode main !
    {
        new IHM();    
    } // main()
} // IHM
