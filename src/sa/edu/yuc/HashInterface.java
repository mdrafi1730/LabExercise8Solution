package sa.edu.yuc;

public interface HashInterface<T> {
	public void put(String key, T value);
	public void getAllValues();
	public T get(String key);

}
