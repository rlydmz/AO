package model;

import controler.Animation;

import static java.lang.Math.round;

public class Ball {

	// Taille de la balle
	public static double WIDTH = 0.35; // 35 cm
	public static double HEIGHT = WIDTH;
	public static double RADIUS = WIDTH/2;
	
	// Masse de la balle
	public static double MASS = 1.0;
	
	// données physiques
	private double x; // position
	private double y;
	private double vx; // vitesse
	private double vy;
	private double ax, ay; // acceleration
	private double x0, y0; // position initiale
	private double vx0; // vitesse initiale
	private double vy0;
	private double fx, fy; // force
	private double t; // temps relatif

	public Ball() {
		fx = 0; // force
		fy = MASS * Animation.GRAVITATION;
		ax = fx / MASS; // acceleration initiale
		ay = fy / MASS; 
		vx0 = vx = 1; // vitesse initiale 1 m/s
		vy0 = vy = 0;
		x0 = x = (Panel.XMIN + Panel.XMAX)/2; // position initiale
		y0 = x = (Panel.YMIN + Panel.YMAX)/2;
		t = 0;
	}
	
	public void step(){
		vx = vx0 + ax * t;
		vy = vy0 + ay * t;
		double t2 = t*t;
		x = x0 + vx0 * t + (ax * t2) / 2;
		y = y0 + vy0 * t + (ay * t2) / 2;
		if(x >= Panel.XMAX - Ball.WIDTH || x <= Panel.XMIN){
			vx0 = -vx;
			vy0 = vy ;
			x0 = x;
			y0 = y;
			t = 0;
		}
		if(y >= Panel.YMAX - Ball.HEIGHT || y <= Panel.YMIN){
			vx0 = vx;
			vy0 = -vy;
			x0 = x;
			y0 = y;
			t = 0;
		}
		t += AnimationTimer.MSSTEP;
	}

    public double getX(){
	    return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getVx(){
        return vx;
    }

    public void setVx(double vx){
        this.vx = vx;
    }

    public double getVy(){
        return vy;
    }

    public void setVy(double vy){
        this.vy = vy;
    }

    public double getAx(){
        return ax;
    }

    public void setAx(double ax){
        this.ax = ax;
    }

    public double getAy(){
        return ay;
    }

    public void setAy(double ay){
        this.ay = ay;
    }

    public double getX0(){
        return  x0;
    }

    public void setX0(double x0){
        this.x0 = x0;
    }

    public double getY0(){
        return  y0;
    }

    public void setY0(double y0){
        this.y0 = y0;
    }

    public double getVx0(){
        return vx0;
    }

    public void setVx0(double vx0){
        this.vx0 = vx0;
    }

    public double getVy0(){
        return vy0;
    }

    public void setVy0(double vy0){
        this.vy0 = vy0;
    }

    public double getFx(){
        return fx;
    }

    public void setFx(double fx){
        this.fx = fx;
    }

    public double getFy(){
        return fy;
    }

    public void setFy(double fy){
        this.fy = fy;
    }

    public double getT(){
        return t;
    }

    public void setT(double t){
        this.t = t;
    }

    public void reverseSpeed(){
            x0 = x;
            y0 = y;
            t = 0;
            vx0 = -vx;
            vy0 = vy;
    }

}
