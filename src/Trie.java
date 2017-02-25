import java.util.ArrayList;

/**
 * Created by 1081_1 on 16.02.17.
 */
public class Trie {
    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr0.add(7);
        arr.add(new ArrayList<Integer>());
        arr.add(arr1);
        arr0.set(0,5);
        int p =0;
        arr.set(0,null);
        arr1.add(10);

        System.out.println(arr.get(1).get(0));
    }
}
