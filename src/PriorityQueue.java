import java.util.Arrays;

public class PriorityQueue {
    int[] queue = new int[5];
    int size = 0;

    public void insert(int value){

        if(isEmpty()){
            queue[size++] = value;
            return;
        }
        if(isFull())
            enlarge();

        int i = shiftItemsToInsert(value);
        queue[i] = value;
        size++;

    }

    public int shiftItemsToInsert(int value){
        int i;
        for (i = size - 1; i >= 0; i--){
            if(queue[i] > value)
                queue[i + 1] = queue[i];
            else
                break;
        }
        return i + 1;
    }

    public boolean isFull(){
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enlarge(){
        int[] temp = new int[size * 2];
        for(int i = 0; i < size; i++)
            temp[i] = queue[i];
        queue = temp;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        return queue[--size];
    }

    @Override
    public String toString(){
       return Arrays.toString(queue);
    }
}
