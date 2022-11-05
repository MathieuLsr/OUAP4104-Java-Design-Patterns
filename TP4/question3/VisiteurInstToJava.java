package question3;

import question1.Contexte;
import question1.VisiteurExpression;
import question2.VisiteurExpressionBooleenne;

/**
 * 
 */
public class VisiteurInstToJava extends VisiteurInstruction<String> {

	private final static int TAB = 2;
	private static final String lineSeparator = System.getProperties().getProperty("line.separator");

	private VisiteurExpression<String> vi;
	private VisiteurExpressionBooleenne<String> vb;

	private int tabulations;

	/**
	 * Cr�ation d'un visiteur d'instructions
	 * 
	 * @param vi
	 *            le visiteur d'expressions arithm�tiques
	 * @param vb
	 *            le visiteur d'expression bool�ennes
	 * @param tabulations
	 *            tabulations initiales
	 */
	public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb, int tabulations) {
		this.vi = vi;
		this.vb = vb;
		this.tabulations = tabulations;
	}

	/**
	 * Cr�ation d'un visiteur d'instructions
	 * 
	 * @param vi
	 *            le visiteur d'expressions arithm�tiques
	 * @param vb
	 *            le visiteur d'expression bool�ennes
	 */
	public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb) {
		this(vi, vb, 0);
	}

	/**
	 * obtention du contexte, ici celui du visiteur d'expression arithm�tiques
	 * 
	 * @return le contexte ici de vi(le visiteur d'expression)
	 */
	public Contexte contexte() {
		return this.vi.contexte();
	}

	/**
	 * Visite d'une instance de la classe Affectation.
	 * 
	 * 
	 * @param a
	 *            une affectation
	 * @return a := exp
	 */
	public String visite(Affectation a) {
		System.out.println(">> "+a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi));
		return a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi);
	}

	/**
	 * Visiste d'une s�quence seq(I1,I2) <br>
	 * 
	 * @param seq
	 *            une s�quence
	 * @return i1;i2
	 */
	public String visite(Sequence seq) {
		return seq.i1().accepter(this)+";"+tab(0)+seq.i2().accepter(this)+";"; // � compl�ter
	}

	public String visite(Selection sel) {
		
		String str = "if("+sel.cond().accepter(vb)+"){"+sel.i1().accepter(this)+"} " ;
		if(sel.i2() != null) str += "else {"+sel.i2().accepter(this)+"}" ;
		
		return str ;
				  // � compl�ter
	}

	public String visite(TantQue tq) {
		String str = tab(0)+"while("+tq.cond().accepter(vb)+" ) { "+tab(2) +
			tq.i1().accepter(this) + tab(-2)+ "}" ;
		
		return str; // � compl�ter
	}

	public String visite(Pour pour) {
		return new Sequence(pour.init(), new TantQue(pour.cond(), new Sequence(pour.i1(), pour.inc()))).accepter(this) ;
		//return new TantQue(pour.cond(), pour.i1()).accepter(this) ;
	}

	public String visite(Afficher a) {
		return "System.out.println("+a.accepter(this)+");" ;
	}

	public String visite(Assertion a) {
		return "assert "+a.cond().accepter(vb) ;
	}

	private String tab(int n) {
		String str = new String();		
		str = str + lineSeparator;
		for (int i = 0; i < this.tabulations + n; i++) {
			str = str + " ";
		}
		this.tabulations += n;
		return str;
	}
	
	
	/*
	 
	 There were 9 failures: 
1) testPour(question3) failed
2) testPour(question3): y := 1{x=3, y=5, z=2} ??? 
3) testSequence(question3): x := 1 ; x := (x + 1){x=3, y=5, z=2} ??? 
4) testSelection(question3): si(x < 10) alors x := 1 sinon x := 2 fsi{x=3, y=5, z=2} ??? 
5) testAffectation(question3): x := 12{x=3, y=5, z=2} ??? 
6) testPour1_10_itérations(question3): null ne donne pas le résultat attendu ... 
7) testPour1_0_itération(question3): null ne donne pas le résultat attendu ... 
8) testPour2_10_itérations(question3): null ne donne pas le résultat attendu ... 
9) testPour1_1_itération(question3): null ne donne pas le résultat attendu ... 
	 
	 There were 9 failures: 
1) testPour(question3) failed
2) testSelection(question3): si(x < 10) alors x := 1 sinon x := 2 fsi{x=3, y=5, z=2} ??? 
3) testAffectation(question3): x := 12{x=3, y=5, z=2} ??? 
4) testPour(question3): y := 1{x=3, y=5, z=2} ??? 
5) testSequence(question3): x := 1 ; x := (x + 1){x=3, y=5, z=2} ??? 
6) testPour1_10_itérations(question3): null ne donne pas le résultat attendu ... 
7) testPour2_10_itérations(question3): null ne donne pas le résultat attendu ... 
8) testPour1_0_itération(question3): null ne donne pas le résultat attendu ... 
9) testPour1_1_itération(question3): null ne donne pas le résultat attendu ... 
	 
	 */

}
