package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;



class Decorate {
	public void decorate() {
		ImageIcon ficon = new ImageIcon(this.getClass().getResource("/pic/smallflag.png"));
		main.sMainUI.flags.setIcon(ficon);
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/pic/mine.png"));
		main.sMainUI.frame.setIconImage(icon.getImage());
		
//		int windowWidth = main.sMainUI.frame.getWidth();                     //获得窗口宽        
//		int windowHeight = main.sMainUI.frame.getHeight();                   //获得窗口高        
//		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包      
//		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸       
//		int screenWidth = screenSize.width;                     //获取屏幕的宽        
//		int screenHeight = screenSize.height;                   //获取屏幕的高        
//		main.sMainUI.frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		main.sMainUI.frame.setLocationRelativeTo(null);
//		
		main.welpage.welframe.setLocationRelativeTo(null);
		//main.sMainUI.flags.setBorderPainted(false); 
		Color bColor = new Color(32, 178, 170);
		main.sMainUI.frame.getContentPane().setBackground(bColor);
		
		Color b1Color = new Color(255, 228, 196);
		main.sMainUI.rank.setBackground(b1Color);
		main.sMainUI.remainder.setBackground(b1Color);
		main.sMainUI.restart.setBackground(b1Color);
		main.sMainUI.timer.setBackground(b1Color);
		main.sMainUI.flags.setBackground(b1Color);
		
		main.sMainUI.rank.setBorder(new BevelBorder(BevelBorder.RAISED));
		main.sMainUI.remainder.setBorder(new BevelBorder(BevelBorder.RAISED));
		main.sMainUI.restart.setBorder(new BevelBorder(BevelBorder.RAISED));
		main.sMainUI.timer.setBorder(new BevelBorder(BevelBorder.RAISED));
		main.sMainUI.flags.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		main.sMainUI.rank.setFocusPainted(false);
		main.sMainUI.remainder.setFocusPainted(false);
		main.sMainUI.restart.setFocusPainted(false);
		main.sMainUI.timer.setFocusPainted(false);
		main.sMainUI.flags.setFocusPainted(false);
		
		main.sMainUI.rank.setFont(new Font(null, Font.BOLD, 20));
		main.sMainUI.remainder.setFont(new Font(null, Font.BOLD, 20));
		main.sMainUI.restart.setFont(new Font(null, Font.BOLD, 20));
		main.sMainUI.timer.setFont(new Font(null, Font.BOLD, 20));
		main.sMainUI.flags.setFont(new Font(null, Font.BOLD, 20));
		
		main.welpage.qstart.setFont(new Font(null, Font.BOLD, 20));
		main.welpage.sigin.setFont(new Font(null, Font.BOLD, 20));
		main.welpage.sigup.setFont(new Font(null, Font.BOLD, 20));
		main.welpage.rank.setFont(new Font(null, Font.BOLD, 20));
		
		main.welpage.qstart.setBackground(b1Color);
		main.welpage.sigin.setBackground(b1Color);
		main.welpage.sigup.setBackground(b1Color);
		main.welpage.rank.setBackground(b1Color);
		
		main.welpage.qstart.setBorder(BorderFactory.createRaisedBevelBorder());
		main.welpage.sigin.setBorder(BorderFactory.createRaisedBevelBorder());
		main.welpage.sigup.setBorder(BorderFactory.createRaisedBevelBorder());
		main.welpage.rank.setBorder(BorderFactory.createRaisedBevelBorder());
		
	}
}
