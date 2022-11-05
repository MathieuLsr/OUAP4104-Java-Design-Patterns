package question4;



import java.util.*;
import java.io.*;


public class FileAuditeurDAO implements DAO<Auditeur, Integer>{
   private String fileName;
   
   private List<Auditeur> list ;
   private int id ;
   
   // a� completer
   
   public FileAuditeurDAO(final String path, final String fileName) throws Exception{
     
     File dir = new File(path);
     if (!dir.exists()){ // si le repertoire n'existe pas (1 seul niveau)
    	 dir.mkdir();
     }
     this.fileName = path+fileName;
     File f = new File(this.fileName);
     if(!(f.isFile())){ // si le fichier n'existe pas
    	 f.createNewFile() ;
     }
     
     id = 0 ;
     setList(new LinkedList<Auditeur>()) ;

   }
   
   public FileAuditeurDAO(final String fileName) throws Exception{
     this("."+File.separator, fileName);
   }

 
   public void create(Auditeur a) throws Exception {
	   a.setId(id) ;
	   
	   Auditeur aud = new Auditeur(a.getNom(), a.getPrenom(), a.getEmail()) ;
	   aud.setId(id);
	   
	   id++ ;
	   list.add(aud) ;
	   
	   FileWriter writer = new FileWriter(fileName) ;
	   writer.append(aud.toString()+"\n") ;
	   writer.close(); 
   }
   

   public Auditeur retrieve(Integer id) throws Exception {
	   
	   for(Auditeur a : list) 
		   if(a.getId() == id) return a ;

	   throw new Exception() ;
	   
	   /*
	   List<Auditeur> list = this.findAll() ;
	   for(Auditeur a : list) if(a.getId() == id) return a ;
	   return null ;
	   */
   }
   

   public List<Auditeur> findAll() throws Exception{
	   
	   return new LinkedList<Auditeur>(this.getList());

	   /*
	   	List<Auditeur> list = new LinkedList<Auditeur>() ;
	   
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		while (line != null) {
			line = reader.readLine();
			Auditeur a = Auditeur.parseAuditeur(line) ;
			if(a != null) list.add(a) ;
		}
		reader.close();
		return list ;
		*/
   }
   

   public void update(Auditeur a) throws Exception{

	   List<Auditeur> list = this.findAll() ;
	   
	   for(int i=0 ; i<list.size() ; i++) {
		   Auditeur ad = list.get(i) ;
		   if(ad.getId() != a.getId()) continue ;
		   
		   list.set(i, a) ;
		   return ;
	   }
	   
	   this.updateFile();

   }
   
   // Pas comme ça qu'il faut faire mais l'accès aux fichiers est long donc
   // en tant normal on n'utilise jamais un file en tant que DB. 
   private void updateFile() throws IOException {
	   
	   String str = "" ;
	   
	   for(Auditeur a : list) str += a.toString()+"\n" ;
	   
	   FileWriter writer = new FileWriter(fileName) ;
	   writer.write(str);
	   writer.close(); 
	   
   }
   
   public void delete(Integer id) throws Exception{

	   for(Auditeur a : list) {
		   if(a.getId() == id) {
			   list.remove(a) ;
			   break ;
		   }
	   }
	   
	   this.updateFile();
	   
   }
   
   public List<Auditeur> filter(Criteria<Auditeur> criteria) throws Exception{
     return DAO.DAOUtils.filter(this,criteria);
   }

public List<Auditeur> getList() {
	return list;
}

public void setList(List<Auditeur> list) {
	this.list = list;
}
   
}
