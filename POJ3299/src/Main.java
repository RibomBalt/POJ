import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(;;){			
			String s1=sc.next();
			if(s1.equals("E")){
				break;
			}
			double d1=sc.nextDouble();
			String s2=sc.next();
			double d2=sc.nextDouble();
			double t=Double.NaN,d=Double.NaN,h=Double.NaN;
			
			if(s1.equals("T")){
				t=d1;
			}else if(s1.equals("D")){
				d=d1;
			}else if(s1.equals("H")){
				h=d1;
			}
			
			if(s2.equals("T")){
				t=d2;
			}else if(s2.equals("D")){
				d=d2;
			}else if(s2.equals("H")){
				h=d2;
			}
			new TDH(t,d,h).print();
		}
	}
	
	public static double e(double dewpoint){
		double e=6.11*(Math.pow(2.718281828,(5417.7530*((1.0/273.16)-(1.0/(dewpoint+273.16))))));
		return e;
	}
	
	public static double humidex(double e,double temp){
		double h=(0.5555)*(e-10.0);
		return h+temp;
	}
	public static double td2h(double t,double d){
		return humidex(e(d),t);
	}
	public static double dh2t(double d,double h){
		double e=e(d);
		return h-(0.5555)*(e-10.0);
	}
	public static double th2d(double t,double h){
		double hi=h-t;
		double e=hi/0.5555+10.0;
		return 1.0/(1.0/273.16-Math.log(e/6.11)/5417.7530)-273.16;
	}
}

class TDH{
	double t;
	double d;
	double h;
	public TDH(double t, double d, double h) {
		super();
		if(((Double)t).equals(Double.NaN)){
			this.d=d;
			this.h=h;
			this.t=Main.dh2t(d,h);
		}else if(((Double)d).equals(Double.NaN)){
			this.t=t;
			this.h=h;
			this.d=Main.th2d(t,h);
		}else if(((Double)h).equals(Double.NaN)){
			this.t=t;
			this.d=d;
			this.h=Main.td2h(t,d);
		}
		
	}
	
	public void print(){
		System.out.printf("T %.1f D %.1f H %.1f\n",t,d,h);
	}
}
