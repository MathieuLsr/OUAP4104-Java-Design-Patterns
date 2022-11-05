package question2;

import java.util.Set;
import java.util.TreeSet;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class SansDoublon implements Visiteur<Boolean>
{
    private Set<String> set;
    int i = 0 ;
  
    public SansDoublon(){
        this.set = new TreeSet<String>();
        //System.out.println("new ?");
    }
    
    public boolean add(String s) {
    	return set.add(s) ;
    }
      
    public Boolean visite(Contributeur c){
        boolean b = set.add(c.nom()) ;
        //System.out.println("> 3. "+c.nom()+" : "+b);
        return b ; 
    }
      
    public Boolean visite(GroupeDeContributeurs g){
        boolean b = set.add(g.nom());
        //i++ ;
        //System.out.println("i = "+i);
        //System.out.println("> 1. "+g.nom()+" : "+b+ ", "+g.getChildren().size()+", "+g.toString());
        for(Cotisant c : g.getChildren()) {
            //System.out.println("Name class : "+c.getClass().getName());
            boolean bool = c.accepter(this) ;
            //System.out.println("- 2. "+c.nom()+" : "+bool);
            if(!bool) return false ;
            //b = b && c.accepter(this);
        }
        return b ;
    }
    
} // SansDoublon