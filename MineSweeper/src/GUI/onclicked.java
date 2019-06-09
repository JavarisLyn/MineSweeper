package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.MediaName;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class onclicked implements ActionListener{
	int x,y;
	public onclicked(int i,int j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(main.flagtemp==1)
			{
				if(main.board.flagt[x][y]==1)
				{
					main.board.flagt[x][y]=0;
					main.board.flag[x][y]=0;
					main.sMainUI.cubeboard[x][y].t.setIcon(null);
					main.board.mineopen--;
				}
				else if(main.board.flag[x][y]==0)
				{
					main.board.flagt[x][y]=1;
					main.board.flag[x][y]=1;
					ImageIcon ficon = new ImageIcon(this.getClass().getResource("/pic/smallflag.png"));
					main.sMainUI.cubeboard[x][y].t.setIcon(ficon);
					main.board.mineopen++;
					System.out.println("mine"+main.board.mineopen);
					if(main.board.cubeopen==100-main.board.minenum&&main.board.mineopen==main.board.minenum)
						main.sMainUI.gamewin();
				}
			}
			else {
				if(main.board.flag[x][y]==0)
				{	
					if(main.board.num[x][y]==-1)
						main.sMainUI.gameover(main.sMainUI, main.board,x,y);
					else if(main.board.num[x][y]==0)
						zero(x,y);
					else
					{
						main.sMainUI.singleshowup(main.sMainUI,main.board , x, y);
						main.board.cubeopen++;
					}
					if(main.board.cubeopen==100-main.board.minenum&&main.board.mineopen==main.board.minenum)
						main.sMainUI.gamewin();	
				}
				System.out.println(main.board.cubeopen);
			}
			
		
		
		
	}
	
	public void zero(int i,int j)
	{
		main.sMainUI.singleshowup(main.sMainUI, main.board, i, j);
		main.board.cubeopen++;
		for(int m=i-1;m<=i+1;m++)
		{
			for(int n=j-1;n<=j+1;n++)
			{
				if(m==i&&n==j)
					continue;
				else if(m>=0&&m<10&&n>=0&&n<10&&main.board.flag[m][n]==0)
				{
					if(main.board.num[m][n]!=0&&main.board.num[m][n]!=-1)
					{
						main.sMainUI.singleshowup(main.sMainUI,main.board , m, n);
						main.board.cubeopen++;
					}
						
					else if(main.board.num[m][n]==0)
					{
						//main.sMainUI.singleshowup(main.sMainUI,main.board , m, n);
						zero(m,n);
					}
						
				}
			}
		}
	}

}
