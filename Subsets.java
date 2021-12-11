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
    // subset sum problem
    public static void solution(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> path,int[] arr,int sum,int n){
        if(sum==0){
            ArrayList<Integer> lis = new ArrayList<Integer>();
            for(Integer p: path)lis.add(p);
            res.add(lis);
            return;
        }
        if(n==0)return;
        path.add(arr[n-1]);
        solution(res, path,arr,sum-arr[n-1],n-1);
        path.remove(path.size()-1);
        solution(res, path,arr,sum,n-1);
    }
    public static ArrayList<ArrayList<Integer>> allSubsetsSum(int[] arr,int sum){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solution(res,new ArrayList<Integer>(),arr,sum,arr.length);
        return res;
    }
    public static void main(String[] args){
        // List<List<Integer>> result = subsets(new int[]{1,2,3});
        // for(List<Integer> l: result){
        //     System.out.println(l);
        // }
        // subset sum
        ArrayList<ArrayList<Integer>> res = allSubsetsSum(new int[]{1,5,11,5},11);
        for(ArrayList<Integer> r : res){
            System.out.println(r);
        }
    }
}
