package question3;

import question1.*;

public class GardienTest extends junit.framework.TestCase{

    public void testGardien(){
        Cotisant c = new Contributeur("c",300);
        Gardien gardien = new Gardien();
        gardien.setMemento(new Memento(c));
        Cotisant c1 = new Contributeur("c1",200);
        gardien.setMemento(new Memento(c1));
        try{
            c.debit(100);
            c1.debit(100);
            gardien.getMemento().setState(c1);
            assertEquals("Gardien, getMemento en échec...", 200,c1.solde());
            gardien.getMemento().setState(c);
            assertEquals("Gardien, getMemento en échec...", 300,c.solde());
        }catch(Exception e){
            fail("debit simple d'un contributeur : une exception " + e.getMessage() + " ???");
        }
    }

  

}