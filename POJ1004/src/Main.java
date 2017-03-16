import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double sum=0;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<12;i++){
			sum+=sc.nextDouble();
		}
		System.out.printf("$%.2f\n",(0.005+sum)/12);
	}
}
