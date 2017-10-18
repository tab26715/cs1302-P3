package cs1302.p3;
/**
 * ArrayList is a generic class that implements the List interface.
 * It provides a way to store any object in an array of boxes which 
 * contain the element
 *
 * @author Ty Burns   tab26715@uga.edu
 */
public class ArrayList<T> implements List<T>{
	private Box<T>[] array;
	private int arraySize;
	
	/**
	 * Default constructor for the ArrayList class. Creates an array 
	 * of 10 boxes.
	 * 
	 */
	public ArrayList(){
		setArraySize(0);
		array = Box.array(10);
	}//ArrayList Constructor
	public ArrayList(int size){
		setArraySize(size);
		array = Box.array(size);
	}//ArrayList Constructor 
	
	/**
	 * clears the array by setting every element to null
	 */
	@Override
    public void clear(){
		for(int i=0;i<array.length;i++){
			array[i].set(null);
		}
    }//clear
	/**
	 * Adds a specified element to the end of an arrayList.
	 * Does so by creating a temporary array of length+1, copying
	 * over every element into the temporary, then adding the new 
	 * element to the final index of the temp. Finally, the original 
	 * array is reassigned to the temporary.
	 * 
	 * @param elem element to be appended
	 * @throws NullPointerException if elem is null
	 */
	@Override
	public void add(T elem) throws NullPointerException {
		// TODO Auto-generated method stub
		if (elem == null) throw new NullPointerException("Element cannot be null");
		Box<T>[] temp = Box.array(array.length+1);
		for(int i=0;i<=array.length;i++){
			if(i==array.length){
				temp[i].set(elem);
			}
			else{
				temp[i].set(array[i].get());
			}
		}
		arraySize++;
		array = temp;
	}//add
	
	/**
	 * {@inheritDoc}
	 */
	@Override 
	public void add(int index, T elem) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (elem == null) throw new NullPointerException("Element cannot be null");
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index cannot be outside of the existing list");
		Box<T>[] temp = Box.array(array.length+1);
		for(int i=0;i<array.length;i++){
			if(i == index){
				temp[i].set(elem);
			}
			else if(i < index){
				temp[i].set(array[i].get());
			}
			else{
				temp[i+1].set(array[i].get());
			}	
		}
		arraySize++;
		array = temp;
	}//add
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index cannot be outside of the existing list");
		else{
			return array[index].get();
		}
	}//get
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T set(int index, T elem) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index cannot be outside of the existing list");
		if (elem == null) throw new NullPointerException("Element cannot be null");
		Box<T>[] temp = Box.array(array.length+1);
		for(int i=0;i<=array.length;i++){
			temp[i].set(array[i].get());
		}
		array[index].set(elem);
		return temp[index].get();
	}//set
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return arraySize;
	}//size
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(array.length==0){
			return true;
		}
		for(int i=0;i<array.length;i++){
			if(array[i].get() != null){
				return false;
			}
		}
		return true;
	}//isEmpty
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(T elem) throws NullPointerException {
		// TODO Auto-generated method stub
		if (elem == null) throw new NullPointerException("Element cannot be null");
		for(int i=0;i<array.length;i++){
			if(array[i].equals(elem)){
				return true;
			}
		}
		return false;
	}//contains
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(T elem) throws NullPointerException {
		// TODO Auto-generated method stub
		if (elem == null) throw new NullPointerException("Element cannot be null");
		int n=0;
		boolean removed = false;
		Box<T>[] temp = Box.array(array.length-1);
		for(int i=0; i<array.length;i++){
			if(n==0){
				if(array[i].equals(elem) && n==0){
					i++;
					n=1;
					removed = true;
				}
				if(n==1){
					temp[i-1].set(array[i].get());
				}
				temp[i].set(array[i].get());
			}
		}
		arraySize--;
		array = temp;
		return removed;
	}//remove
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(T elem) throws NullPointerException {
		// TODO Auto-generated method stub
		if (elem == null) throw new NullPointerException("Element cannot be null");
		for(int i=0;i<array.length;i++){
			if((array[i].get()).equals(elem)){
				return i;
			}
		}
		return -1;
	}//indexOf
	
	public int getArraySize() {
		return arraySize;
	}
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	
	/**
	 * Increases the size of the current array
	 * @param newSize Size of the resized array
	 */
	public void increaseSize(int newSize){
		Box<T>[] temp = Box.array(newSize);
		for(int i=0;i<=array.length;i++){
			temp[i].set(array[i].get());
		}
		arraySize = newSize;
		array = temp;
	}//increaseSize

}//ArrayList