package sa.edu.yuc;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Hashtable<T> implements Serializable {
	//private T[] values;
	private ArrayList<T>[] values;
	private int size;
	public Hashtable(Class<T> cls) {
		this.size = 1000;
		//this.values = (T[])Array.newInstance(cls, this.size);
		this.values = new ArrayList[size];
		for (int i = 0; i < size; i++)
			this.values[i] = new ArrayList<T>();
	}
	public Hashtable(Class<T> cls, int size) {
		this.size = size;
		//this.values = (T[])Array.newInstance(cls, this.size);
	}
	private static int char2int(char ch) {
		return (int)ch - 64;
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
		return sum % size;
	}		
	public void put(String key, T value) {
		int index = hash2(key);
		values[index].add(value);
	}
	public void delete(String key) {
		int index = hash2(key);
		values[index] = null;
	}
	public T get(String key) {
		int index = hash2(key);
		ArrayList<T> listValues = values[index];
		if(listValues.size() != 0){
			return (T) listValues;
		}
		return null;
	}
	public T[] getValues() {
		return (T[]) this.values;
	}
}