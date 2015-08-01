package Practice;

public class ThreadApple {

	public static void main(String[] args) {
		Basket bk=new Basket();
		Producer p=new Producer(bk);
		Consumer c=new Consumer(bk);
		new Thread(p).start();
		new Thread(c).start();

	}

}

class Apple{
	int id=0;
	Apple(int id){
		this.id=id;
	}
	public String toString(){
		return "Apple["+id+"]";
	}
}

class Basket{
	int index=0;
	Apple[] apple=new Apple[6];

	public synchronized void putApple(Apple ap){
		if(index==apple.length){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notify();
		apple[index]=ap;
		index++;
	}

	public synchronized Apple getApple(){
		if(index==0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return apple[index];
	}
}

class Producer implements Runnable{
	Basket bk=null;
	public Producer(Basket bk){
		this.bk=bk;
	}
	public synchronized void run(){
		for(int i=0;i<10;i++){
			Apple ap=new Apple(i);
			bk.putApple(ap);
			System.out.println("Product:"+ap);
			try{
				Thread.sleep((int)(Math.random()*800));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	Basket bk=null;
	public Consumer(Basket bk){
		this.bk=bk;
	}
	public synchronized void run(){
		for(int i=0;i<10;i++){
			Apple ap=bk.getApple();
			System.out.println("eat :"+ap);
			try{
				Thread.sleep((int)(Math.random()*1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
