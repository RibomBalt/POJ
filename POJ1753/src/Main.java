import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static final int pattern[]={0xC800,0xE400,0x7200,0x3100,0x8C80,0x4E40,0x2720,0x1310,0x08C8,0x04E4,0x0272,0x0131,0x008C,0x004E,0x0027,0x0013};
	public static final int white=0xFFFF;
	public static final int black=0x0000;
	public static void main(String[] args) throws Exception {
		int initial=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				initial=(initial<<1)+((br.read()==(int)'b')?1:0);
			}
			br.readLine();
		}
		br.close();
		
		HashSet<flip> flipPool=new HashSet<flip>();
		HashSet<flip> prePool=new HashSet<flip>();
		flip first=new flip(initial,0,0);
		if(first.isWin()){
			System.out.println("0");
			return;
		}
		flipPool.add(first);
		for(int i=0;i<9;i++){
			prePool.clear();
			prePool.addAll(flipPool);
			flipPool.clear();
			for(flip f:prePool){
				for(int j=(f.times==0)?0:(1+f.prev%16);j<16;j++){
					flip newFlip=f.generate(j);
					if(newFlip.isWin()){
						System.out.println(f.times+1);
						return;
					}
					flipPool.add(newFlip);
				}
			}
		}
		System.out.println("Impossible");
	}
}

class flip{
	int map;
	int prev;
	int times;
	public flip(int map, int prev,int times) {
		super();
		this.map = map;
		this.prev = prev;
		this.times=times;
	}
	public flip generate(int x) throws Exception{
		if(x>=16){
			throw new Exception("数组越界");
		}
		return new flip(this.map^Main.pattern[x],(this.prev<<4)+x,this.times+1);
	}
	public boolean isWin(){
		return (this.map==Main.black)||(this.map==Main.white);
	}
	public int getTime(){
		return this.times;
	}
}


