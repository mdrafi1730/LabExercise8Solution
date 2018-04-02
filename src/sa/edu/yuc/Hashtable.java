package sa.edu.yuc;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Hashtable<T extends Comparable<T>> implements Serializable, HashInterface<T> {
	//private T[] values;
	private ArrayList<HashNode<T>> values;
	private int maxSize;
	private int currentSize;
	public Hashtable(Class<T> cls) {
		this.maxSize = 11;
		this.values = new ArrayList<>();
		//this.values = (T[])Array.newInstance(cls, this.maxSize);
		/*this.values = new ArrayList[size];*/
		for (int i = 0; i < maxSize; i++)
			this.values.add(null);
	}
	public Hashtable(Class<T> cls, int size) {
		this.maxSize = size;
		//this.values = (T[])Array.newInstance(cls, this.size);
	}
	private static int char2int(char ch) {
		return (int)ch - 64;
	}
	public int getCurrentSize(){
		return currentSize;
	}
	public boolean isEmpty(){
		return (currentSize == 0);
	}
	@SuppressWarnings("unused")
	private int hash(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int num = char2int(ch);
			sum += num;
		}
		return sum;
	}
	public int hash2(String str) {
		int sum = 0;
		int exp = 1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			//int num = char2int(ch) * (int)Math.pow(26.0, i);
			int num = char2int(ch) * exp;
			sum += num;
			exp = exp * 26;
		}
		return sum % maxSize;
	}	
	@Override
	public void put(String key, T meaning) {
		int index = hash2(key);
		HashNode<T> current = this.values.get(index);
		while(current != null){
			current = current.next;
		}
		currentSize++;
		HashNode<T> newNode = new HashNode<T>(meaning);
		current = this.values.get(index);
		newNode.next = current;
		this.values.set(index, newNode);
	}
	public void delete(String key) {
		int index = hash2(key);
		//values[index] = null;
	}
	public T get(String key) {
		/*int index = hash2(key);
		ArrayList<T> listValues = values[index];
		if(listValues.size() != 0){
			return (T) listValues;
		}*/
		int index = hash2(key);
		HashNode<T> current = this.values.get(index);
		if(current == null){
			return null;
		}else{
			return (T) values.get(index);
		}
		
		
	}
	@Override
	public void getAllValues() {
		System.out.println("Index\tWord\t    Meaning");
		for(int i = 0; i < maxSize; i++){
			 if(this.values.get(i) != null){
				 HashNode<T> current = this.values.get(i);
				 System.out.print(i + "\t " + ((Word) current.word).getWord() + "\t  ");
				 while(current != null){
					 System.out.print(((Word) current.word).getMeaning() + "--> ");
					 current = current.next;
				 }
				 System.out.println("Null");
				 //System.out.println();
			 }
		 }
	}
}