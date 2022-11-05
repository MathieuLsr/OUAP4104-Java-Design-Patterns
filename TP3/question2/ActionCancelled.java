package question2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ActionCancelled {

	private List<String> list ;
	private Map<String, Integer> map ; 
	
	public ActionCancelled(List<String> list, Map<String, Integer> map) {
		this.setList(new LinkedList<String>(list)) ;
		this.setMap(new HashMap<String, Integer>(map));
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	
}
