package question3;
import java.util.Set;

public class Tests extends junit.framework.TestCase
{
    public void test1(Factory<? extends Set<Integer>> f) throws Exception
    {
        Set<Integer> set = f.create();
        for ( int i=20; i>0; i-- )
            set.add( i );
        
    } // test1(.)

    public void test_Creation()
    {
        try {
            test1( new TreeSetFactory<Integer>() );
            test1( new HashSetFactory<Integer>() );
        } catch( NoSuchMethodError e ) {
            fail( "NoSuchMethodError : " + e );
        } catch( Exception e ) {
            fail( " exception inattendue : " + e );
        } 
    } // test_Creation()
    
    public static void main(String[] args) {
		new Tests().test_Creation(); 
	}
    
    /*
     
     There were 4 failures: 
1) test_TreeSetFactory(question3): exception : ''java.util.Set question3.TreeSetFactory.create()'' 
2) test_TreeSetFactoryComparable2(question3): exception : ''java.util.Set question3.TreeSetFactory.create()'' 
3) test_TreeSetFactoryComparable1(question3): attention, class TreeSetFactory<E extends Comparable<E>> ??? est-ce bien le cas ? 
4) test_HashSetFactory(question3): exception : ''java.util.Set question3.HashSetFactory.create()'' 
     
     
     */
    
} // Tests
