package question3;



import question1.*;

public class MementoTest extends junit.framework.TestCase{

    public void testMementoUnSeulContributeur(){
        Cotisant c = new Contributeur("c",300);
        Memento memento1 = new Memento(c);
        try{
            c.debit(100);
        }catch(Exception e){
            fail("debit simple d'un contributeur : une exception ???");
        }
        assertEquals("Memento, constructeur en échec ???", 200, c.solde());
        Memento memento2 = new Memento(c);
        memento1.setState(c);
        assertEquals("Memento, setState en échec ???", 300, c.solde());
        memento2.setState(c);
        try{
            c.debit(100);
        }catch(Exception e){
            fail("debit simple d'un contributeur : une exception ???");
        } 
        assertEquals("Memento", 100, c.solde());

    }

    public void testMementoUnGroupeDeDeuxGroupesAvecUnContributeurChacun(){
        Cotisant c1 = new Contributeur("c1",300);
        Cotisant c2 = new Contributeur("c2",200);
        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
        g1.ajouter(c1); g2.ajouter(c2);
        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        g.ajouter(g1); g.ajouter(g2);

        assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 500, g.solde());
        Memento memento1 = new Memento(g);
        assertEquals("Memento, constructeur en échec ???", 500, g.solde());
        try{
            g.debit(100);
            assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 300, g.solde());
        }catch(Exception e){
            fail("debit simple d'un goupe de deux contributeurs : une exception ???");
        }
        Memento memento2 = new Memento(g);
        memento1.setState(g);
        assertEquals("Memento, setState en échec ???", 500, g.solde());
        memento2.setState(g);
        assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 300, g.solde());
    }

    public void testMementoUnGroupeDeDeuxContributeurs(){
        Cotisant c1 = new Contributeur("c1",300);
        Cotisant c2 = new Contributeur("c2",200);
        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        g.ajouter(c1); g.ajouter(c2);
        assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 500, g.solde());
        Memento memento1 = new Memento(g);
        assertEquals("Memento, constructeur en échec ???", 500, g.solde());
        try{
            g.debit(100);
            assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 300, g.solde());
        }catch(Exception e){
            fail("debit simple d'un goupe de deux contributeurs : une exception ???");
        }
        Memento memento2 = new Memento(g);
        memento1.setState(g);
        assertEquals("Memento, setState en échec ???", 500, g.solde());
        memento2.setState(g);
        assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 300, g.solde());
    }

    public void testMementoUnGroupeDeTroisGroupesUnContributeur(){
        Cotisant c1 = new Contributeur("c1",300);
        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
        g.ajouter(g1);g1.ajouter(g2); g2.ajouter(c1); 
        assertEquals("Solde en échec ???", 300, g.solde());
        Memento memento1 = new Memento(g);
        assertEquals("Memento, constructeur en échec ???", 300, g.solde());
        try{
            g.debit(100);
            assertEquals("Solde en échec ???", 200, g.solde());
        }catch(Exception e){
            fail("debit simple d'un goupe : une exception ???");
        }
        Memento memento2 = new Memento(g);
        memento1.setState(g);
        assertEquals("Memento, setState en échec ???", 300, g.solde());
        memento2.setState(g);
        assertEquals("Solde d'un groupe de deux contributeurs en échec ???", 200, g.solde());
    }

    public void testMementoUnGroupeDeTroisGroupesTroisContributeurs(){

        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
        Cotisant c1 = new Contributeur("c1",300);
        Cotisant c2 = new Contributeur("c2",100);
        Cotisant c3 = new Contributeur("c3",200);
        g.ajouter(g1);g1.ajouter(g2); g2.ajouter(c1); g1.ajouter(c2); g.ajouter(c3); 
        assertEquals("Solde en échec ???", 600, g.solde());
        Memento memento1 = new Memento(g);
        assertEquals("Memento, constructeur en échec ???", 600, g.solde());
        try{
            g.debit(100);
            assertEquals("Solde en échec ???", 300, g.solde());
        }catch(Exception e){
            fail("debit simple d'un goupe : une exception ???");
        }
        Memento memento2 = new Memento(g);
        memento1.setState(g);
        assertEquals("Memento, setState en échec ???", 600, g.solde());
        memento2.setState(g);
        assertEquals("Memento, setState en échec ???", 300, g.solde());
    }

}
