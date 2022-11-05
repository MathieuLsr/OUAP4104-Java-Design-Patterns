package question2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHMQuestion2_2 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_2() {
        super("IHM Question2_2");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        setLocation(150,150);pack();
        super.setVisible(true);
        enHaut.setBackground(Color.magenta);
        

        JMouseObserver jm1 = new JMouseObserver("jm1", contenu) ;
        JMouseObserver jm2 = new JMouseObserver("jm2", contenu) ;
        JMouseObserver jm3 = new JMouseObserver("jm3", contenu) ;
        
        JButtonObserver jbo1 = new JButtonObserver("jbo1", contenu) ;
        JButtonObserver jbo2 = new JButtonObserver("jbo2", contenu) ;
        JButtonObserver jbo3 = new JButtonObserver("jbo3", contenu) ;
        
        boutonA.addActionListener(jbo1);
        boutonA.addActionListener(jbo2);
        boutonA.addActionListener(jbo3);
        
        boutonB.addActionListener(jbo1);
        boutonB.addActionListener(jbo2);
        
        boutonC.addActionListener(jbo1);
        
        boutonA.addMouseListener(jm1);
        boutonB.addMouseListener(jm2);
        boutonC.addMouseListener(jm3);
        

        // � compl�ter � l'identique de la question 2_1, (du copier/coller)...
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

        // le bouton B a 2 observateurs jbo1 et jbo2

        // le bouton C a 1 observateur jbo1

        // � compl�ter pour la question 2_2 (JMouseObserver)
            // le bouton A a 1 observateur jmo1
            // le bouton B a 1 observateur jmo2
            // le bouton C a 1 observateur jmo3
        
    }
    /*
     
     There were 8 failures: 
1) test_clic_bouton_C(question2): avec JButtonObserver (et testSouris==false) 1 seule ligne est attendue ! 
2) test_clic_bouton_B(question2): 2 lignes sont attendues !! 
3) test_clic_bouton_A(question2): 3 lignes sont attendues !!! 
4) test_clic_bouton_C(question2): 2 lignes sont attendues !( le déplacement+1 clicks) 
5) test_clic_bouton_B(question2): 3 lignes sont attendues !!( le déplacement+2 clicks) 
6) test_clic_bouton_A(question2): 4 lignes sont attendues !!!( le déplacement+3 clicks) 
7) test_deplacement_souris_vers_A(question2): avec JMouseObserver pour ce test 1 ligne est attendue ! 
8) test_deplacement_souris_vers_B(question2): avec JMouseObserver pour ce test 1 ligne est attendue ! 
     
     */
    
     public static void main(String[] args){
        new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}
