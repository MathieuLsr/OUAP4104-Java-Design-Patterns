package question2;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class DebitMaximal implements Visiteur<Integer> {
    

    public DebitMaximal() {}
    

  @Override public Integer visite( final Contributeur c )
  {
      return c.solde() ;
  } // visite(.)
  
      @Override public Integer visite( final GroupeDeContributeurs g ) {
        int vRes = Integer.MAX_VALUE;
        
        //if(!g.accepter(new CompositeValide())) return 0 ;
        
        for(Cotisant c : g.getChildren()) 
            vRes = Math.min(vRes, c.accepter(this)) ;
        
        // a completer
        return vRes;
      } // visite(.)
} // DebitMaximal