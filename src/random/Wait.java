package random;
public class Wait {
	
	public static void main(String args[]){
		String s = "hello there";
		for(int i = 0; i < s.length(); i++){
			System.out.print(s.charAt(i));
			try {
			    Thread.sleep(50);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}

}