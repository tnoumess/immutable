package abstraction;

import java.util.ArrayList;
import java.util.List;

/*
 * this class implements an immutable bag that can store different kinds  of object
 * @rep List<E> elements:{MI5,FBI,[5,8,6],people}
 */
public class ImmutableBag<E> extends AbstractIBag<E> {
	/*
	 * the observer choose()
	 * the producers get() and getNewBag()
	 * 
	 * Abstraction function is
	 * AF(r)=([r.elements(0),r.elements(1),...,r.elements(size-1)])
	 * 
	 * Representation Invariant is:
	 */
	
	public  ImmutableBag() {
		// constructor: initializes my bag by creating an empty one
		
		this.elements= new ArrayList<E>();
	
	}

	@Override
	public E choose() throws IllegalStateException { 
		// Observer:return an arbitrary element of this(element in the middle of the list)
		if (elements.size()==0) throw new IllegalStateException("bag is empty");
		return elements.get(elements.size()/2);
	}

	@Override
	public AbstractIBag<E> get() throws IllegalStateException {
		// producer:produces an AbstractIBag equal to  this less the element that choose() selects
		if (elements.size()==0) throw new IllegalStateException("bag is empty");
			List<E> l= new ArrayList<E>(this.elements);
			l.remove(l.size()/2);
			ImmutableBag<E> m=new ImmutableBag<E>();
			m.elements=l;
		return  m;
	}

	@Override
	protected AbstractIBag<E> getNewBag() {
		// producer:Produces an empty AbstractIBag; for use by producers
		AbstractIBag<E> m= new ImmutableBag<E>();
		return   m;
	}


public String toString(){
	String s="{"+this.elements.get(0);
	for(int i=1;i<this.elements.size()-1;i++)
		{s=s+","+elements.get(i);}
	if(elements.size()==1) return s+"}";
	s=s+","+elements.get(elements.size()-1)+"}";
	
	return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
	/*	AbstractIBag<Object> m=new ImmutableBag<Object>();
		m=   m.put(5);
		m=   m.put("o");
		List<String> l=new ArrayList<String>();
		l.add("agag");
		l.add("MI5");
		m=m.put(l);
		m=m.put(3);
		m=m.put(l);
		m=m.put(9);
		System.out.println(m.choose());*/
	}
	
	
	
}