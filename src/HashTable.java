import java.util.LinkedList;


public class HashTable {

    int size = 5;
    private final LinkedList<Entry>[] entries = new LinkedList[size];

    private class Entry{
        int key;
        String value;

        Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }


    private int hash(int key){
        return key % size;
    }

    public void put(int key, String value){
        var entry = getEntry(key);
        if (entry != null){
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).addLast(new Entry(key,value));

    }

    public String get(int key){
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key){
        var entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if (bucket != null){
            for (var entry : bucket){
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket = entries[index];
    }
    
}
