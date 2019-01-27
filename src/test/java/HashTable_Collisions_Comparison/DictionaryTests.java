package HashTable_Collisions_Comparison;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Iterator;

public class DictionaryTests {

	@Test
	public void test() {
		IDictionary<String, String> d = new Dict<String, String>();
		assertEquals(d.isEmpty(), true);
		d.insert("Count", "Dooku"); //Marco
		d.insert("Chancellor", "Palpatine"); //Kirk
		d.insert("General", "Grevious"); //Janeway
		d.insert("Darth", "Maul"); //Torres
		assertEquals(d.isEmpty(), false);
		assertEquals(d.size().intValue(), 4);
		assertEquals(d.findElement("Count"), "Dooku");
		assertEquals(d.findElement("Darth"), "Maul");
		assertEquals(d.findElement("Jango"), null);
		d.delete("Count");
		assertEquals(d.findElement("Count"), null);
		assertEquals(d.size().intValue(), 3);
		d.clear();
		assertEquals(d.size().intValue(), 0);
		assertEquals(d.isEmpty(), true);
		
		IDictionary<String, String> e = new Dict<String, String>();

		e.insert("Count", "Dooku");
		e.insert("Chancellor", "Palpatine");
		e.insert("General", "Grevious");
		e.insert("Darth", "Maul");
		
		e.delete("Count");
		
		Iterator<String> klooper = e.keys();
		Iterator<String> elooper = e.elements();
		String res = ""; // res = to empty string list. 
		while (klooper.hasNext()){ // while the hash table key array list has a next time
			res = res + " " + klooper.next() + " " + elooper.next(); // append res to empty string list, and the next item
			// in the key array list, appended to the next item in the element array list. 
			
			// TERMINATION ARGUEMENT: the loop terminates when there is no next item in the list. 
		}
		assertEquals(res, " Chancellor Palpatine General Grevious Darth Maul");
	}
}


