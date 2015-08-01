package Practice;

public class Kid {

	/**
	 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子。

	 假如兔子都不死，问每个月的兔子总数为多少？ 
	 */

	public static void main(String[] args) {
		int maxmonth=12;
		int[] rabbit=new int[maxmonth];
		rabbit[0]=1;
		rabbit[1]=1;
		for(int i=2;i<maxmonth;i++){
			rabbit[i]=rabbit[i-1]+rabbit[i-2];
		}
		for(int j=0;j<maxmonth;j++){
			System.out.println("第"+(j+1)+"月，本月共有"+(2*rabbit[j])+"只兔子");
		}

	}

}
