package question2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * D�crivez votre classe JAVASerialiseDeserialise ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class JAVASerialiseDeserialise
{
      public static void serialjava(IProgr p, String nomDuFichier) throws IOException {
		FileOutputStream fout = new FileOutputStream(nomDuFichier); 
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(p);
		out.close();
    }

      public static IProgr deserialjava(String nomDuFichier) throws IOException, ClassNotFoundException{
    	  
    	  	FileInputStream fin = new FileInputStream(nomDuFichier); 
  			ObjectInputStream in = new ObjectInputStream(fin);
  		
  			Object obj = in.readObject() ;
  			in.close(); 
  			
  			IProgr ipro = (IProgr) obj ;
  			
  			return ipro ;
    }    
}
