package question2;

// import des classes de gestion des fichiers en ecriture
import java.io.BufferedWriter;
import java.io.FileWriter;
// exceptions susceptibles d'etre engendrees lors d'une operation de lecture ou d'ecriture
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class FileHandler extends Handler<Float> // a completer
{
  private static final int MAX= 5;
  private String aFileName;
 
  private SortedMap<Date, Float> aTable;

  public FileHandler( final String pFileName, final Handler<Float> pSuccessor )
  {
    /* a completer */

	  super.aSuccessor = pSuccessor ;
	  this.aSuccessor = pSuccessor ;
    this.aFileName = pFileName;
    this.aTable    = new TreeMap<Date, Float>() ; /* a modifier */
  } // FileHandler(..)

  public boolean handleRequest( final Float pValue )
  {
    
	  	Calendar  vCal = Calendar.getInstance();
		
		aTable.put(vCal.getTime(), pValue) ;
		if(aTable.size()%MAX == 0)
			try {
				this.writeHTML();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
		return super.handleRequest(pValue); /* a modifier */
  } // handleRequest(.)

  /** Cette methode genere un fichier HTML .
   */
  private void writeHTML() throws IOException
  {
	  
	  System.out.println("----");
	  System.out.println("Write HTML...");
	  System.out.println("");
	  
    BufferedWriter vBW = new BufferedWriter( new PrintWriter(
        new FileWriter( this.aFileName + ".html" ) ) );
    vBW.write( "<html><head><title>mesures du taux d'humidit� relative</title>" );
    vBW.write( "<meta http-equiv=\"refresh\" content=\"30\">" );
    vBW.write( "</head><body><br>\r\n<table border=\"2\" bgcolor=\"#CBFEEA\">" );

    
    for(Entry<Date, Float> p : aTable.entrySet()) {
    	DateFormat vDF = DateFormat.getDateInstance( DateFormat.SHORT, Locale.FRANCE );
    	DateFormat vDT = DateFormat.getTimeInstance( DateFormat.SHORT, Locale.FRANCE );    
        String vDate = vDF.format( p.getKey() ) + "-" + vDT.format( p.getKey() );
        
        String s = "<tr><td>"+vDate+"</td>\r\n" + 
        		"<td>"+p.getValue()+"</td></tr>" ;
        
        vBW.write(s);
    }
    
    
    /* a completer */
    /* a completer */
    /* a completer */
    /* a completer */

    vBW.write( "</table>\r\n</body></html>" );
    vBW.close();
    
  } // writeHTML()

} // FileHandler
