package question2;


import tp4.question1.*;
import tp4.question2.*;
import tp4.question3.*;

public class Test_AST_Aff extends junit.framework.TestCase{
     public void test_Aff(){
       try{
         AST_Progr p = new AST_Aff();
         //construction des Visiteurs n�cessaires
         // visteur d'�valuation
        Contexte m = new Memoire();
        VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);

        Instruction ast=p.getAST(); //r�cup�ration de l'AST
        ast.accepter(vi); //�valuation proprement dite de l'AST
        assertTrue(" ce n'est pas le r�sultat attendu ...", m.lire("y")==12);
      }catch(Exception e){
        fail("exception inattendue : " + e.getMessage());
      }
 	 
	}   
}

