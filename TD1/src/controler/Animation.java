package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Animation implements ActionListener {

	// Quelques constantes
	public static double GRAVITATION = 12; // acceleration de la gravitation

	private ViewFrame viewFrame;
	private ViewBall viewBall;
	private ViewBall viewBall2;
	private Panel panel;
	private Ball ball;
	private Ball ball2;
	// Objet permettant de provoquer une animation à temps réguliers
	private AnimationTimer timer;

	public Animation(String title){
		ball = new Ball();
		ball2 = new Ball();
		ball2.setX(4);
		ball2.setX0(4);
		ball.setVx(2);
		ball.setVx0(2);
		panel = new Panel();
		viewBall = new ViewBall();
		viewBall2 = new ViewBall();
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT,
				Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX,
				Panel.SCALE, Panel.MARGIN, viewBall, viewBall2);
		timer = new AnimationTimer(this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.step();
		ball2.step();
		System.out.println("DIFF = " + (ball.getX()-ball2.getX()));
		testCollision(ball, ball2);
		viewBall.setXY(ball.getX(), ball.getY(),
				Ball.WIDTH, Ball.HEIGHT, 
				Panel.SCALE, Panel.MARGIN);
        viewBall2.setXY(ball2.getX(), ball2.getY(),
                Ball.WIDTH, Ball.HEIGHT,
                Panel.SCALE, Panel.MARGIN);
		viewFrame.panel.repaint();
	}

	public void testCollision(Ball b1, Ball b2){
	    if(round(b1.getX(),1) == round(b2.getX(),1)){
	        b1.setVx(5);
        }
    }


}
