package question2;


import tp4.question1.*;
import tp4.question2.*;
import tp4.question3.*;

import java.io.*;

/**
 * D?crivez votre classe abstraite AST_Progr ici.
 *
 * @author  (votre nom)
 * @version (un num?ro de version ou une date)
 */
public abstract class AST_Progr implements IProgr{
  protected Instruction  ast;
	protected Contexte m;
	protected Variable n;		
}
