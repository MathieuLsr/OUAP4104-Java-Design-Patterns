package question1;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public class BeetSugar extends CondimentDecorator {

	public BeetSugar(Beverage beverage) {
		super(beverage);
		this.description = "Beet Sugar" ;
	}
	
	public String getDescription() {
		return super.getDescription() + ", "+this.description;
	}

	public double cost() {
		return .10 + super.cost() ;
	}

	

/* a completer */

}