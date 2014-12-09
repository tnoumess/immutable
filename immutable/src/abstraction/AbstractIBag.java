package abstraction;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractIBag<E> {

	protected List<E> elements;

    // Effects:  produce an AbstractIBag equal to this bagUnion {obj}
    public AbstractIBag<E> put(E obj) {
       AbstractIBag<E> newBag = getNewBag();
       newBag.elements = new ArrayList<E>(this.elements);
       newBag.elements.add(obj);
       return newBag;
    }

    // Effects:  if this is empty throw ISE
    //           else return an arbitrary element of this
    public abstract Object choose() throws IllegalStateException;

    // Effects:  if this is empty throw ISE
    //           else produce an AbstractIBag equal to
    //           this less the element that choose() selects
    public abstract AbstractIBag<E> get() throws IllegalStateException;

    // Effects:  Produce an empty AbstractIBag; for use by producers
    protected abstract AbstractIBag<E> getNewBag();
}