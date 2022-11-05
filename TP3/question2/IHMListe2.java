package question2;


import javax.swing.*;
import java.util.*;

public class IHMListe2 extends JFrame {
    public IHMListe2() {
        List<String> liste = Chapitre2CoreJava2.listeDesMots();
        Map<String, Integer> table = Chapitre2CoreJava2.occurrencesDesMots(liste);
        JPanelListe2 jPanelListe = new JPanelListe2(liste, table);
        add(jPanelListe);
        setLocation(120,150);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new IHMListe2();
    }
    
    /*
     
     There were 3 failures: 
1) test_IHMListe_retirer_et_occurrence(question2): L''affichage du nombre d''occurrence doit être de 0 après un retrait effectif 
2) test_IHMListe_retirer_et_occurrence_bis(question2): L''affichage du nombre d''occurrence doit être de 0 après un retrait effectif 
3) test_IHMListe_tri_décroissant(question2): tri en ordre décroissant ?? 


     
     */

}
