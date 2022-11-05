package question3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import question2.ActionListnerButton;
import question3.tp_pile.Pile2;

public class IHMCalculette extends JFrame {
    /** 
     *  
     */
    private static final long serialVersionUID = 1L;

    public IHMCalculette() {
        super("IHM Calculette");
        PileModele<Integer> modele = new PileModele<Integer>(new Pile2<Integer>(5));
        Controleur controle = new Controleur(modele);
        Vue vue = new Vue(modele);

        setLayout(new GridLayout(2, 1));
        add(vue);
        add(controle);
        pack();
        setLocation(200,200);
        setVisible(true);
        
        ActionListener z = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		};
		
		JButton button = new JButton() ;
		
		button.addActionListener(z);
		
		ActionListnerButton a = new ActionListnerButton("jbo1") ;
		ActionListnerButton b = new ActionListnerButton("B") ;
		ActionListnerButton c = new ActionListnerButton("C") ;
		
		button.addActionListener(a);

    }

    public static void main(String[] args){
        new IHMCalculette();
    }
}
