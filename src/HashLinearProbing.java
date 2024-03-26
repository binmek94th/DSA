public class HashLinearProbing {

    Entry[] table;
    private class Entry{
        int key;
        String value;

        Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    int count = 0;

    public HashLinearProbing(int size){
        table = new Entry[size];
    }

    public void put(int key, String value){
        if (isFull()) throw new IllegalStateException();

        Entry entry = new Entry(key, value);

        int i = getIndex(key);

        table[i] = entry;
        count++;
    }

    private int getIndex(int key){
        int i = calculateIndex(key);
        while (table[i] != null) {
            i++;
            if (i > table.length)
                i = 0;
        }
        return i;
    }

    public String get(int key){
        int i = calculateIndex(key);
        while (true) {
            if (table[i] == null) throw new IllegalStateException();

            if (table[i].key == key)
                return table[i].value;
            i++;
        }
    }


    public void remove(int key){
        int i = getIndex(key);
        table[i] = null;
        count--;
    }

    public int size(){
        return count;
    }

    private boolean isFull(){
        return count == table.length;
    }

    private int calculateIndex(int key){
        return key % table.length;
    }

    //put(int, string)
    //get(int)
    //remove(int)
    //size
}
