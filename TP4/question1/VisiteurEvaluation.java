package question1;

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c;

    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }
    
    @Override
    public Integer visite(Variable v) {
    	//System.out.println(">> Test : "+c.lire(v.nom()));
    	return c.lire(v.nom()) ;
    }
    
    @Override
    public Integer visite(Addition a) {
    	return a.op1().accepter(this).intValue() + a.op2().accepter(this).intValue() ;
    }
    
    @Override
    public Integer visite(Constante c) {
    	return c.valeur() ;
    }
    
    @Override
    public Integer visite(Division d) {
    	return d.op1().accepter(this).intValue() / d.op2().accepter(this).intValue() ;
    }
    
    @Override
    public Integer visite(Multiplication m) {
    	return m.op1().accepter(this).intValue() * m.op2().accepter(this).intValue() ;
    }
    @Override
    public Integer visite(Soustraction s) {
    	return s.op1().accepter(this).intValue() - s.op2().accepter(this).intValue() ;
    }

    // � compl�ter
    // aucun "warning, de type unsafe � la compilation ne doit appara�tre

    public Contexte contexte() {
        return c;
    } 

}
