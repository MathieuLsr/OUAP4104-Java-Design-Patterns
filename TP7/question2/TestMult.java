package question2;


import tp4.question1.*;
import tp4.question2.*;
import tp4.question3.*;

import java.io.*;


/**
 * D�crivez votre classe TestSerialJava ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class TestMult   extends junit.framework.TestCase{

 
  
    public void testMult1(){
      try{
         AST_Mult1 p = new AST_Mult1(7,85);
         Contexte m=p.getMem(); // r�cup�ration du contexte
         //construction des Visiteurs n�cessaires
         // visteur d'�valuation
         	    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
	    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
	    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
	// Visiteur "toString()" pour la visualisation des r�sultats    
	    VisiteurExpression<String> ves = new VisiteurInfixe(m);
	    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
	    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

       //m.ecrire("n" , 10);// initialisation  de n � 10
       Instruction ast=p.getAST(); //r�cup�ration de l'AST
 	  ast.accepter(vi); //�valuation proprement dite de l'AST
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	  assertTrue(ast.accepter(vs) + " ne donne pas le r�sultat attendu ...", m.lire("produit")==(7*85));
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	   	 }catch (Exception e){
     fail("exception inattendue !!! : " + e.getMessage()); 
   }
	}   
	
	   public void testMult2(){
     try{     AST_Mult2 p = new AST_Mult2(7,85);
         Contexte m=p.getMem(); // r�cup�ration du contexte
         //construction des Visiteurs n�cessaires
         // visteur d'�valuation
         	    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
	    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
	    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
	// Visiteur "toString()" pour la visualisation des r�sultats    
	    VisiteurExpression<String> ves = new VisiteurInfixe(m);
	    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
	    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

       //m.ecrire("n" , 10);// initialisation  de n � 10
       Instruction ast=p.getAST(); //r�cup�ration de l'AST
 	  ast.accepter(vi); //�valuation proprement dite de l'AST
 	   	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	  assertTrue(ast.accepter(vs) + " ne donne pas le r�sultat attendu ...", m.lire("produit")==(7*85));
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	   	 }catch (Exception e){
     fail("exception inattendue !!! : " + e.getMessage()); 
   }
	}   
	
}
