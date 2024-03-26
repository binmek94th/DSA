import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    int count = 0;
    int[] numbers;
    Array(int size){
        numbers = new int[size];
    }

    public void insert(int value){
        if (numbers.length == count){
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++){
                newItems[i] = numbers[i];
            }
            numbers = newItems;
        }
        numbers[count++] = value;


    }
    public int indexOf(int value){
        for (int i = 0; i < count; i++){
            if(numbers[i] == value){
                return i;
            }
        }
        return -1;
    }
    public void removeAt(int index){
        if(index >= count || index < 0){
            throw new IllegalArgumentException();
        }
        for (int j = index; j < count - 1; j++){
            numbers[j] = numbers[j + 1];
        }
        count--;
    }

    public void print(){
        for(int i = 0; i < count; i++){
            System.out.print(numbers[i]);
            System.out.println();
        }
    }
    public int max(){
        int max = numbers[0];
        for(int i = 1; i < count; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }

        }
        return max;
    }
    public ArrayList<Integer> intersect(Array arr){
         ArrayList<Integer> intersection = new ArrayList<>();
        for(int i = 0; i < count; i++){
            for(int j = 0, size = arr.count; j < size; j++){
                if(numbers[i] == arr.numbers[j]){
                    intersection.add(numbers[i]);
                }
            }
        }
        return intersection;
    }
    public void reverse(){
        int[] reverse = new int[count];
        for(int i = 0; i < count; i++){
            reverse[i] = numbers[count - i - 1];
        }
        numbers = reverse;
    }

    public void insertAt(int index, int item){
        if (numbers.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = numbers[i];
            }
            count++;
            for (int i = count; i > index; i--){
                newItems[i] = newItems[i - 1];
            }
            newItems[index] = item;
            numbers = newItems;
        }
    }
    public int removeElement(int[] nums, int val) {
        int[] deleted = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                continue;
            }
            deleted[j++] = nums[i];
        }
        nums = deleted;
        return j;
    }
}
