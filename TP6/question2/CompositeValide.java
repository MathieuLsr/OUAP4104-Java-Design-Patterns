package question2;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class CompositeValide implements Visiteur<Boolean>
{
    // Le solde de chaque contributeur doit etre superieur ou egal a valeur 
    // et il n�existe pas de groupe n�ayant pas de contributeurs.

    private SansDoublon vsd ;
    private int valeur ;
    
    
    public CompositeValide(int valeur){
        this.valeur = valeur ;
        vsd = new SansDoublon() ;
    }
    

    public CompositeValide(){
        this(0);
    }

    @Override public Boolean visite( final Contributeur pC )
    {
    	if(!pC.accepter(vsd)) return false ;
        return pC.solde() >= this.valeur ;
    } // visite(.)

    @Override public Boolean visite( final GroupeDeContributeurs pG )
    {
        
        if(pG.getChildren().isEmpty()) return false ;
        if(!vsd.add(pG.nom())) return false ;
        //if(!pG.accepter(vsd)) return false ;
        
        for(Cotisant c : pG.getChildren())
            if(!c.accepter(this)) return false ;
        
        return true ; 
    } // visite(.)
} // CompositeValide


/*


There were 10 failures: 
1) testLeMemeContributeurPresentDeuxFois(question2): Ce composite a un doublon, revoyez SansDoublon !!! 
2) testUnGroupeDeContributeursAvecUnDoublon(question2): Ce composite a au moins un doublon, revoyez SansDoublon !!! 
3) testSurUnGroupeDeGroupeAvecDoublons(question2): Ce composite est valide, revoyez CompositeValide !!! 
4) testUnContributeurUnGroupeAvecLeMemeNom(question2): Ce composite a au moins un doublon, revoyez SansDoublon !!! 
5) testLeMemeContributeurPresentTroisFoisAvecDesGroupesDeGroupes(question2): Ce composite a un doublon, revoyez SansDoublon !!! 
6) testUnGroupeDeGroupeAvecUnDoublon(question2): Ce composite a au moins un doublon, revoyez SansDoublon !!! 
7) testCinqContributeursQuatreGroupes(question2): Ce composite a un doublon, revoyez SansDoublon !!! 
8) testDeuxGroupesAvecLeMemeNom(question2): Ce composite a au moins un doublon, revoyez SansDoublon !!! 
9) test_SansDoublon_accepter_dans_visite_du_groupe(question2): accepter n''est pas appelée ? curieux... 
10) test_CompositeValide_accepter_dans_visite_du_groupe(question2): accepter est appelée plusieurs fois(>1) ? curieux... 



*/