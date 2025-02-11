
public class HashMap<K,V> implements HashMapInterface<K,V> {

	private Data<K, V>[] hashtable; 
	private int size;
	private int curr_size=0;

    static private class Data<K, V> {
        K key;
        V value;
        Data<K, V> next;

        public Data(K key, V value, Data<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap(int arraysize) {
		this.size = arraysize;
        hashtable = new Data[arraysize];
    }

	public int getsize(){
		return curr_size;
	}
    public void add(K key, V data) {
		curr_size++;
        if (key == null)
            return;   
        int hash = hash(key);

        Data<K, V> newEntry = new Data<K, V>(key, data, null);


        if (hashtable[hash] == null) {
            hashtable[hash] = newEntry;
        } else {
            Data<K, V> previous = null;
            Data<K, V> current = hashtable[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) { 
                        newEntry.next = current.next;
                        hashtable[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (hashtable[hash] == null) {
            return null;
        } else {
            Data<K, V> temp = hashtable[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; 
            }
            return null;
        }
    }

	public boolean contains(K key){
		int hash = hash(key);
        if (hashtable[hash] == null) {
            return false;
        } else {
            Data<K, V> temp = hashtable[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return true;
                temp = temp.next; 
            }
            return false;
        }
	}

    public boolean remove(K key) {

        int hash = hash(key);
		curr_size--;
        if (hashtable[hash] == null) {
            return false;
        } else {
            Data<K, V> previous = null;
            Data<K, V> current = hashtable[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) { 
                        hashtable[hash] = hashtable[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }
}
