package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fonclicked implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.flagtemp=-main.flagtemp;
		main.sMainUI.changecursor();
	}
}
