import java.util.*;
public class GenerateParan {
    public static void dfs(List<String> res,String track,int o,int c,int n){
        if(o==n && c==n){
            String pattern = "";
            for(char p: track.toCharArray())pattern+=p;
            res.add(pattern);
        }
        if(o<n){
            track+='(';
            dfs(res,track,o+1,c,n);
            track = track.substring(0,track.length()-1);
        }
        if(o>c){
            track+=')';
            dfs(res,track,o,c+1,n);
            track = track.substring(0,track.length()-1);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res,new String(""),0,0,n);
        return res;
    }
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for(String s : res)System.out.println(s);
    }
}
