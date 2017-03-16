import java.util.Scanner;

public class Main {
//	public static double[] dp=null;
	public static void main(String[] args) {
//		dp=new double[600];
		Scanner sc=new Scanner(System.in);
		double d=sc.nextDouble();
		for(;;d=sc.nextDouble()){
			if(d==0.00){
				return;
			}
			double sum=0;
			for(int i=1;;i++){
				sum+=1.0/(i+1);
				if(sum>=d){
					System.out.println(i+" card(s)");
					break;
				}
			}
		}
	}
	public static double calc(int n){
		double sum=0;
		for(int i=2;i<=n+1;i++){
			sum+=1.0/i;
		}
		return sum;
	}
}
