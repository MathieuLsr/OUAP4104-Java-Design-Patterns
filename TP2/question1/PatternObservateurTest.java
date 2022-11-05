/**/ package question1; // classe de test

// devrait s'appeler PatternObservateurTest

/**/ public class PatternObservateurTest extends junit.framework.TestCase
/**/ {
	/*
	public static void main(String[] args) {
		PatternObservateurTest patternObservateurTest = new PatternObservateurTest() ;
		patternObservateurTest.test1();
		patternObservateurTest.test2();
		patternObservateurTest.test3();
		patternObservateurTest.testNotify();
        }*/

/**/   public void testNotify()
/**/   {
/**/     ConcreteSubject list;
/**/     ConcreteObserver observer;

/**/     list= new ConcreteSubject();
/**/     observer= new ConcreteObserver();
/**/     list.addObserver( observer );
/**/     list.insert( "il fait beau, ce matin" );

/**/     assertEquals( list, observer.senders().pop() );
/**/     assertEquals( "il fait beau, ce matin", observer.arguments().pop() );
/**/     list.insert( "super !!, je prends mon impermeable" );
/**/   } // testNotify()

       // une liste, 2 observateurs
       // Attention !  Les emetteurs sont des Observable, pas des String
/**/   public void test1()
/**/   {
/**/     question1.ConcreteSubject list1= new question1.ConcreteSubject();
/**/     question1.ConcreteObserver o1= new question1.ConcreteObserver();
/**/     question1.ConcreteObserver o2= new question1.ConcreteObserver();
/**/     list1.addObserver( o1 );
/**/     list1.addObserver( o2 );
/**/     list1.insert( "test" );
/**/     list1.insert( " un " );

    // a completer a partir de la ligne 36
    // verifier que les deux observateurs ont bien ete notifies avec les bons param�tres
		
		
		assertFalse("L'observer o1 est vide", o1.arguments().empty());
		assertFalse("L'observer o2 est vide", o2.arguments().empty());

		assertEquals(2, list1.countObservers());
		
		assertEquals("o1 n'a pas reçu toutes les infos", "[test,  un ]", o1.arguments().toString());
		assertEquals("o2 n'a pas reçu toutes les infos", "[test,  un ]", o2.arguments().toString());
		
		assertEquals("o1 n'a pas reçu les bonnes infos", " un ", o1.arguments().pop().toString());
		assertEquals("o2 n'a pas reçu les bonnes infos", " un ", o2.arguments().pop().toString());
		
		assertEquals("o1 n'a pas reçu les bonnes infos", "[test]", o1.arguments().toString());
		assertEquals("o2 n'a pas reçu les bonnes infos", "[test]", o2.arguments().toString());
		
		assertEquals("o1 n'a pas reçu les bonnes infos", "test", o1.arguments().pop().toString());
		assertEquals("o2 n'a pas reçu les bonnes infos", "test", o2.arguments().pop().toString());
		
		assertEquals(2, o1.senders().size());
		assertEquals(2, o2.senders().size());
		
		assertEquals("[test,  un ]", o1.senders().pop().toString());
		assertEquals("[test,  un ]", o2.senders().pop().toString());
		
		assertEquals("[test,  un ]", o1.senders().pop().toString());
		assertEquals("[test,  un ]", o2.senders().pop().toString());
		
    //fail( "a completer !!" );
    
    
    
    
    
    

    // ne pas modifier ces lignes, dernieres assertions vraies de cette methode
    // elles echouent si le code a ete mal complete ci-dessus
    assertTrue( "Pile des emetteurs de o1 non vide !", o1.senders().empty() );
    assertTrue( "Pile des arguments de o1 non vide !", o1.arguments().empty() );
    assertTrue( "Pile des emetteurs de o2 non vide !", o2.senders().empty() );
    assertTrue( "Pile des arguments de o2 non vide !", o2.arguments().empty() );
  } // test1()

  // deux listes, 1 observateur
  public void test2()
  {
    question1.ConcreteSubject list1= new question1.ConcreteSubject();
    question1.ConcreteSubject list2= new question1.ConcreteSubject();

    question1.ConcreteObserver o= new question1.ConcreteObserver();
    list1.addObserver( o );
    list2.addObserver( o );
    list1.insert( "testA" );
    list1.insert( " A " );
    list2.insert( "testB" );
    list2.insert( " B " );

    // a completer a partir de la ligne 69
    // verifier que l'observateur a bien ete notifie par les deux listes
    
    assertEquals("[testA,  A , testB,  B ]", o.arguments().toString());
    assertEquals("[testB,  B ]", o.senders().pop().toString());
    assertEquals("[testB,  B ]", o.senders().pop().toString());
    assertEquals("[testA,  A ]", o.senders().pop().toString());
    assertEquals("[testA,  A ]", o.senders().pop().toString());
    assertEquals(" B ", o.arguments().pop().toString());
    assertEquals("testB", o.arguments().pop().toString());
    assertEquals(" A ", o.arguments().pop().toString());
    assertEquals("testA", o.arguments().pop().toString());
    
    
    

    // ne pas modifier ces lignes, dernieres assertions vraies de cette methode
    // elles echouent si le code a ete mal complete ci-dessus
    assertTrue( "Pile des emetteurs de o non vide !", o.senders().empty() );
    assertTrue( "Pile des arguments de o non vide !", o.arguments().empty() );
  } // test2()

  // deux listes, 2 observateurs
  public void test3()
  {
    question1.ConcreteSubject list1= new question1.ConcreteSubject();
    question1.ConcreteSubject list2= new question1.ConcreteSubject();
    question1.ConcreteObserver o1= new question1.ConcreteObserver();
    question1.ConcreteObserver o2= new question1.ConcreteObserver();
    list1.addObserver( o1 );
    list1.addObserver( o2 );
    list2.addObserver( o1 );
    list2.addObserver( o2 );

    // a completer a partir de la ligne 94
    // verifier le bon fonctionnement de countObservers(), de deleteObserver et deleteObservers()

    assertEquals(2, list1.countObservers());
    assertEquals(2, list2.countObservers());
    
    list1.deleteObserver(o1);
    list2.deleteObserver(o1);
    
    assertEquals(1, list1.countObservers());
    assertEquals(1, list2.countObservers());
    
    list1.addObserver( o1 );
    list2.addObserver( o1 );
    list1.deleteObservers();
    list2.deleteObservers();
    

    // ne pas modifier ces lignes, dernieres assertions vraies de cette methode
    // elles echouent si le code a ete mal complete ci-dessus
    assertTrue( "Pile des emetteurs de o1 non vide !", o1.senders().empty() );
    assertTrue( "Pile des emetteurs de o2 non vide !", o2.senders().empty() );
    assertEquals( "Nombre d'observateurs de list1", 0, list1.countObservers() );
    assertEquals( "Nombre d'observateurs de list2", 0, list2.countObservers() );
  } // test3()

} // PatternObservateurTest
