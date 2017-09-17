package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class Animation implements ActionListener {

	// Quelques constantes
	public static double GRAVITATION = 12; // acceleration de la gravitation

	private ViewFrame viewFrame;
	private ViewBall viewBall;
	private Panel panel;
	private Ball ball;
	// Objet permettant de provoquer une animation à temps réguliers
	private AnimationTimer timer;

	public Animation(String title){
		ball = new Ball();
		panel = new Panel();
		viewBall = new ViewBall();
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT,
				Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX,
				Panel.SCALE, Panel.MARGIN, viewBall);
		timer = new AnimationTimer(this);
		timer.start();
	}

	public Animation(String title, Ball modelBall) {
		this.ball = modelBall;
		panel = new Panel();
		viewBall = new ViewBall();
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT,
				Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX,
				Panel.SCALE, Panel.MARGIN, viewBall);
		timer = new AnimationTimer(this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.step();
		viewBall.setXY(ball.getX(), ball.getY(),
				Ball.WIDTH, Ball.HEIGHT, 
				Panel.SCALE, Panel.MARGIN);
		viewFrame.panel.repaint();
	}


}
