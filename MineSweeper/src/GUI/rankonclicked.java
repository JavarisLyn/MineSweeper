package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;




class rankonclicked implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
		JFrame rankframe = new JFrame("选择难度");
		
		JButton easy = new JButton("ROOKIE");
		JButton media = new JButton("PRO");
		JButton hard = new JButton("STAR");
		JButton master = new JButton("MASTER");
		
		easy.setFocusPainted(false);
		media.setFocusPainted(false);
		hard.setFocusPainted(false);
		master.setFocusPainted(false);
		
		rankframe.setLayout(null);
		rankframe.setSize(190,430);
		rankframe.setVisible(true);
		
		easy.setBounds(0, 0, 190, 100);
		media.setBounds(0, 100, 190, 100);
		hard.setBounds(0, 200, 190, 100);
		master.setBounds(0, 300, 190, 100);
		
		easy.addActionListener(new easy(rankframe));
		hard.addActionListener(new hard(rankframe));
		media.addActionListener(new media(rankframe));
		master.addActionListener(new master(rankframe));
		
		rankframe.add(easy);
		rankframe.add(media);
		rankframe.add(hard);
		rankframe.add(master);
		
		Color b1Color = new Color(255, 228, 196);
		easy.setBackground(b1Color);
		media.setBackground(b1Color);
		hard.setBackground(b1Color);
		master.setBackground(b1Color);
		
		easy.setBorder(new BevelBorder(BevelBorder.RAISED));
		media.setBorder(new BevelBorder(BevelBorder.RAISED));
		hard.setBorder(new BevelBorder(BevelBorder.RAISED));
		master.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		easy.setFocusPainted(false);
		media.setFocusPainted(false);
		hard.setFocusPainted(false);
		master.setFocusPainted(false);
		
		easy.setFont(new Font(null, Font.BOLD, 30));
		media.setFont(new Font(null, Font.BOLD, 30));
		hard.setFont(new Font(null, Font.BOLD, 30));
		master.setFont(new Font(null, Font.BOLD, 30));
		
		int windowWidth = main.sMainUI.frame.getWidth();                     //获得窗口宽        
		int windowHeight = main.sMainUI.frame.getHeight();                   //获得窗口高        
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包      
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸       
		int screenWidth = screenSize.width;                     //获取屏幕的宽        
		int screenHeight = screenSize.height;                   //获取屏幕的高        
		rankframe.setLocation(screenWidth/2-windowWidth/2+160, screenHeight/2-windowHeight/2+50);
	}

}

class easy implements ActionListener
{
	public JFrame eFrame = new JFrame();
	public easy(JFrame frame) {
		// TODO Auto-generated constructor stub
			eFrame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.board.rank=(float)0.1;
		eFrame.dispose();
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
		
		main.isrun=false;
		main.isrun=true;
		Runnable tRunnable = new timerun();
		Thread thread = new Thread(tRunnable);
		thread.start();
		
		//main.startime=System.currentTimeMillis();
	}
	
}

class media implements ActionListener
{
	public JFrame eFrame = new JFrame();
	public media(JFrame frame ) {
		// TODO Auto-generated constructor stub
		
		eFrame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.board.rank=(float)0.2;
		eFrame.dispose();
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
		
		main.isrun=false;
		main.isrun=true;
		Runnable tRunnable = new timerun();
		Thread thread = new Thread(tRunnable);
		thread.start();
	}
	
}

class hard implements ActionListener
{
	public JFrame eFrame = new JFrame();
	public hard(JFrame frame) {
		eFrame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.board.rank=(float)0.3;
		eFrame.dispose();
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
		
		main.isrun=false;
		main.isrun=true;
		Runnable tRunnable = new timerun();
		Thread thread = new Thread(tRunnable);
		thread.start();
	}
	
}

class master implements ActionListener
{
	public JFrame eFrame = new JFrame();
	public  master(JFrame frame) {
		// TODO Auto-generated constructor stub
		eFrame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		main.board.rank=(float)0.4;
		eFrame.dispose();
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
		
		
		main.isrun=false;
		main.isrun=true;
		Runnable tRunnable = new timerun();
		Thread thread = new Thread(tRunnable);
		thread.start();
	}
	
}