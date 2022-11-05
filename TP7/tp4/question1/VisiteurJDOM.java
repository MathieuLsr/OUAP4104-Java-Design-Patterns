package tp4.question1;


import org.jdom.Element;

 
public class VisiteurJDOM extends VisiteurParDefaut<Element>{   

  private  Contexte c;
  
  public VisiteurJDOM(Contexte c){
    this.c =c;
  }
	public  Element visite(Constante c){
	    Element cste=new Element("Constante");
	    cste.addContent(""+c.valeur()) ;

// a completer
	    return cste;
	}
	
  public Element visite(Variable v){
	    Element var=new Element("Variable");
	    var.addContent(v.nom()) ;
	    //var.addContent(new Constante(c.lire(v.nom())).accepter(this)) ;
// a completer
	    return var;
  }
  
  public Element visite(Division d){
	    Element div=new Element("Division");
	    div.addContent(d.op1().accepter(this)) ;
	    div.addContent(d.op2().accepter(this)) ;
// a completer
// a completer
    return div;
  }
  
  public Element visite(Addition a){
	    Element add=new Element("Addition");
	    add.addContent(a.op1().accepter(this)) ;
	    add.addContent(a.op2().accepter(this)) ;
// a completer
// a completer
    return add;
  }
  public Element visite(Multiplication m){
	    Element mul=new Element("Multiplication");
	    mul.addContent(m.op1().accepter(this)) ;
	    mul.addContent(m.op2().accepter(this)) ;
// a completer
// a completer
    return mul;
  }
  public Element visite(Soustraction s){
	    Element sous=new Element("Soustraction");
	    sous.addContent(s.op1().accepter(this)) ;
	    sous.addContent(s.op2().accepter(this)) ;
// a completer
// a completer
    return sous;
  }
  
  public Contexte contexte(){return c;}
}
