import java.util.Scanner;
public class Main
{
	public static void main(String [] args)
	{
		BallDemo b = new BallDemo();

		Scanner scan = new Scanner(System.in);

		System.out.println("Quantas bolas?");
				
		int n = scan.nextInt();

		while(n<0)
		{
			System.out.println("Insira um valor válido");
			n = scan.nextInt();
		}
		

		b.drawFrame();
		b.bounce(n);
	}
}
