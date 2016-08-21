package processing;

import processing.core.PApplet;
import processing.core.PVector;

public class CircleElement {
	
	private static final int SIZE_DIVIDER = 6;
	
	private PApplet p;
	private float xCoord;
	private float yCoord;
	private float size;
	private float connectionDistance;
	
	public CircleElement(PApplet p, float xCoord, float yCoord, float size, float connectionDistance) {
		this.p = p;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
		this.connectionDistance = connectionDistance;
	}
	
	public void display(){
		p.smooth();
		p.noStroke();
		
		p.fill(8, 165, 203, p.random(100, 255));
		p.ellipse(xCoord, yCoord, size, size);
		
		p.fill(255, 100);
		p.ellipse(xCoord, yCoord, size / SIZE_DIVIDER , size / SIZE_DIVIDER);
	}
	
	public boolean canConnect(float xCoord, float yCoord){
		return getDistanceToPoint(this.xCoord, this.yCoord, xCoord, yCoord) < connectionDistance;
	}
	
	public void makeConnection(float xCoord, float yCoord){
		p.stroke(137, 193, 50);
		p.strokeWeight(3);
		p.line(this.xCoord, this.yCoord, xCoord, yCoord);
	}
	
	public float getXCoordinate(){
		return xCoord;
	}
	
	public float getYCoordinate(){
		return yCoord;
	}
	
	private float getDistanceToPoint(float startingXCoord, float startingYCoord, float endingXCoord, float endingYCoord){
		 PVector distance = new PVector(endingXCoord - startingXCoord, endingYCoord - startingYCoord);
		 return distance.mag();
	}
}
