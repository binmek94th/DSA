import java.util.HashMap;
import java.util.HashSet;

public class HashTableExcercise {
    public int mostFrequent(int[] arr){
        HashMap<Integer, Integer> table = new HashMap<>();
        for (var element : arr){
            var count = table.getOrDefault(element, 0);
            table.put(element, count + 1);
        }
        var max = 0;
        var large = 0;
        for (var entry : table.entrySet()){
            if(entry.getValue() > max++)
                large = entry.getKey();
        }

        return large;
    }
    public int countPairsWithDiff(int[] arr, int k){
        int numbers = 0;
        HashSet<Integer> table = new HashSet<>();
        for (var element : arr){
            table.add(element);
        }
        for (var entry : table){
            if(table.contains(entry + k))
                numbers++;
        }
        return numbers;
    }

    public int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> table = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (table.containsKey(complement))
                return new int[] {table.get(complement), i};
            table.put(arr[i], i);
        }
        return null;
    }

}
