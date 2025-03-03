import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(subset(arr));
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubset(arr,0,res,subset);
        return res;
    }

    static void createSubset(int[] arr, int i, List<List<Integer>> res, List<Integer> subset){
        if(i==arr.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        createSubset(arr,i+1,res,subset);

        subset.remove(subset.size()-1);
        createSubset(arr,i+1,res,subset);
    }
}
