/**
 * Custom hashtable that uses generic typing
 * @author Matthew 
 * @version 12/1/25
 */
public class CHashTable<K, V> {
    //Stores capacity and the deleted variable plus size and the table array
    private static final int CAPACITY = 30;
    private static final Entry DELETED = new Entry(null, null);
    private int size;
    private Entry<K, V>[] table;

    //Initializes the table
    public CHashTable() {
        size = 0;
        table = (Entry<K, V>[]) new Entry[CAPACITY];
    }

    /**
     * gets hash key
     * @param key
     * @return int index
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    /**
     * gets the private entry
     * @param i index
     * @return entry
     */
    public Entry<K, V> getEntry(int i) {
        return table[i];
    }

    /**
     * gets value
     * @param i index
     * @return value
     */
    public V getValue(int i) {
        return table[i].value;
    }


    /**
     * searches the table to find the key
     * @param key to search for
     * @return value if found
     */
    public V get(K key) {
        int index = hash(key);
        if(table[index] == null) {
            return null;
        }
        else if(table[index].key != null && table[index].key.equals(key)) {
            return table[index].value;
        }
        else {
            //Uses linear probing to go to the next index if collision
            int i = index + 1;
            int save = index;
            while(true) {
                if(i == save) {
                    return null;
                }
                if(i == CAPACITY) {
                    i = 0;
                }
                if(table[i] == DELETED) {
                    i++;
                    continue;
                }
                if(table[i] == null) {  
                    return null;
                }

                if(table[i].key.equals(key)) {
                    return table[i].value;
                }
                i++;
            }
        }
    }

    /**
     * puts in the key value entry and allows for editing
     * @param key 
     * @param value
     */
    public void put(K key, V value) {
        if(containsKey(key)) {
            int index =  hash(key);
            if(table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            int i = index + 1;
            int save = index;
            while(true) {
                if(i == save) {
                    return;
                }
                if(i == CAPACITY) {
                    i = 0;
                }
                if(table[i] == null) {
                    return;
                }
                if(table[i].key.equals(key)) {
                    table[i].value = value;
                    return;
                }
                i++;
            }
        }
        else {
            int index =  hash(key);
            if(table[index] == null) {
                table[index] = new Entry<K,V>(key, value);
                size++;
                return;
            }
            int i = index + 1;
            int save = index;
            while(true) {
                if(i == save) {
                    return;
                }
                if(i == CAPACITY) {
                    i = 0;
                }
                if(table[i] == null || table[i] == DELETED) {
                    table[i] = new Entry<K,V>(key, value);
                    size++;
                    return;
                }
                i++;
            }

        }

    }

    /**
     * Uses the get function to see if exists
     * @param key
     * @return if true
     */
    public boolean containsKey(K key) {
        if(get(key) != null) {
            return true;
        }
        return false; 
    }

    /**
     * prints the table values
     */
    public void printTable() {
        System.out.println("\n=== Hash Table Contents ===");
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.println("[" + i + "]: empty");
            } else {
                System.out.println("[" + i + "]: " + table[i].key + " -> " + table[i].value);
            }
        }
        System.out.println("===========================\n");
    }

    /**
     * gets capacity
     * @return cap
     */
    public int getSize() {
        return CAPACITY;
    }

    /**
     * removes the key from table and replaces with deleted
     * @param key to delete
     * @return value of deleted
     */
    public V remove(K key) {
        int index = hash(key);
        if(!containsKey(key)) {
            return null;
        }

        if(table[index] != null && table[index] != DELETED && table[index].key.equals(key)) {
            V deleted = table[index].value;
            table[index] = DELETED;
            size--;
            return deleted;
        }

        int i = index + 1;
        int save = index;
        while(true) {
            if(i == save) {
                return null;
            }
            if(i == CAPACITY) {
                i = 0;
            }
            if(table[i] == null) {
                return null;
            }
            if(table[i] != DELETED && table[i].key.equals(key)) {
                V deleted = table[index].value;
                table[i] = DELETED;
                size--;
                return deleted;
            } 
            i++;
        }
        
    }

    /**
     * Generic entry class
     */
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
