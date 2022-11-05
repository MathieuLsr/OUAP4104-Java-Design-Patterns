package question2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import question1.PilePleineException;
import question1.PileVideException;

public class IHMPile extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private PileI p;

    public IHMPile() throws Exception{
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        
        p = new Pile2() ;
        PileI p2 = new Pile2() ;
        
        p.empiler("test");
        p.empiler("abc");
        p.empiler("34");
        
        p2.empiler("test");
        p2.empiler("abc");
        p2.empiler("34");
        
        System.out.println("p : "+p.toString());
        System.out.println("p2 : "+p2.toString());
        System.out.println("Equals ? "+p2.equals(p));
        
        
        /*
        PilesAuMemeComportement test = new PilesAuMemeComportement() ;
        test.setUp();
        test.test_meme_comportement();
        
        
        
        /*
        Pile2 pile2= new Pile2(3) ;
        
        System.out.println(pile2.toString());
        pile2.empiler(4);
        System.out.println(pile2.toString());
        pile2.empiler(6);
        System.out.println(pile2.toString());
        
        
        Pile3Test test3 = new Pile3Test() ;
        
        
        test3.test_Pile3_estVide(); 
        test3.test_Pile3_estPleine();
        try {
			test3.test_Pile3_toString();
			test3.test_Pile3_TailleNegative();
			test3.test_Pile3_equals();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        */
        
        
    }

    /*
     
     There were 13 failures: 
1) test_Pile2_clone(question2): exception inattendue ! question1.PilePleineException 
2) test_Pile2_equals(question2): exception inattendue ! question1.PilePleineException 
3) test_Pile2_estVide(question2) failed
4) test_Pile2_capacite(question2): expected:<6> but was:<0> 
5) test_Pile2_equals_hashCode(question2): exception inattendue ! question1.PilePleineException 
6) test_Pile2_toString(question2): exception inattendue ! java.lang.StringIndexOutOfBoundsException 
7) test_Pile3_estVide(question2) failed
8) test_Pile3_clone(question2): exception inattendue ! question1.PilePleineException 
9) test_Pile3_equals(question2): exception inattendue ! question1.PilePleineException 
10) test_Pile3_equals_hashCode(question2): exception inattendue ! question1.PilePleineException 
11) test_Pile3_capacite(question2): expected:<6> but was:<0> 
12) test_Pile3_toString(question2): exception inattendue ! java.lang.StringIndexOutOfBoundsException 
13) test_meme_comportement_avec_les_exceptions(question2): expected:<...util.EmptyStack...> but was:<...lang.ArrayIndexOutOfBounds...> 
     
     */
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
           String s = donnee.getText();
           try{
               p.empiler(s);
               contenu.setText(p.toString());
            }catch(PilePleineException e){
                contenu.setText("La pile estPleine !");
            }
        }else{
           try{
               sommet.setText(p.depiler().toString());
               contenu.setText(p.toString());
            }catch(PileVideException e){
                contenu.setText( "La pile estVide !");
            }
          
        }
    }

    public static void main(String[] args) throws Exception{
        new IHMPile();
    }
}
