package question2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelListe extends JPanel implements ActionListener, ItemListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1909446806458612113L;
	private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("décroissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    public JPanelListe(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incompl�te");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonRetirer.addActionListener(this);
        
        ordreCroissant.addItemListener(this);;
		ordreDecroissant.addItemListener(this);
		
        boutonOccurrences.addActionListener(this);

    }

    /** ne pas modifier les affichages, les classes de tests en ont besoin ... */
    public void actionPerformed(ActionEvent ae) {
        try {
            boolean res = false;
            
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                res = liste.contains(saisie.getText());
                afficheur.setText("r�sultat de la recherche de : "+ saisie.getText() + " -->  " + res);
                
            } else if (ae.getSource() == boutonRetirer) {
                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur.setText("r�sultat du retrait de tous les �l�ments commen�ant par -->  "+ saisie.getText() + " : " + res);
                
                
                
            } else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            }
            
            texte.setText(liste.toString());

        } catch (Exception e) {
            afficheur.setText(e.toString());
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == ordreCroissant) {
        	Collections.sort(liste);
        	afficheur.setText(" -->  Tri par ordre croissant");
        }
        else if (ie.getSource() == ordreDecroissant) {
        	Collections.sort(liste, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1) ;
				}
			});
        	//Collections.reverse(liste);
        	afficheur.setText(" -->  Tri par ordre décroissant");
        }

        texte.setText(liste.toString());
    }

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean resultat = false;
        
        List<String> list = new ArrayList<String>(liste) ;
        for(String str : list) {
        	if(str.startsWith(prefixe)) {
        		resultat = liste.remove(str) ;
        		occurrences.replace(str, 0) ;
        	}
        }
        
        
        return resultat;
    }

}