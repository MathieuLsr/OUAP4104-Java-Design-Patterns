package question2;

/**
 * Decrivez votre classe MinHandler ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class MinHandler extends Handler<Float>
{

  public MinHandler( final Handler<Float> pSuccessor )
  {
    super( pSuccessor );
  } // MinHandler(.)

  public boolean handleRequest( final Float pValue )
  {
    // a completer
	  
	  
	  if(pValue >= 35) return super.handleRequest(pValue) ;	
	  //super.getSuccessor().handleRequest(pValue) ;
	  
	  System.out.println("Minimum... : "+pValue);
	  return true ;
	  /*
	  Calendar  vCal = Calendar.getInstance();
	    DateFormat vDF = DateFormat.getDateInstance( DateFormat.SHORT, Locale.FRANCE );
	    DateFormat vDT = DateFormat.getTimeInstance( DateFormat.SHORT, Locale.FRANCE );
	    String   vDate = vDF.format( vCal.getTime() ) + "-" + vDT.format( vCal.getTime() );
	    System.out.println( "[" + vDate + "] ds2438.value : " + pValue +" ||| MIN");
	  
    return true ; // a modifier
    */
  } // handleRequest(.)
} // MinHandler
