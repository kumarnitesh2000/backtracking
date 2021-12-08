import java.util.*;
public class Subsets {
    public static void subsetsUtil(int[] nums,List<Integer> lis,int index,List<List<Integer>> res) {
        if(index==nums.length){
            return;
        }
        for(int i=index+1; i<nums.length; i++) {
            lis.add(nums[i]);
            List<Integer> lis_copy = new ArrayList<Integer>();
            for(Integer l: lis)lis_copy.add(l);
            res.add(lis_copy);
            subsetsUtil(nums,lis,i,res);
            lis.remove(lis.size()-1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();res.add(new ArrayList<Integer>());
        subsetsUtil(nums,list,-1,res);
        return res;
    }
    public static void main(String[] args){
        List<List<Integer>> result = subsets(new int[]{1,2,3});
        for(List<Integer> l: result){
            System.out.println(l);
        }
    }
}
