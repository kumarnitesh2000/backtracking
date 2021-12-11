import java.util.*;
class Permutation{
    public static void swap(int[] arr,int i,int j){
        int t = arr[i];arr[i] = arr[j];arr[j] = t;
    }
    public static void solution(int index,List<List<Integer>> res,int[] nums){
        if(index==nums.length){
            List<Integer> l = new ArrayList<Integer>();
            for(int n: nums){
                l.add(n);
            }
            res.add(l);
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            solution(index+1,res,nums);
            swap(nums,index,i);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solution(0,res,nums);
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1,2,3});   
        for(List<Integer> r: res){
            System.out.println(r);
        }
    }
}