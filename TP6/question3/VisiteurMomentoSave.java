package question3;

import java.util.LinkedHashMap;
import java.util.Map;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class VisiteurMomentoSave implements Visiteur<Void> {

	private Map<Cotisant, Integer> map ;
	

	public VisiteurMomentoSave() {
		this(new LinkedHashMap<Cotisant, Integer>()) ;
	}
	
	
	public VisiteurMomentoSave(Map<Cotisant, Integer> map) {
		setMap(new LinkedHashMap<Cotisant, Integer>());
	}

	@Override
	public Void visite(Contributeur pC) {
		map.put(pC, pC.solde()) ;
		return null;
	}

	@Override
	public Void visite(GroupeDeContributeurs pG) {

		for(Cotisant c : pG.getChildren()) 
			c.accepter(this) ; 

		return null;
	}

	public Map<Cotisant, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Cotisant, Integer> map) {
		this.map = map;
	}
	
	
	
	

}
