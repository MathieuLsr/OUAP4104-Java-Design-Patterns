package question1;

import java.text.DecimalFormat;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public abstract class CondimentDecorator extends Beverage {
  protected Beverage beverage;
  
  private static DecimalFormat df = new DecimalFormat("#0.##"); // format d'affichage
  
  public CondimentDecorator(Beverage beverage){
    this.beverage = beverage;
  }
  
	public String getDescription(){
	  return beverage.getDescription();
	 }
	 
	public double cost(){
	  return beverage.cost();
  }
	
	@Override
	public String toString() {
		String str = this.getDescription()+" $"+df.format(this.cost()) ;
		int i = str.lastIndexOf(",");
		StringBuilder builder = new StringBuilder();
		builder.append(str.substring(0, i));
		builder.append(".");
		builder.append(str.substring(i+1));
		
		return builder.toString() ; 
	}
	
	
	
}
