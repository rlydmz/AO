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
	private boolean hasCollided;
	// Objet permettant de provoquer une animation à temps réguliers
	private AnimationTimer timer;

	public Animation(String title){
	    hasCollided = false;
		ball = new Ball();
		ball2 = new Ball();
		ball2.setVx0(-2);
		ball.setX0(1);
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

    public double distance(Ball b1, Ball b2){
        double dst = Math.sqrt(Math.pow(b1.getX()-b2.getX(),2) + Math.pow(b1.getY()-b2.getY(), 2));
        return dst;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		ball.step();
		ball2.step();
		if(distance(ball, ball2) >= Ball.WIDTH){
		    hasCollided = false;
        }
		if(distance(ball, ball2) <= Ball.WIDTH && hasCollided == false){
		    System.out.println("collision");
		    ball.reverseSpeed();
		    ball2.reverseSpeed();
		    hasCollided = true;
        }
		viewBall.setXY(ball.getX(), ball.getY(),
				Ball.WIDTH, Ball.HEIGHT, 
				Panel.SCALE, Panel.MARGIN);
        viewBall2.setXY(ball2.getX(), ball2.getY(),
                Ball.WIDTH, Ball.HEIGHT,
                Panel.SCALE, Panel.MARGIN);
		viewFrame.panel.repaint();
	}

}
