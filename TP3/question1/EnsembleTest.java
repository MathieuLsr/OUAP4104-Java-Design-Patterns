package question1;

public class EnsembleTest extends junit.framework.TestCase
{
    // Definissez ici les variables d'instance necessaires a vos engagements;
    // Vous pouvez egalement les saisir automatiquement du presentoir
    // a l'aide du menu contextuel "Presentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du presentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Il ne vous reste plus qu'a definir une ou plusieurs methodes de test.
     * Ces methodes doivent verifier les resultats attendus a l'aide d'assertions
     * assertTrue(<boolean>).
     * Par convention, leurs noms devraient debuter par "test".
     * Vous pouvez ebaucher le corps gr�ce au menu contextuel "Enregistrer une methode de test".
     */

	public void testAdd()
	{
		Ensemble<Integer> ens1 = new Ensemble<Integer>() ;
        
        ens1.add(5) ;
        ens1.add(5) ;
        ens1.add(13) ;
        
        assertEquals(ens1.size(), 2);
        assertTrue(ens1.contains(5));
        assertTrue(ens1.contains(13));
	}
	   
	public void testUnion()
	{
	   //fail( "testUnion() non ecrite !" ); // ligne a commenter quand la fonction sera ecrite
//  A titre d'exemple :
	    question1.Ensemble<Integer> e1,e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));  assertEquals(true, e1.add(3));
		
		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));  assertEquals(true, e2.add(4));
	 
		question1.Ensemble<Integer> union = e1.union(e2);
		assertEquals(3, union.size());
		assertTrue(union.contains(2));
		assertTrue(union.contains(3));
		assertTrue(union.contains(4));
	}
	
	public void testInter()
	{
	    //fail( "testInter() non ecrite !" ); // ligne a commenter quand la fonction sera ecrite
		


        Ensemble<Integer> ens1 = new Ensemble<Integer>() ;
        Ensemble<Integer> ens2 = new Ensemble<Integer>() ;
        
        ens1.add(5) ;
        ens1.add(12) ;
        ens2.add(5) ;
        
        Ensemble<Integer> inter = ens1.inter(ens2) ;
        assertEquals(inter.size(), 1);
        assertTrue(inter.contains(5));
        
	}
	
	public void testDiff()
	{
		
		Ensemble<Integer> ens1 = new Ensemble<Integer>() ;
        Ensemble<Integer> ens2 = new Ensemble<Integer>() ;
        
        ens1.add(5) ;
        ens1.add(2) ;
        ens2.add(5) ;
        
        Ensemble<Integer> diff = ens1.diff(ens2) ;
        assertEquals(diff.size(), 1);
        assertTrue(diff.contains(2));
		
	    //fail( "testDiff() non ecrite !" ); // ligne a commenter quand la fonction sera ecrite
	}
	
	public void testDiffSym()
	{
		Ensemble<Integer> ens1 = new Ensemble<Integer>() ;
        Ensemble<Integer> ens2 = new Ensemble<Integer>() ;
        
        ens1.add(5) ;
        ens2.add(5) ;
        
        ens1.add(1) ;
        ens1.add(2) ;
        ens2.add(3) ;
        
        Ensemble<Integer> diff = ens1.diffSym(ens2) ;
        //System.out.println(diff);
        assertEquals(diff.size(), 3);
        assertTrue(diff.contains(1));
        assertTrue(diff.contains(2));
        assertTrue(diff.contains(3));
		
	    //fail( "testDiffSym() non ecrite !" ); // ligne a commenter quand la fonction sera ecrite
	}
 
    /**
     * Met en place les engagements.
     *
     * Methode appelee avant chaque appel de methode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
    	
    }

    /**
     * Supprime les engagements
     *
     * Methode appelee apr�s chaque appel de methode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        //Liberez ici les ressources engagees par setUp()
    }

} // EnsembleTest
