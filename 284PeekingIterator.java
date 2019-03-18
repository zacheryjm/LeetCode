// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    int nextVal;
    Boolean hasNext;
    Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
        
        if(!iterator.hasNext()) {
            this.nextVal = -1;
            this.hasNext = false;
            this.iterator = iterator;
        }
        else {
            this.nextVal = iterator.next();
            this.hasNext = true;
            this.iterator = iterator;
        }    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int val = nextVal;
        
        if(iterator.hasNext()) {
            nextVal = iterator.next();     
        }
        else {
            hasNext = false;
        }
        return val;
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}