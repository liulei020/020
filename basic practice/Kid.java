package Practice;

public class Kid {

	/**
	 ��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӡ�

	 �������Ӷ���������ÿ���µ���������Ϊ���٣��0�2
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
			System.out.println("��"+(j+1)+"�£����¹���"+(2*rabbit[j])+"ֻ����");
		}

	}

}
