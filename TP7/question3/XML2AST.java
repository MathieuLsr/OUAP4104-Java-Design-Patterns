package question3;


import org.jdom.Element;

import tp4.question1.Addition;
import tp4.question1.Constante;
import tp4.question1.Contexte;
import tp4.question1.Expression;
import tp4.question1.Multiplication;
import tp4.question1.Soustraction;
import tp4.question1.Variable;
import tp4.question2.Egal;
import tp4.question2.ExpressionBooleenne;
import tp4.question2.Non;
import tp4.question3.Affectation;
import tp4.question3.Afficher;
import tp4.question3.Instruction;
import tp4.question3.Pour;
import tp4.question3.Selection;
import tp4.question3.Sequence;
import tp4.question3.TantQue;

/**
 * D�crivez votre classe XML2AST ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class XML2AST
{

      public static Instruction  xmlInst2ast(Contexte m, Element element) throws Exception{
         
         
         String nomInstruction=element.getName();
         if(nomInstruction=="Affectation"){
             Element el1 = (Element)element.getChildren().get(0);
             Element el2 = (Element)element.getChildren().get(1);
             Variable var=new Variable(m ,el1.getText());
             Expression exp=xmlExp2ast(m,el2);
             return new Affectation(var , exp);
         }
         if(nomInstruction=="Sequence"){
             Element el1 = (Element)element.getChildren().get(0);
             Element el2 = (Element)element.getChildren().get(1);
             Instruction i1=xmlInst2ast(m,el1);
             Instruction i2=xmlInst2ast(m,el2);
              return new Sequence(i1 , i2);
            }
         if(nomInstruction=="Selection"){
             Element el1 = (Element)element.getChildren().get(0);
             Element el2 = (Element)element.getChildren().get(1);
             ExpressionBooleenne b1=xmlExpBool2ast(m,el1);
             Instruction i1=xmlInst2ast(m,el2);
             if(element.getChildren().size()==3){
                 Element el3 = (Element)element.getChildren().get(2);
                 Instruction i2=xmlInst2ast(m,el3);
                 return new Selection(b1 , i1 , i2);
                }
              return new Selection(b1 , i1);
            }
         if(nomInstruction=="TantQue"){
             Element el1 = (Element)element.getChildren().get(0);
             Element el2 = (Element)element.getChildren().get(1);
             ExpressionBooleenne b1=xmlExpBool2ast(m,el1);
             Instruction i1=xmlInst2ast(m,el2);
              return new TantQue(b1 , i1);
            }

         if(nomInstruction=="Pour"){
             Element el1 = (Element)element.getChildren().get(0);
             Element el2 = (Element)element.getChildren().get(1);
             Element el3 = (Element)element.getChildren().get(2);
             Element el4 = (Element)element.getChildren().get(3);
             ExpressionBooleenne b1=xmlExpBool2ast(m,el2);
             Instruction init=xmlInst2ast(m,el1);
             Instruction i1=xmlInst2ast(m,el3);
             Instruction inc=xmlInst2ast(m,el4);
              return new Pour(init , b1 , i1 , inc);
            }
         if(nomInstruction=="Afficher"){
             Element el1 = (Element)element.getChildren().get(0);
             Expression e1=xmlExp2ast(m,el1);
             return new Afficher(e1);
            }

            throw new RuntimeException("Erreur dans instruction ...");
        }
        
         public static Expression xmlExp2ast(Contexte m, Element element) throws Exception{
             
                String name=element.getName();
                
                if(name.equalsIgnoreCase("Variable")) {
 					String nVar = element.getTextNormalize() ;
 					Variable v = new Variable(m, nVar) ;
                	return v; 
                }
                
                if(name.equalsIgnoreCase("Constante")) {
                	return new Constante(Integer.parseInt(element.getValue())) ;
                }
                
                if(name.equalsIgnoreCase("Multiplication")) {
                	Element e1 = (Element) element.getChildren().get(0) ;
 					Element e2 = (Element) element.getChildren().get(1) ;
 					
 					Expression ex1 = xmlExp2ast(m, e1) ;
 					Expression ex2 = xmlExp2ast(m, e2) ;
 					
 					return new Multiplication(ex1, ex2) ;
                }
                
                if(name.equalsIgnoreCase("Addition")) {
                	Element e1 = (Element) element.getChildren().get(0) ;
 					Element e2 = (Element) element.getChildren().get(1) ;
 					
 					Expression ex1 = xmlExp2ast(m, e1) ;
 					Expression ex2 = xmlExp2ast(m, e2) ;
 					
 					return new Addition(ex1, ex2) ;
                }
                
                if(name.equalsIgnoreCase("Soustraction")) {
                	Element e1 = (Element) element.getChildren().get(0) ;
 					Element e2 = (Element) element.getChildren().get(1) ;
 					
 					Expression ex1 = xmlExp2ast(m, e1) ;
 					Expression ex2 = xmlExp2ast(m, e2) ;
 					
 					return new Soustraction(ex1, ex2) ;
                }
                
                
                
// a completer
// a completer
// a completer
            throw new RuntimeException("Erreur dans expression ...");
           
                }
                
                
              public static ExpressionBooleenne  xmlExpBool2ast(Contexte m,Element element) throws Exception{
                String name=element.getName();
                
                if(name.equalsIgnoreCase("Non")) {
                	Element e1 = (Element) element.getChildren().get(0) ;
                	ExpressionBooleenne ex1 = xmlExpBool2ast(m, e1) ;
                	return new Non(ex1) ;
                }
                
                if(name.equalsIgnoreCase("Egal")) {
                	Element e1 = (Element) element.getChildren().get(0) ;
                	Element e2 = (Element) element.getChildren().get(1) ;
                	
                	Expression op1 = xmlExp2ast(m, e1) ;
                	Expression op2 = xmlExp2ast(m, e2) ;
                	
                	return new Egal(op1, op2) ;
                }
                
                
// a completer
// a completer
// a completer
                throw new RuntimeException("Erreur dans expression booleenne...");

           }
}

