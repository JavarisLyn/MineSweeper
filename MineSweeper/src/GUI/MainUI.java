package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.math.BigDecimal;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import databse.GameStats;








public class MainUI {
	public JFrame frame = new JFrame("MineSweeper");
	public JButton restart = new JButton("RESTART");
	public JButton rank = new JButton("RANK");
	public JButton remainder = new JButton("Made By LeeeYF_");
	public JButton flags = new JButton();
	public JButton timer = new JButton("TIME");
	
	public cube[][] cubeboard = new cube[10][10];
	
	
	public void setUI()
	{
		frame.setSize(525, 658);
		frame.setLayout(null);
		frame.add(restart);
		frame.add(rank);
		frame.add(remainder);
		frame.add(flags);
		frame.add(timer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		restart.setBounds(0, 0, 200,50);
		restart.addActionListener(new ronclicked());
		
		rank.setBounds(200, 0, 100, 50);
		rank.addActionListener(new rankonclicked());
			
		remainder.setBounds(300, 0, 210,50);
		
		flags.setBounds(0, 55, 200, 50);
		flags.addActionListener(new fonclicked());
		timer.setBounds(200, 55, 310, 50);
		
		Decorate decorate = new Decorate();
		decorate.decorate();
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				cubeboard[i][j]= new cube();
				cubeboard[i][j].t.addActionListener(new onclicked(i,j));
				cubeboard[i][j].t.setBounds(i*51, j*51+110, 50, 50);
				
				cubeboard[i][j].t.setBorder(BorderFactory.createRaisedBevelBorder());//凸起来的效果
				cubeboard[i][j].t.setBackground(Color.lightGray);
				cubeboard[i][j].t.setFocusPainted(false);
				frame.add(cubeboard[i][j].t);	
				//System.out.println(tcube.t.getLocation());
			}
		}
		frame.setVisible(true);
	}
	
	//显示所有格子内容
	public void allshowup(MainUI sMainUI,numboard board)
	{
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
			{
				sMainUI.cubeboard[i][j].t.setText(String.valueOf(board.num[i][j]));
				board.flag[i][j]=1;
			}
	}
	
	//显示制定某一格内容
	public void singleshowup(MainUI sMainUI,numboard board,int i,int j) {
		sMainUI.cubeboard[i][j].t.setText(String.valueOf(board.num[i][j]));
		board.flag[i][j]=1;
	}
	
	//游戏结束
	public void gameover(MainUI sMainUI,numboard board,int x,int y)
	{
		sMainUI.cubeboard[x][y].t.setBackground(Color.RED);
		
		main.isrun=false;
		
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
			{
				if(board.flagt[i][j]==1)
				{
					sMainUI.cubeboard[i][j].t.setIcon(null);
					sMainUI.cubeboard[i][j].t.setBackground(Color.GRAY);
				}
				
				if(board.num[i][j]!=-1)
				{
					board.flag[i][j]=1;
					sMainUI.cubeboard[i][j].t.setText(String.valueOf(board.num[i][j]));
				}
					
				if(board.num[i][j]==-1)
				{
					//sMainUI.cubeboard[i][j].t.setBackground(Color.RED);
					ImageIcon icon = new ImageIcon(this.getClass().getResource("/pic/mine.png"));
					sMainUI.cubeboard[i][j].t.setText(null);
					sMainUI.cubeboard[i][j].t.setIcon(icon);
					//JButton button = new JButton(new ImageIcon(getClass().getResource("1.png")));
				}
					
			}
	
		
//
		System.out.println((float)(main.board.cubeopen+main.board.mineopen)/100);
		GameStats gStats = new GameStats(main.userid, main.runtime, (float)(main.board.cubeopen+main.board.mineopen)/100);
		gStats.update();
		JOptionPane.showMessageDialog(frame, "GAME OVER", "you lose",0);
	}
	
	//改变指针形状
	public void changecursor()
	{	
		if(main.cursortemp==-1)
		{
			String url = "/pic/smallflag.png"; 
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image image = new ImageIcon(this.getClass().getResource(url)).getImage();
			Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
			frame.setCursor(cursor); 
			main.cursortemp=-main.cursortemp;
		}
		else
		{
			frame.setCursor(null);
			main.cursortemp=-main.cursortemp;
		}
			
	}
	
	//游戏胜利
	public void gamewin()
	{
		main.isrun=false;
		JOptionPane.showMessageDialog(frame, "WINNER WINNER", "you win", JOptionPane.INFORMATION_MESSAGE);
		GameStats gStats = new GameStats(main.userid, main.runtime, (float)1.0);
		gStats.update();
		
	}
}
