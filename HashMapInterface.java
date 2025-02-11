

public interface HashMapInterface<K,V> {

	void add(K key,V value);
	boolean remove(K key) throws EmptyListException;
	boolean contains(K key);
	V get(K key);
}
