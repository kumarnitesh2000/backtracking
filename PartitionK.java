public class PartitionK {
    // equal subset sum
    public static boolean solution(int[] a,int k,int index,int[] subset_sum,int ssf,int set_sum){
        if(index==a.length){
            if(ssf==k){
                for(int sum_k: subset_sum){
                    if(sum_k!=set_sum){
                        return false;
                    }
                }
                return true; 
            }
            return false;
        }
        for(int i=0;i<k;i++){
            if(i<ssf){
                subset_sum[i]+=a[index];
                boolean res = solution(a,k,index+1,subset_sum,ssf,set_sum);if(res)return res;
                subset_sum[i]-=a[index];
            }else{
                subset_sum[i]+=a[index];
                boolean res = solution(a,k,index+1,subset_sum,ssf+1,set_sum);if(res)return res;
                subset_sum[i]-=a[index];
                break;
            }
        }
        return false;
    }
    public static boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum = 0;
        for(int i: a)sum+=i;
        if(n==0 || k==0 || k>n || sum%k!=0)return false;
        if(k==1)return true;
        int[] subset_sum = new int[k];
        return solution(a,k,0,subset_sum,0,sum/k);
    }
    //number of partition for k subsets
    public static int countP(int n, int k)
    {
       // Base cases
       if (n == 0 || k == 0 || k > n)
        return 0;
       if (k == 1 || k == n)
        return 1;
       // S(n+1, k) = k*S(n, k) + S(n, k-1)
       return (k * countP(n - 1, k)+ countP(n - 1, k - 1));
    }
    //maximum number formed after k swaps
    public static void swap(char[] arr,int i,int j){
        char t = arr[i];arr[i] = arr[j];arr[j] = t;
    }
    public static void findMaximumNumUtil(char[] arr,int k,String[] max){
        if(k==0)return;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] > arr[i]){
                    // swap
                    swap(arr,i,j);
                    // check for max
                    String str = new String(arr);
                    if(max[0].compareTo(str) < 0)max[0] = str;
                    findMaximumNumUtil(arr,k-1,max);
                    // backtrack
                    swap(arr,i,j);
                }
            }
        }
    }
    public static String findMaximumNum(String str, int k)
    {
        String[] max = new String[1];max[0] = str;
        findMaximumNumUtil(str.toCharArray(),k,max);
        return max[0];   
    }
    public static void main(String[] args){
        System.out.println(findMaximumNum("2314",2));
        System.out.println(isKPartitionPossible(new int[]{5,4,4,7},2,3));
        System.out.println(countP(3,2));// 1,2 | 3 ; 1,3 | 2 ; 1,23;
    }
}
