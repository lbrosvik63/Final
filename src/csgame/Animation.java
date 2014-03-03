package csgame;

import java.awt.Image;
import java.util.ArrayList;

public class Animation {

	private ArrayList frames;//contain AnimFrame objects have 2 values: an image, a duration its displayed
	private int currentFrame;//value index of current frame in arraylist
	private long animTime;
	private long totalDuration;//amount of time each frame(image) will be displayed for
	
	public Animation() {
		frames = new ArrayList();
		totalDuration = 0;
		
		synchronized(this){//threads: will be called sequentially(together)
			animTime =0;
			currentFrame =0;
		}
	}

	public synchronized void addFrame(Image image, long duration){
		totalDuration += duration;
		frames.add(new AnimFrame(image, totalDuration));
	}
	
	public synchronized void update(long elapsedTime){
		if(frames.size()>1){
			animTime += elapsedTime;
			if(animTime >= totalDuration){
				animTime = animTime % totalDuration;
				currentFrame = 0;
			}
			
			while (animTime > getFrame(currentFrame).endTime){
				currentFrame++;
			}
		}
	}
	
	public synchronized Image getImage(){
		if(frames.size() == 0){
			return null;
		}else{
			return getFrame(currentFrame).image;
		}
	}
	
	private AnimFrame getFrame(int i){
		return (AnimFrame)frames.get(i);
	}
	
	private class AnimFrame{
		
		Image image;
		long endTime;
		
		public AnimFrame(Image image, long endTime){
			this.image = image;
			this.endTime = endTime;
		}
		
	}//end AnimFrame class
	
}
