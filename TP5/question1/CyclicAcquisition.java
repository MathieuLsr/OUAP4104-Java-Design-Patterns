package question1;

public class CyclicAcquisition implements Runnable
{
  private Thread aLocal;
  private HumiditySensor aSensor;
  private long aPeriod;
  private Command<Float> aCommand;

  public CyclicAcquisition( final HumiditySensor pSensor, final long pPeriod,
      final Command<Float> pCommand ) throws Exception
  {
    if ( pPeriod < pSensor.minimalPeriod() )
      throw new Exception( " respectez la periode minimale ( >= "
          + pSensor.minimalPeriod() + ") !!" );
    this.aSensor  = pSensor;
    this.aPeriod  = pPeriod;
    this.aCommand = pCommand;
    this.aLocal   = new Thread( this );
  } // CyclicAcquisition(...)

  public void start()
  {
	  this.aLocal.start();  
    /* demarrer le thread */
    // a completer
  } // start()

  public void stop()
  {
	  this.aLocal.interrupt();
    /* interrompre le thread */
    // a completer
  } // stop()

  public synchronized void setPeriod( final long pPeriod ) throws Exception
  {
    if ( pPeriod < this.aSensor.minimalPeriod() )
      throw new Exception( " respectez la periode minimale ( >= "
          + this.aSensor.minimalPeriod() + ") !!" );
    this.aPeriod = pPeriod;
  } // setPeriod(.)

  public void run()
  {
    try {
      if ( Thread.currentThread() != this.aLocal )
        throw new Exception( "Mauvais thread !!" );
      while ( !this.aLocal.isInterrupted() ) {
        synchronized ( this ) {
          try {
        	  float f = this.aSensor.value() ;
        	  
        	  if(f < 0) throw new Exception("Valeur négative non acceptée.") ;
        	  this.aCommand.make(f);
            /* lecture du capteur et transmission de la valeur par make() */
            // a completer
          }
          catch ( final Exception pE ) {
        	  this.aCommand.make(-1f);
        	  //this.aLocal.interrupt();
        	  //pE.printStackTrace();
            /* transmission d'une valeur negative par make() */
            // a completer
          }
          Thread.sleep( this.aPeriod );
        } // synchronized
      } // while
    }
    catch ( final InterruptedException pIE ) {
      // rien
    }
    catch ( final Exception pE ) {
    	pE.printStackTrace();
      //System.out.println( pE.toString() );
    } // catch
  } // run()
} // CyclicAcquisition
