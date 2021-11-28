import java.util.*;
public class CombinationalSum {
    static void dfs(int index,int target,ArrayList<Integer> A,ArrayList<Integer> comb,ArrayList<ArrayList<Integer>> res){
        if(index==A.size()){
            if(target==0){
                res.add(new ArrayList<Integer>(comb));
            }
            return;
        }
        int element = A.get(index);
        // include
        if(target >= element){
            comb.add(element);
            dfs(index,target-element,A,comb,res);
            comb.remove(comb.size()-1);
        }
        //exclude
        dfs(index+1,target,A,comb,res);
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashSet<Integer> hs = new HashSet<>();
        for(Integer i: A)hs.add(i);
        ArrayList<Integer> arr = new ArrayList<Integer>(hs);
        Collections.sort(arr);
        dfs(0,B,arr,new ArrayList<Integer>(),res);
        return res;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = combinationSum(new ArrayList<Integer>(Arrays.asList(2,5,7)),7);
        for(ArrayList<Integer> r: res){
            System.out.println(r);
        }
    }   
}
