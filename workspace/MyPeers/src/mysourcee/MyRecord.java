package mysourcee;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class MyRecord {
	 private TargetDataLine targetLine;
	private String name;
	private String sourcename;
	private Thread thread;
	public MyRecord(String name){
		this.name = name;
	}
	public void startRecord() throws LineUnavailableException{
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
		
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		
		if(!AudioSystem.isLineSupported(info)){
			System.out.println("System not supported");
		}
		
		targetLine = (TargetDataLine)AudioSystem.getLine(info);
		
		targetLine.open();
		
		System.out.println("Starting Recording ...");
		targetLine.start();
		
		thread = new Thread(){
			@Override
			public void run(){
				AudioInputStream audioStream = new AudioInputStream(targetLine);
				File audioFile = new File(sourcename+name+".wav");
				try{
					AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
					}
				catch(IOException e){ e.printStackTrace(); }
				System.out.println("Stopped recording");
			}
		};
		thread.start();
	}
	public void stopRecord(){
		targetLine.stop();
		targetLine.close();
		thread.stop();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	
	
}
