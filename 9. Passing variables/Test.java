public class Test{
	public static void main(String[] args){
		System.out.println("The argument received is " + args[0]);
		int number = Integer.parseInt(args[0]);

		System.out.println("Square of the number received is " + (number * number));
	}
}