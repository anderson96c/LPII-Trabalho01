import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

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
    }
 
    /**
     * Simulate two bouncing balls
     */
    public void bounce(int n)
    {
	Dimension area = myCanvas.getSize();
		

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

        // crate and show the balls
        BouncingBall ball = new BouncingBall(xStart, 50, 16, Color.blue, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(xStart + 20, 80, 20, Color.red, ground, myCanvas);
        ball2.draw();

        // Make them bounce until both have gone beyond the xLimit.
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= xLimit && ball2.getXPosition() >= xLimit) {
                finished = true;
            }
        }
        ball.erase();
        ball2.erase();
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
