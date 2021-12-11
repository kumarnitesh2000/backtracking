import java.util.*;
public class PalindromePartitioning {
    public static boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++; end--;
        } 
        return true;
    }
    public static void rec(String s,ArrayList<ArrayList<String>> res,ArrayList<String> trace){
        if(s.equals("")){
            ArrayList<String> partition = new ArrayList<String>();
            for(String str: trace)partition.add(str);
            res.add(partition);
            return;
        }
        for(int i=1;i<=s.length();i++){
            String fisrt_part = s.substring(0,i);
            String second_part = s.substring(i,s.length());
            if(isPalindrome(fisrt_part)){
                trace.add(fisrt_part);
                rec(second_part,res,trace);
                trace.remove(trace.size()-1);
            }
        }
    }
    public static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        rec(S,res,new ArrayList<String>());
        return res;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<String>> res = allPalindromicPerms("aabb");
        for(ArrayList<String> partition: res)System.out.println(partition);
    }
}
