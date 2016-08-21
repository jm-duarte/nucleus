//package processing.rejected;
//import processing.core.PApplet;
//
//public class LineTrigNoise extends PApplet{
//
//	//Variables to increment in draw go here
//	//--------------------------------------
//	private float angle = 0;
//	//--------------------------------------
//	
//	public static void main(String[] args) {
//		PApplet.main("CoverGenerator");
//	}
//	
//	public void settings(){
//		size(1200, 700, P3D);
//		smooth();
//	}
//	
//	public void setup(){
//		background(255, 25);
//		fill(0);
//	}
//	
//	public void draw(){
//		line(width / 2, height / 2, 0, generateXCoord(50, 100, 250), generateYCoord(50, 100, 250), sin(radians(angle)));
//		angle += 0.5;
//	}
//	
//	private float generateXCoord(int minValue, int maxValue, float radius){
//		float center = width / 2;
//		float trigNoise = cos(radians(angle)) + noise(random(50)) - 1;
//		float res = center + (radius * trigNoise)  + noise(random(100)) * 50;
//		System.out.println(res);
//		return res;
//	}
//	
//	private float generateYCoord(int minValue, int maxValue, float radius){
//		float center = height / 2;
//		float trigNoise = sin(radians(angle)) + noise(random(50)) - 1;
//		float res = center + (radius * trigNoise)  + noise(random(100)) * 50;
//		System.out.println(res);
//		return res;
//	}
//}