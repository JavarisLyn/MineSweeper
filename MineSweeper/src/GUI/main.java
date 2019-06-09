package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;






public class main {
	
	//剩余雷
	//时间
	//分数
	public static MainUI sMainUI = new MainUI();
	public static numboard board = new numboard();
	
	public static int flagtemp=-1;
	public static int cursortemp=-1;	
	public static long startime=0;
	public static long runtime=0;
	
	public static welcomepage welpage = new welcomepage();

	
	public static boolean isrun=true;
	
	public static String userid="001";
	public static String userpsd="001";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		welpage.welUI();
//		Runnable runnable = new mainrun();
//		Thread thread = new Thread(runnable);
//		thread.start();
//		
//		Runnable trun = new timerun();
//		Thread thread2 = new Thread(trun);
//		thread2.start();
		
	}

}

 class mainrun implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		main.sMainUI.setUI();
		SwingUtilities.updateComponentTreeUI(main.sMainUI.frame);
		
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
	}
	
}

class timerun implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		main.startime=System.currentTimeMillis();
		while(main.isrun==true)
		{
			main.runtime=(System.currentTimeMillis()-main.startime)/1000;
			main.sMainUI.timer.setText("TIME:"+main.runtime+"s");
		}
			
	}
	
}
