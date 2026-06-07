package vehicle_scheduling;

//import java.util.*;

public class Main{
    static int knapsack(int hours,int[] duration,int[] impact) {
        int n=duration.length;
        int[][]  dp=new int[n+1][hours+1];

        for(int i=1;i<=n;i++){
            for(int h=0; h<=hours;h++){
                if(duration[i-1]<=h){
                    dp[i][h]=Math.max(
                            impact[i-1]+dp[i-1][h-duration[i-1]],
                            dp[i-1][h]
                    );
                }else{
                    dp[i][h]=dp[i-1][h];
                }
            }
        }

        return dp[n][hours];
    }

    public static void main(String[] args){

        int depotHours=60;

        int[] duration={4,2,1,4,3,6,1,5,7,6};
        int[] impact={1,9,5,4,9,2,3,5,3,3};

        System.out.println(
                "Maximum Impact = " +knapsack(depotHours,duration,impact)
        );
    }
}