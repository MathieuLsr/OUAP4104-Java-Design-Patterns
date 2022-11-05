package question1;


public class ChocolateTest extends junit.framework.TestCase{
    private Chocolate choco;


    public void setUp(){
        choco = new Chocolate();
    }
    
    /* 
un chocolat seul
un chocolat avec de la crème(Whip)
un chocolat avec deux rations de crème
un chocolat avec de la crème, du soja(soy) et du moka(mocha),... ( les goûts ne se discutent pas ...)
un café décaféiné avec du lait
     */
    
     public void testChocolate(){
         assertEquals(2.1, choco.cost(), 0.1);
     }
 
     public void testChocolateWhip(){
         Beverage chocoSimpleWhip = new Whip(choco);
 
         assertEquals(2.2, chocoSimpleWhip.cost(), 0.01);
     }
     
     public void testChocolateWhipWhip(){
         Beverage chocoDoubleWhip = new Whip(new Whip(choco));
 
         assertEquals(2.3, chocoDoubleWhip.cost(), 0.01);
     }
     
     public void testChocolateWhipSoyMocha(){
         Beverage chocoWhipSoyMocha = new Mocha(new Soy(new Whip(choco)));
 
         assertEquals(2.55, chocoWhipSoyMocha.cost(), 0.01);
     }
     
     public void tesstChocolateDecafeine(){
         Beverage chocoWhipSoyMocha = new Milk(new Decaf()) ;
 
         assertEquals(1.15, chocoWhipSoyMocha.cost(), 0.01);
     }
     
    
     public void testToString() {
    	 
    	 Beverage b = new BeetSugar( new Whip( new Mocha( new Soy( new HouseBlend() ) ) ) );
    	 //System.out.println(b);
    	 
    	 assertEquals(b.toString(), "House Blend Coffee, Soy, Mocha, Whip, Beet Sugar $1.44");
    	 // House Blend Coffee, Soy, Mocha, Whip, Beet Sugar $1.44
    	 
     }
    
    

    
}

