package GUI;

import java.awt.Color;
import java.util.Random;

class numboard {
	public int[][] num = new int[10][10];
	public int[][] flag = new int [10][10];//标记格子是否点开
	public int[][]	flagt = new int[10][10];//标记格子是否插上flag
	
	public int minenum=0;
	public int cubeopen=0;
	public int mineopen=0;
	
	public float rank=(float)0.1;
	
	public void generate(int num[][])
	{
		main.board.minenum=0;
		main.board.cubeopen=0;
		main.board.mineopen=0;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				flag[i][j]=0;
				flagt[i][j]=0;
				
				main.sMainUI.cubeboard[i][j].t.setText(null);
				main.sMainUI.cubeboard[i][j].t.setIcon(null);
				main.sMainUI.cubeboard[i][j].t.setBackground(Color.LIGHT_GRAY);
				
				Random random = new Random();
				float f = random.nextFloat();
				if(f<rank)
				{
					num[i][j]=-1;
					minenum++;
				}
					
				else 
					num[i][j]=0;
				
			}
		}
	}
	
	public void updateboard(int num[][])
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(num[i][j]==-1)
				{
					for(int x=i-1;x<=i+1;x++)
					{
						for(int y=j-1;y<=j+1;y++)
						{
							if(x==i&&y==j)
								continue;
							else if(x>=0&&x<10&&y>=0&&y<10&&num[x][y]!=-1)
								num[x][y]++;
						}
					}
				}
			}
		}
	}
}
