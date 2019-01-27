package HashTable_Collisions_Comparison;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Iterator;

public class LPHastTest {
	HashComparator<String> scomp = new StringComparator();
	LPHash<String, String> ht = new LPHash<String, String>(101, scomp);

	@Test
	public void testHT() {
		assertEquals(ht.size().intValue(), 0); 
		assertEquals(ht.isEmpty(), true);
		assertEquals(ht.findElement("Marco"), null);
		ht.insert("R2", "D2"); //Marco
		ht.insert("C3", "P0"); //Olson
		ht.insert("BB", "8"); //Picard
		ht.insert("Mouse", "Droid"); //Janeway
		assertEquals(ht.size().intValue(), 4);
		assertEquals(ht.isEmpty(), false);
		assertEquals(ht.findElement("R2"), "D2");
		assertEquals(ht.findElement("Rat"), null);
		assertEquals(ht.findElement("Mouse"), "Droid");
		ht.delete("Mouse");
		assertEquals(ht.findElement("Mouse"), null);
		
		Iterator<String> klooper = ht.keys();
		Iterator<String> elooper = ht.elements();
		String res = "";
		while (klooper.hasNext()){ 
			res = res + " " + klooper.next() + " " + elooper.next(); 
		}

		assertEquals(res, " R2 D2 C3 P0 BB 8");
		ht.clear();
		assertEquals(ht.size().intValue(), 0);
		assertEquals(ht.isEmpty(), true);
	}
		
	
}


