package question3;

import java.util.HashSet;
import java.util.Set;

public class HashSetFactory<T> implements Factory<Set<T>>
{

	@Override
	public Set<T> create() {
		return new HashSet<T>() ;
		/*
		List<String> list = new ArrayList<String>() ;
		String prefix = "test" ;
		
		for(String str : list ) {
			if(str.startsWith(prefix))
		}
		list.removeIf(str -> str.startsWith(prefix)) ;
		
		
		return null ;
		*/
	}

} // HashSetFactory