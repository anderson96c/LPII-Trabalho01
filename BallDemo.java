import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - provides a demonstration of the
 * BouncingBall and Canvas classes. 
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2010.11.30
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private ArrayList<BouncingBall> balls;
    
    /**
     * Create a BallDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
	balls = new ArrayList<BouncingBall>();
    }
 
    /**
     * Simulate two bouncing balls
     */
    public void bounce(int n)
    {

	Random rd = new Random();
	Dimension area = myCanvas.getSize();

	//Definindo as possíveis cores
	ArrayList<Color> colors = new ArrayList<Color>();
	colors.add(Color.blue);
	colors.add(Color.red);
	colors.add(Color.black);
	colors.add(Color.pink);
	colors.add(Color.orange);
	colors.add(Color.yellow);
	colors.add(Color.gray);
	
	
	int largura = area.width;
	int altura = area.height;
	
	//O solo ficará 20 pixels acima da parte inferior do retangulo
        int ground = altura - 40;    // position of the ground line
	
	//O solo ficará a 5 pixels das laterais do retangulo 
        int xStart = 25;    	     // x-start of the ground line
        int xLimit = largura - 25;   // x-limit of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(xStart, ground, xLimit, ground);

	for(int i = 0; i<n; i++)
	{
		int left = largura; //determinar a posição da bola mais à esquerda
		//Determinando uma cor aleatória para bola
		int colorIndex = rd.nextInt(6);
		Color ballColor = colors.get(colorIndex);
		//Determinando altura e largura onde ela pode aparecer
		int ballWidth = rd.nextInt(largura);
		int ballHeight = rd.nextInt(altura/2);
		//Determinando o tamanho da bola
		int ballDiameter = rd.nextInt(60);

		//Instaciando a nova bola
		BouncingBall newBall = new BouncingBall(ballWidth, ballHeight, ballDiameter, ballColor, ground, myCanvas);
		
		//Adicionando a bola no ArrayList
		balls.add(newBall);
		
		//Desenhando a nova bola no canvas
		newBall.draw();
	}

	


        boolean finished =  false;
	int i;
        while(!finished) {
            myCanvas.wait(50);           // small delay
	    for(i = 0; i<n; i++)
	    {
		//Fazendo cada bola se mover
		BouncingBall b = balls.get(i);
		b.move();
		
		//Apagar as bolas quando chegarem no final
		if(b.getXPosition() >= xLimit)
		{	
			b.erase(); 
		}
		
		//Finalizar quando a ultima bola chegar ao final
		if(i == n && b.getXPosition() >= xLimit)
           	{    
			finished = true; 
	    	}
	    }
        }
    }

	public void drawFrame()
	{
		//Definindo a dimensao do canvas
		Dimension area = myCanvas.getSize();
		

		/**
		* Como o retangulo tera 20 de distancia das bordas, 
		* ele terá 40 pixels a menos de altura e largura
		*/
		int largura = (area.width - 40);
		int altura = (area.height - 40);

		/**
		* Agora utilizamos a altura e a largura para definir o retangulo
		* contido dentro do canvas a 20 pixels da borda
		* Para isso basta inicia-lo a 20 pixels à direita e 20 pixel abaixo
		*/

		Rectangle retangulo = new Rectangle(20 , 20, largura, altura);
	
		//Apagar qualquer retangulo desenhado no canvas
		myCanvas.erase();

		//Desenhar o retangulo
		myCanvas.draw(retangulo);

		
		
	}
    
}
