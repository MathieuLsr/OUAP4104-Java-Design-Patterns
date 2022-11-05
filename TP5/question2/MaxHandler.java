package question2;

public class MaxHandler extends Handler<Float>
{

  public MaxHandler( final Handler<Float> pSuccessor )
  {
    super( pSuccessor );
  } // MaxHandler(.)

  public boolean handleRequest( final Float pValue )
  {
	  if(pValue < 35) return super.handleRequest(pValue) ;
	  
	  System.out.println("Maximum... : "+pValue);
	  return true ;
	  
  } // handleRequest(.)
} // MaxHandler
