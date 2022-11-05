package question1;

/**
 * Decrivez votre classe Main ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class Main
{

  public static void main( final String[] pArgs )
  {
    HTTPSensor.setHttpProxy( "cache.esiee.fr", 3128 );

    HTTPSensor vDS2438;
    if ( pArgs.length == 0 )
      vDS2438 = new HTTPSensor();
    else
      vDS2438 = new HTTPSensor( pArgs[0] );

    try {
      // a completer pour 1.1 puis a modifier pour 1.2 :
      System.out.println( "requête auprès du ds2438 : "   );
      
      //String str1 = vDS2438.request() ;
      //String str2 = vDS2438.request() ;
      //System.out.println("1 : "+str1);
      //System.out.println("2 : "+str2);
      
      float f1 = vDS2438.value() ;
      float f2 = vDS2438.value() ;
      
      System.out.println(f1);
      System.out.println(f2);
      
      
    }
    catch ( final Exception pE ) {
      pE.printStackTrace();
    }
  } // main(.)
} // Main
