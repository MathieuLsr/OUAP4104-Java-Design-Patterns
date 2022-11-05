package question2;


import tp4.question1.*;
import tp4.question2.*;
import tp4.question3.*;


/**
 * D�crivez votre classe AST_Aff ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class AST_Aff extends AST_Progr {
      
/* "WhileL style"  :
    x:=5 ; 
    y:=7+x;

 */
               
      private Contexte m = new Memoire();
    
      private Variable x = new Variable(m,"x");
      private Variable y = new Variable(m,"y");
      private Constante cinq = new Constante(5);
      private Constante sept = new Constante(7);
      private Instruction ast = new Sequence(
                                  new Affectation(x , cinq),
                                  new Affectation(y , new Addition(sept,x))
                                  );

           
            public Contexte getMem(){
                return m;
            }
            
            public Instruction getAST(){
                return ast;
            }
           
}
