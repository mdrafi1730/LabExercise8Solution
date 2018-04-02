package sa.edu.yuc;

public class HashNode<T> {
	T word;
	HashNode<T> next;
	public HashNode(T t){
		this.word= t;
		this.next = null;
	}

}
