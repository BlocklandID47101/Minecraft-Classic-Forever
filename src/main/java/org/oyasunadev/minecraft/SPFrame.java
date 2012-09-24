package org.oyasunadev.minecraft;

import com.mojang.minecraft.Minecraft;

import javax.swing.*;
import java.awt.*;

public final class SPFrame extends JFrame
{
	public SPFrame()
	{
		setTitle("MinecraftMania - Single Player");
		setSize(854, 480);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Minecraft minecraft;
	private Thread mmThread;

	public void startMinecraft() throws Exception
	{
		MCApplet mcApplet = new MCApplet();
		Canvas canvas = new Canvas();

		//System.out.println(getWidth());
		//System.out.println(getHeight());
		
		if(getWidth() != 132 || getHeight() != 38)
		{
			mcApplet.setBounds(0, 0, getWidth(), getHeight());
		} else {
			System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
			System.out.println(Toolkit.getDefaultToolkit().getScreenSize().height);

			setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
			mcApplet.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

			mcApplet.parameters.put("fullscreen", true);
		}

		minecraft = new Minecraft(canvas, mcApplet, getWidth(), getHeight(), false);

		add(canvas);

		new Thread(minecraft).start();
	}

	public void finish()
	{
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
	}
}