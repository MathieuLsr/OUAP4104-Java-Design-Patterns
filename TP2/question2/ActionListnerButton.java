package question2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListnerButton implements ActionListener {
	
	private String name ;

	public ActionListnerButton(String name, String str) {
		this.name = name ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("oserveur"+this.name+" : clic du button "+e.getActionCommand());
	}

	
	
}
