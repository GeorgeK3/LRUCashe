


public class CacheImpl<K,V> implements Cache<K,V>{

    long searches=0;
    long found=0;
    long not_found=0;
    int cahcesize;
    HashMap hashtable;
    QueueImpl LRU;

    public CacheImpl(int size){
        this.cahcesize = size;
        LRU = new QueueImpl<K>();
        hashtable = new HashMap<K,V> (size);
    }

    public V lookUp(K key){

        boolean success;

        searches++;

        if (hashtable.contains(key)){
            success = true;
        }else{
            success = false;
        }

        if (success){

            found ++;
            LRU.update(key);
            return (V)hashtable.get(key);

        }else{

            not_found ++;
            return null;

        }
    }
	
	public void store(K key, V value){

        if (hashtable.getsize()<cahcesize){
            hashtable.add(key,value);
            LRU.put(key);
            return ;

        }else{
            K delKey = (K)LRU.get();
            hashtable.remove(delKey);
            
            hashtable.add(key,value);
            LRU.put(key);
            return;

        }
    }

	public double getHitRatio(){
        double hitratio = (double)found/(double)searches;
        return hitratio;
    }
	
	public long getHits(){
        return found;
    }
	
	public long getMisses(){
        return not_found;
    }

	public long getNumberOfLookUps(){
        return searches;
    }
}
