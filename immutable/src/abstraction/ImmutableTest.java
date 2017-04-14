package abstraction;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ImmutableTest {
	private AbstractIBag<Object> m=new ImmutableBag<Object>();
	private AbstractIBag<Integer> n=new ImmutableQueue<Integer>();
	private AbstractIBag<String> l=new ImmutableStack<String>();

	//exception test
		@Test (expected = IllegalStateException.class)
		public void testGet_ImmutableBag() {
		m.choose();	 	
		}
		
		//test Choose() in Bag Bag
		@Test
		public void testChoose_ImmutableBag() {
			m=   m.put(6);
			m=   m.put("t");
			List<String> l=new ArrayList<String>();
			l.add("agag");
			l.add("MI5");
			m=m.put(l);
			m=m.put(3);
			m=m.put(l);
			m=m.put(9);
			assertEquals(3,m.choose());
		}
			
		@Test
		public void testGet_ImmutableQueue() {
			n=n.put(7);
			n=n.put(9);
			AbstractIBag< Integer> p=new ImmutableStack<Integer>();
			p=n.get();

			assertEquals("[6]",p.toString());// this test fail since p is the new queue without 6.hence [9])

		}

	    //Exception test
		@Test (expected = IllegalStateException.class)
		public void testChoose_ImmutableQueue() {
		assertEquals(5,n.choose()); // exception is raised because choose() on an empty Queue
		}

		//test get() of immutable Stack
	@Test
	public void testGet_ImmutableStack() {
		l=l.put("5");
		l=l.put("9");
		l=l.get();
		assertEquals("[9]",l.toString());// test fail since expected is [5]
	}
	
       //test choose() of immutable stack
	@Test
	public void testChoose_ImmutableStack() {
		l=l.put("5");
		l=l.put("3");
		l=l.put("9");
		assertEquals("3",l.choose());// will fail because choose
	}


       //test choose() of immutable stack again
        @Test
        public void testChoose_ImmutableStack2() {
                l=l.put("4");
                l=l.put("3");
                l=l.put("10");
                assertEquals("3",l.choose());// will fail because choose
        }
       

      //test choose() of immutable stack again again
        @Test
        public void testChoose_ImmutableStack3() {
                l=l.put("4");
                l=l.put("3");
                l=l.put("10");
                assertEquals("3",l.choose());// will fail because choose
        }
}
