import java.util.*;
public class KthPermutaion {
    public static void kthPermutaionUtil(int n,int k,ArrayList<Integer> lis,int fact,String[] res){
        if(n==1){
            res[0]+=lis.get(0);    
            return;
        }
        int groups = fact/n;
        res[0]+=lis.get(k/groups);
        lis.remove(k/groups);
        kthPermutaionUtil(n-1,k%groups,lis,groups,res); 
    }
    public static String getPermutation(int n, int k) {
        String[] res = {""};
        ArrayList<Integer> lexographical_list = new ArrayList<Integer>();
        int fact=1;
        for(int i=0;i<n;i++){
            fact=fact*(i+1);
            lexographical_list.add(i+1);
        }
        System.out.println(fact);
        System.out.println(lexographical_list);
        kthPermutaionUtil(n,k-1,lexographical_list,fact,res);
        return res[0];
    } 
    public static void main(String[] args){
        System.out.println(getPermutation(4,17));
    }
}
