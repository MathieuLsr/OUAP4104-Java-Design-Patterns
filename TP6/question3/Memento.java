package question3;

import java.util.LinkedHashMap;
import java.util.Map;

import question1.Cotisant;

public class Memento 
{
    // Note : Un usage du patron Memento, 
    //        d�un premier visiteur pour la sauvegarde et 
    //        d�un second pour la restitution du composite, 
    //        representent une solution possible. 
	
	private VisiteurMomentoSave visiteurMomento ;
	private Map<Cotisant, Integer> map ;
	
    public Memento( final Cotisant pC )
    {
    	setMap(new LinkedHashMap<Cotisant, Integer>());
    	pC.accepter(visiteurMomento = new VisiteurMomentoSave()) ;
    } // Memento(.)

    public void setState( final Cotisant pC )
    {
    	pC.accepter(new VisiteurMomentoBack(visiteurMomento.getMap())) ;
    }

	public VisiteurMomentoSave getVisiteurMomento() {
		return visiteurMomento;
	}

	public void setVisiteurMomento(VisiteurMomentoSave visiteurMomento) {
		this.visiteurMomento = visiteurMomento;
	}

	public Map<Cotisant, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Cotisant, Integer> map) {
		this.map = map;
	}

} // Memento