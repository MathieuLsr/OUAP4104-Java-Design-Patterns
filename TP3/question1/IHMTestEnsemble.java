package question1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IHMTestEnsemble extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -6368448780416493189L;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;

    private JPanel panel2;
    private JLabel label2;
    private JTextField textField2;
    private JPanel panel3;

    private JLabel label4;
    private JPanel panel4;
    private JLabel label3;
    private JTextField textField3;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public IHMTestEnsemble() {
        super("IHM TestEnsemble");
        initComponents();
        setLocation(200,200);
        pack();
        setVisible(true);
    }

    private void initComponents() {// GEN-BEGIN:initComponents
        setLayout(new GridLayout(4, 1, 2, 2));

        panel1 = new JPanel();
        panel1.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel1.setBackground(java.awt.Color.lightGray);
        label1 = new JLabel();
        label1.setBackground(java.awt.Color.orange);
        label1.setText("ensemble e1 :");
        panel1.add(label1);
        textField1 = new JTextField();
        textField1.setColumns(52);
        textField1.setName("saisieE1");
        panel1.add(textField1);
        add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel2.setBackground(java.awt.Color.magenta);
        label2 = new JLabel();
        label2.setText("ensemble e2 :");
        panel2.add(label2);
        textField2 = new JTextField();
        textField2.setColumns(52);
        panel2.add(textField2);
        add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel3.setBackground(java.awt.Color.green);
        label4 = new JLabel();
        label4.setText("Op�rations e1 Op e2  :");
        label4.setName("label4");
        panel3.add(label4);

        button1 = new JButton("union");
        button1.setBackground(java.awt.Color.red);
        button1.setName("union");
        button1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                unionActionPerformed(e);
            }
        }  // � compl�ter, par une instance de
                                        // classe anonyme, usage de
                                        // unionActionPerformed voir en bas de
                                        // page
        );

        panel3.add(button1);
        button2 = new JButton("intersection");
        button2.setBackground(java.awt.Color.yellow);
        button2.setName("intersection");
        button2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                intersectionActionPerformed(e);
            }
        }  // � compl�ter, par une instance de
                                        // classe anonyme,
                                        // intersectionActionPerformed voir en
                                        // bas de page
        );

        panel3.add(button2);
        button3 = new JButton("difference");
        button3.setBackground(java.awt.Color.pink);
        button3.setActionCommand("difference");
        button3.setName("difference");
        button3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                differenceActionPerformed(e);
            }
        }  // � compl�ter, par une instance de
                                        // classe anonyme, usage de
                                        // differenceActionPerformed voir en bas
                                        // de page
        );

        panel3.add(button3);
        button4 = new JButton("diffSymetrique");
        button4.setBackground(java.awt.Color.cyan);
        button4.setName("diffSymetrique");
        button4.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                diffSymetriqueActionPerformed(e);
            }
        }  // � compl�ter, par une instance de
                                        // classe anonyme, usgae de
                                        // diffSymetriqueActionPerformed voir en
                                        // bas de page
        );

        panel3.add(button4);
        add(panel3);

        panel4 = new JPanel();
        panel4.setLayout(new java.awt.FlowLayout(0, 5, 5));
        label3 = new JLabel();
        label3.setText("R�sultat");
        label3.setName("R�sultat");

        panel4.add(label3);

        textField3 = new JTextField();
        textField3.setColumns(60);

        panel4.add(textField3);
        panel4.setBackground(java.awt.Color.orange);

        add(panel4);
        
        EnsembleTest test = new EnsembleTest() ;
        test.testAdd();
        test.testUnion();
        test.testDiff();
        test.testDiffSym();
        test.testInter();
        
        
        
    }// GEN-END:initComponents

    private Ensemble<String> getSet(JTextField saisie) {
        Ensemble<String> e = new Ensemble<String>();
        java.util.StringTokenizer st = new java.util.StringTokenizer(
                saisie.getText(), " ,.:/-;");
        while (st.hasMoreTokens()) {
            e.add(st.nextToken());
        }
        return e;
    }

    // ne pas modifier ces lignes
    private void differenceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_differenceActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.diff(e2).toString());
    }// GEN-LAST:event_differenceActionPerformed

    private void intersectionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_intersectionActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText((e1.inter(e2)).toString());
    }// GEN-LAST:event_intersectionActionPerformed

    private void unionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_unionActionPerformed
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.union(e2).toString());
    }// GEN-LAST:event_unionActionPerformed

    private void diffSymetriqueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_button4ActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.diffSym(e2).toString());
    }// GEN-LAST:event_button4ActionPerformed
    
    public static void main(String[] args){
        new IHMTestEnsemble();
    }
}

/*
 
 
 There were 14 failures: 
1) test_IHMTestEnsemble_diff_bis(question1): [2 3] diff [4 5 6 7] # [2 3] ??, obtenu:([]) 
2) test_IHMTestEnsemble_diffSym(question1): [2 3 4 5] diffSym [4 5 6 7] # [2 3 6 7] ??, obtenu:([]) 
3) test_IHMTestEnsemble_inter_ter(question1): [2 3 4 5] inter [2 3 4 5] # [2 3 4 5] ??, obtenu:([]) 
4) test_IHMTestEnsemble_union(question1): [2 3 4 5] union [4 5 6 7] # [2 3 4 5 6 7] ??, obtenu:([]) 
5) test_IHMTestEnsemble_union_bis(question1): [2 3] union [4 5 6 7] # [2 3 4 5 6 7] ??, obtenu:([]) 
6) test_IHMTestEnsemble_inter(question1): [2 3 4 5] inter [4 5 6 7] # [4 5] ??, obtenu:([]) 
7) test_IHMTestEnsemble_union_ter(question1): [2] union [2] # [2] ??, obtenu:([]) 
8) test_IHMTestEnsemble_diff(question1): [2 3 4 5] diff [4 5 6 7] # [2 3] ??, obtenu:([]) 
9) test_IHMTestEnsemble_diffSym_bis(question1): [2 3] diffSym [6 7] # [2 3 6 7] ??, obtenu:([]) 
10) test_appel_de_methodes(question1): EnsembleTest: Aucun appel de la méthode inter ??? 
11) test_contains_dans_add(question1): L'appel à this.contains est préféré à table.contains (pourquoi ?)...
12) test_appels_dans_diff(question1): Un seul appel à la méthode removeAll est requis ??? 
13) test_appels_dans_union(question1): Deux appels à la méthode addAll sont requis ??? 
14) test_appel_union_diff_inter_dans_diffSym(question1): Un seul appel à la méthode diff est requis ???
 
 There were 16 failures: 
1) test_Ensemble_Unicité(question1): add, lorsque l''élément est déjà présent ??? 
2) test_IHMTestEnsemble_inter_ter(question1): [2 3 4 5] inter [2 3 4 5] # [2 3 4 5] ??, obtenu:([]) 
3) test_IHMTestEnsemble_union_ter(question1): [2] union [2] # [2] ??, obtenu:([]) 
4) test_IHMTestEnsemble_diffSym_bis(question1): [2 3] diffSym [6 7] # [2 3 6 7] ??, obtenu:([]) 
5) test_IHMTestEnsemble_inter(question1): [2 3 4 5] inter [4 5 6 7] # [4 5] ??, obtenu:([]) 
6) test_IHMTestEnsemble_diff(question1): [2 3 4 5] diff [4 5 6 7] # [2 3] ??, obtenu:([]) 
7) test_IHMTestEnsemble_union_bis(question1): [2 3] union [4 5 6 7] # [2 3 4 5 6 7] ??, obtenu:([]) 
8) test_IHMTestEnsemble_diff_bis(question1): [2 3] diff [4 5 6 7] # [2 3] ??, obtenu:([]) 
9) test_IHMTestEnsemble_union(question1): [2 3 4 5] union [4 5 6 7] # [2 3 4 5 6 7] ??, obtenu:([]) 
10) test_IHMTestEnsemble_diffSym(question1): [2 3 4 5] diffSym [4 5 6 7] # [2 3 6 7] ??, obtenu:([]) 
11) test_appel_de_methodes(question1): EnsembleTest: Aucun appel de la méthode union ??? 
12) test_appel_union_diff_inter_dans_diffSym(question1): Un seul appel à la méthode diff est requis ??? 
13) test_appels_dans_union(question1): Deux appels à la méthode addAll sont requis ??? 
14) test_appels_dans_inter(question1): Un seul appel à la méthode retainAll est requis ??? 
15) test_contains_dans_add(question1): L''appel à this.contains est préféré... 
16) test_appels_dans_diff(question1): Un seul appel à la méthode removeAll est requis ??? 

*/