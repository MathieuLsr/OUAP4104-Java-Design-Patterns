package question2;

import question1.Contributeur;
import question1.GroupeDeContributeurs;

public class TestsDesVisiteurs extends junit.framework.TestCase
{

  public void testACompleter() throws Exception
  {
	  
	  GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      g.ajouter(new Contributeur("g_a",100));
      g.ajouter(new Contributeur("g_b",200));
      g.ajouter(new Contributeur("g_c",300));
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      
      //assertTrue(g1.accepter(new DebitMaximal()) == 0);
      //assertTrue(g1.accepter(new DebitMaximal()) == 0);
      //assertTrue(g1.accepter(new DebitMaximal()) == 0);
      
      assertTrue(g.accepter(new CompositeValide())) ;
      assertTrue(g.accepter(new CompositeValide())) ;
      assertTrue(g.accepter(new CompositeValide())) ;
      
      assertTrue(g.accepter(new CompositeValide(50))) ;
      assertTrue(g.accepter(new CompositeValide(100))) ;
      assertFalse(g.accepter(new CompositeValide(200))) ;
      
      g1.ajouter(new Contributeur("g1_a1",100));
      g1.ajouter(new Contributeur("g1_b1",200));
      g.ajouter(g1);
	
      assertFalse(g.accepter( new DebitMaximal() ) >= 150);
      assertTrue(g.accepter( new DebitMaximal() ) >= 50);
      assertFalse(g.accepter( new DebitMaximal() ) >= 150);
      assertTrue(g.accepter( new DebitMaximal() ) >= 50);
      assertFalse(g.accepter( new DebitMaximal() ) >= 150);
      assertTrue(g.accepter( new DebitMaximal() ) >= 50);
      
	  if (g.accepter( new CompositeValide() )) {
          //System.out.println(Main.arbreXML(g));
          if (g.accepter( new DebitMaximal() ) >= 150) {
              g.debit(150);
              //System.out.println(Main.arbreXML(g));
          }
      } else {
          //System.out.println("Composite invalide"); 
      }
    
	  
	  GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2") ;
	  Contributeur p1 = new Contributeur("p1", 100) ;
	  g2.ajouter(p1);
	  
	  assertTrue(g2.accepter(new CompositeValide()));
	  
	  GroupeDeContributeurs g3 = new GroupeDeContributeurs("g3") ;
	  g3.ajouter(p1);
	  g2.ajouter(g3);
	  assertFalse(g2.accepter(new CompositeValide()));
	  
	  
	  
	  GroupeDeContributeurs g4 = new GroupeDeContributeurs("g4") ;
	  GroupeDeContributeurs g5 = new GroupeDeContributeurs("g5") ;
	  g4.ajouter(new Contributeur("p5", 2400)) ;
	  g4.ajouter(g5);
	  g5.ajouter(new Contributeur("p5", 2400));
	  //System.out.println(g4.accepter(new DebitMaximal()));
	  assertFalse(g4.accepter(new CompositeValide()));
	  
	  GroupeDeContributeurs g6 = new GroupeDeContributeurs("g6") ;
	  GroupeDeContributeurs g7 = new GroupeDeContributeurs("g7") ;
	  
	  g7.ajouter(new Contributeur("p353", 0));
	  g6.ajouter(g7);
	  g7.ajouter(g6);
	  
	  assertFalse(g6.accepter(new SansDoublon()));
	  assertFalse(g6.accepter(new CompositeValide()));
	  
	  
  }	
  


/*
 
 https://charon.lan.esiee.fr:8003
 
	There were 5 failures: 
1) testLeMemeContributeurPresentDeuxFois(question2): Ce composite est valide, revoyez CompositeValide !!! 
2) testSurUnGroupeDeGroupeAvecDoublons(question2): Revoyez DébitMaximal !!! expected:<90> but was:<0> 
3) testUnGroupeDeContributeursAvecUnDoublon(question2): Revoyez DébitMaximal !!! expected:<80> but was:<0> 
4) testLeMemeContributeurPresentTroisFoisAvecDesGroupesDeGroupes(question2): Ce composite est valide, revoyez CompositeValide !!!
5) testUnGroupeDeGroupeAvecUnDoublon(question2): Revoyez DébitMaximal !!! expected:<20> but was:<0> 


  Résultat : 12 échec(s) au(x) 50 test(s)1 référents

There were 12 failures: 
1) testUnContributeurUnGroupeAvecLeMemeNom(question2): Ce composite est valide, revoyez CompositeValide !!! 
2) testLeMemeContributeurPresentDeuxFois(question2): Ce composite est valide, revoyez CompositeValide !!! 
3) testSurUnGroupeDeGroupeAvecDoublons(question2): Ce composite est valide, revoyez CompositeValide !!! 
4) testUnGroupeDeContributeursAvecUnDoublon(question2): Ce composite est valide, revoyez CompositeValide !!! 
5) testDebitMaximalSurUnGroupeDeGroupes(question2): Le débit maximal doit être de 0 quand le composite n''est pas valide ??? 
6) testLeMemeContributeurPresentTroisFoisAvecDesGroupesDeGroupes(question2): Ce composite est valide, revoyez CompositeValide !!! 
7) testTroisContributeursUnGroupe(question2): Le débit maximal doit être de 0 quand le composite n''est pas valide ??? 
8) testCinqContributeursQuatreGroupes(question2): Ce composite a un doublon, revoyez SansDoublon !!! 
9) testDeuxGroupesAvecLeMemeNom(question2): Ce composite a au moins un doublon, revoyez SansDoublon !!! 
10) testUnGroupeDeGroupeAvecUnDoublon(question2): Ce composite est valide, revoyez CompositeValide !!! 
11) test_SansDoublon_accepter_dans_visite_du_groupe(question2): accepter n''est pas appelée ? curieux... 
12) test_CompositeValide_accepter_dans_visite_du_groupe(question2): accepter est appelée plusieurs fois(>1) ? curieux... 


*/
  
  
  	
   public void testTroisContributeurs()
   {
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      g.ajouter(new Contributeur("g_a",100));
      g.ajouter(new Contributeur("g_b",200));
      g.ajouter(new Contributeur("g_c",300));
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
  }catch(Exception e){
	    fail("exception inattendue !!! " + e.getMessage());
	  }
  } // testTroisContributeurs()
  	
  public void testCompositeValide()
  {
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      g.ajouter(g1);
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

      
      g1.ajouter(new Contributeur("c",100));
      //System.out.println("---");
      //System.out.println(g.toString());
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

   }catch(Exception e){
	    fail("exception inattendue !!! " + e.getMessage());
	  }
  } // testCompositeValide()
  
    public void testTroisContributeursUnGroupe()
    {
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      g.ajouter(new Contributeur("g_a",100));
      g.ajouter(new Contributeur("g_b",200));
      g.ajouter(new Contributeur("g_c",300));
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      assertEquals(" Revoyez D�bitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      g.ajouter(g1);
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide()));
   }catch(Exception e){
	    fail("exception inattendue !!! " + e.getMessage());
	  }
  } // testTroisContributeursUnGroupe()
} // TestsDesVisiteurs

