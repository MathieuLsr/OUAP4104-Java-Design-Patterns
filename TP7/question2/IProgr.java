package question2;


import tp4.question1.*;
//import tp6.question2.*;
import tp4.question3.*;

/**
 * D�crivez votre interface IProgr ici.
 * 
 * @author  (votre nom) 
 * @version (un num�ro de version ou une date)
 */

public interface IProgr extends java.io.Serializable{
      Contexte getMem();
      Instruction getAST();
}
