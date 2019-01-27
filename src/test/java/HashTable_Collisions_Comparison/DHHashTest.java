package HashTable_Collisions_Comparison;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Iterator;
public class DHHashTest{

    HashComparator<String> scomp = new StringComparator();
	DHHash<String, String> ht = new DHHash<String, String>(101, scomp);

	@Test
	public void testHT() {
		assertEquals(ht.size().intValue(), 0); 
		assertEquals(ht.isEmpty(), true);
		assertEquals(ht.findElement("Anakin"), null);
		ht.insert("Anakin", "Skywalker"); //Marco
		ht.insert("Master", "Yoda"); //Olson
		ht.insert("Mace", "Windu"); //Picard
		ht.insert("ObiWan", "Kenobi"); //Janeway
		assertEquals(ht.size().intValue(), 4);
		assertEquals(ht.isEmpty(), false);
		assertEquals(ht.findElement("Anakin"), "Skywalker");
		assertEquals(ht.findElement("Obi"), null);
		assertEquals(ht.findElement("ObiWan"), "Kenobi");
		ht.delete("ObiWan");
		assertEquals(ht.findElement("ObiWan"), null);
		
		Iterator<String> klooper = ht.keys();
		Iterator<String> elooper = ht.elements();
		String res = ""; // res equal to empty string list. 
		while (klooper.hasNext()){ // while the hash table key array list has a next item, it will continuously loop 
			res = res + " " + klooper.next() + " " + elooper.next(); // res equals res added to the empty string list, added to the next
			// item in the hash table key array list, added to the hash table element array list. 
			
			// TERMINATION ARUGEMENT: the loop terminates if there is no next item in the array list. 
		}

		assertEquals(res, " Master Yoda Anakin Skywalker Mace Windu");
		ht.clear();
		assertEquals(ht.size().intValue(), 0);
		assertEquals(ht.isEmpty(), true);
		}
		
}