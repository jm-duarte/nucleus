package processing;

import processing.core.PApplet;

public class FCTCover extends PApplet {

	private static final int PADDING = 20;
	private static final int NUMBER_OF_ELEMENTS = 500;
	private static final int MINIMUM_ELEMENT_SIZE = 30;
	private static final int MAXIMUM_ELEMENT_SIZE = 90;
	private static final int CONNECTION_SIZE = 100;

	private CircleElement[] circles;

	public static void main(String[] args) {
		PApplet.main("processing.FCTCover");
	}

	public void settings() {
		size(2480, 3508);
		smooth();
	}

	public void setup() {
		background(9, 82, 128);
		circles = new CircleElement[NUMBER_OF_ELEMENTS];
		for (int i = 0; i < circles.length; i++) {
			circles[i] = new CircleElement(this, random(PADDING, width - PADDING), random(PADDING, height - PADDING),
					random(MINIMUM_ELEMENT_SIZE, MAXIMUM_ELEMENT_SIZE), CONNECTION_SIZE);
		}
		generateConnections();
	}

	public void draw() {

	}

	public void keyPressed() {
		if (keyCode == ENTER) {
			setup();
		} 
		if (keyCode == BACKSPACE){
			saveFrame("frame###.png");
		}
	}

	private void generateConnections(){
		for (int i = 0; i < circles.length; i++) {
			circles[i].display();
			for (int j = 0; j < circles.length; j++) {
				float endingXCoord = circles[j].getXCoordinate();
				float endingYCoord = circles[j].getYCoordinate();
				if (circles[i].canConnect(endingXCoord, endingYCoord)) {
					circles[i].makeConnection(endingXCoord, endingYCoord);
				}
			}
		}
	}
	
	/*
	 * Perlin Variation To be used with: circles[i] = new CircleElement(this,
	 * coordinateGenerator(width, 100), coordinateGenerator(height,
	 * 100),sizeGenerator(MINIMUM_ELEMENT_SIZE, MAXIMUM_ELEMENT_SIZE,
	 * ELEMENT_SIZE_SEED), CONNECTION_SIZE);
	 * 
	 *  private float coordinateGenerator(float maxValue, float randomSeed) {                   
	 *  	return (noise(random(randomSeed))) * maxValue;                                      
	 *  }                                                                                       
	 *                                                                                          
	 *  private float sizeGenerator(float minimumValue, float maximumValue, float randomSeed) { 
	 *  	return noise(random(randomSeed)) * minimumValue + (maximumValue - minimumValue); 
	 *  }   
	 */                                                                                        
}
