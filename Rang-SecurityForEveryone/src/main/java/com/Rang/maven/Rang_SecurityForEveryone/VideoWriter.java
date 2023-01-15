package com.Rang.maven.Rang_SecurityForEveryone;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.github.sarxos.webcam.Webcam;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

public class VideoWriter extends Thread
{
	private Webcam webcam;
	public boolean isRunning = false;
	
	public VideoWriter(Webcam cam)
	{
		webcam = cam;
	}

	void startVideoRecording() throws InterruptedException 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String path = "Captures\\" + dtf.format(now) + ".mp4";
		File saveFile = new File(path);
		
		//Initialize media writer
		IMediaWriter writer = ToolFactory.makeWriter(saveFile.getAbsolutePath());
		//Set video recording size
		Dimension size = webcam.getViewSize();
		writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);
		long start = System.currentTimeMillis();
		for(int i = 0; i<300; i++) 
		{
			System.out.println(i);
			BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
			IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);
			
			IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis()-start) * 1000);
			frame.setKeyFrame(i == 0);
			frame.setQuality(100);
			
			writer.encodeVideo(0, frame);
		}
		writer.close();
		System.out.println("Video recorded to the file: " + saveFile.getAbsolutePath());
		//TextMessage.sendText(App.phoneNum, saveFile.getAbsolutePath());
		isRunning = false;
	}

	@Override
	public void run() 
	{
		try
		{
			isRunning = true;
			startVideoRecording();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
