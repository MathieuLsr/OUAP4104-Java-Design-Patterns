package question1;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public class Chocolate extends Beverage {

	public Chocolate() {
		description = "Chocolate";
	}
 
	@Override
	public double cost() {
		return 2.10;
	}
  
}

