package abstraction;

import java.util.ArrayList;
import java.util.List;
/*
 * this class implements an immutable Stack
 * @rep List<E> elements:{NTSB,FBI,CIA,NSA,CAMEROON}
 */
public class ImmutableStack<E> extends AbstractIBag<E>{

	/*
	 * the observer choose()
	 * the producers get() and getNewBag()
	 * 
	 * Abstraction function is
	 * AF(r)=([r.elements(0),r.elements(1),...,r.elements(size-1)])
	 * 
	 * Representation Invariant is:
	 */
	
	
	public ImmutableStack() {
		// constructor: initializes my Stack by creating an empty one
		this.elements=new ArrayList<E>();
		
	}

	@Override
	public Object choose() throws IllegalStateException {
		// Observer:return an arbitrary element of this(pop the Stack)
		if(this.elements.size()==0) throw new IllegalStateException("the stack is empty");
		List<E> l=new ArrayList<E>(this.elements);
		return l.get(elements.size()-1);
		
	}

	@Override
	public AbstractIBag<E> get() throws IllegalStateException {
		// producer:produces an AbstractIBag equal to  this less the element that choose() selects
		if(this.elements.size()==0) throw new IllegalStateException("the stack is empty");
		List<E> l=new ArrayList<E>(this.elements);
		l.remove(l.size()-1);
		ImmutableStack<E> i=new ImmutableStack<E>();
		i.elements=l;
		return i;
	}

	@Override
	protected AbstractIBag<E> getNewBag() {
		// producer:Produces an empty AbstractIBag; for use by producers
		AbstractIBag<E> s=new ImmutableStack<E>();
		return s;
	}
	public String toString(){
		String s="["+elements.get(0);
		for(int i=1;i<elements.size()-1;i++)
			{s=s+","+elements.get(i);}
		if(elements.size()==1) return s+"]";
		s=s+","+elements.get(elements.size()-1)+"]";
		return s;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	AbstractIBag<Integer> m=new ImmutableStack<Integer>();
		m= m.put(5);
		m= m.put(4);
		m= m.put(3);
		
    System.out.println(m);
	System.out.println(m.choose());*/

	}
	

}