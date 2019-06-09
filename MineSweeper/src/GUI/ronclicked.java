package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.MinguoChronology;

public class ronclicked implements ActionListener{
	
	public void actionPerformed(ActionEvent e)
	{
		
		main.board.generate(main.board.num);
		main.board.updateboard(main.board.num);
		
		main.isrun=false;
		main.isrun=true;
		Runnable tRunnable = new timerun();
		Thread thread = new Thread(tRunnable);
		thread.start();//重新建立计时线程
	}
}
