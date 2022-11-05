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
public class TestSOM   extends junit.framework.TestCase{

 
  
    public void testSOM1(){
      try{
         AST_SOM_W p = new AST_SOM_W(100);
         Contexte m=(Memoire)p.getMem(); // r�cup�ration du contexte
         //construction des Visiteurs n�cessaires
         // visteur d'�valuation
         	    VisiteurExpression ve = new VisiteurEvaluation(m);
	    VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
	    VisiteurInstruction vi = new VisiteurInstEvaluation(ve,vb);
	// Visiteur "toString()" pour la visualisation des r�sultats    
	    VisiteurExpression ves = new VisiteurInfixe(m);
	    VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
	    VisiteurInstruction vs = new VisiteurInstToString(ves,vbs);

       //m.ecrire("n" , 10);// initialisation  de n � 10
       Instruction ast=p.getAST(); //r�cup�ration de l'AST
 	  ast.accepter(vi); //�valuation proprement dite de l'AST
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	  assertTrue((String)ast.accepter(vs) + " ne donne pas le r�sultat attendu ...", m.lire("som")==5050);
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	   	 }catch (Exception e){
     fail("exception inattendue !!! : " + e.getMessage()); 
   }
	}   
	
	   public void testMult2(){
	     try{
         AST_SOM_W p = new AST_SOM_W(100);
         Contexte m=(Memoire)p.getMem(); // r�cup�ration du contexte
         //construction des Visiteurs n�cessaires
         // visteur d'�valuation
         	    VisiteurExpression ve = new VisiteurEvaluation(m);
	    VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
	    VisiteurInstruction vi = new VisiteurInstEvaluation(ve,vb);
	// Visiteur "toString()" pour la visualisation des r�sultats    
	    VisiteurExpression ves = new VisiteurInfixe(m);
	    VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
	    VisiteurInstruction vs = new VisiteurInstToString(ves,vbs);

       //m.ecrire("n" , 10);// initialisation  de n � 10
       Instruction ast=p.getAST(); //r�cup�ration de l'AST
 	  ast.accepter(vi); //�valuation proprement dite de l'AST
 	   	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	  assertTrue(ast.accepter(vs) + " ne donne pas le r�sultat attendu ...", m.lire("som")==(5050));
 	  //System.out.println("contenu de la m�moire en fin  : " + m);
 	   	 }catch (Exception e){
     fail("exception inattendue !!! : " + e.getMessage()); 
   }
	}   
	
}
