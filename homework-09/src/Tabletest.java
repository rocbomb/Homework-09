import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Tabletest  extends Applet {  
	    private static final long serialVersionUID = 5511892956119084309L;  
	    MaxSum mm;
	    Button bt;
	    JPanel numPanel;
	    JPanel mainPanel;
	    int end = 0;
	    @Override  
	    public void init() {
	    	String string = new String();
	    	numPanel = new JPanel();
	    	mainPanel= new JPanel();
	    	string = "3,"+
	    			"3,"+
	    			"1,1,-1,"+
	    			"-,-1,5,"+
	    			"-1,-1,4,";
	    	mm = new MaxSum(string);
	        Graphics g = this.getGraphics();
	        bt = new Button("next");
	        bt.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						mm.nstep(1);
						newt();
				}
	        });
	        //mainPanel.setLayout(new BorderLayout());
	        //mainPanel.add(bt,BorderLayout.SOUTH);
	        //mainPanel.add(numPanel,BorderLayout.NORTH);
	        //add(mainPanel);
	        this.setLayout(new BorderLayout());
	        add(bt,BorderLayout.SOUTH);
	        add(numPanel,BorderLayout.NORTH);
	    //   paint(g);
	    }
//	    public void paint(Graphics g) {  
//	        g.drawString("Hello aAnumPanellet!", 45, 45);
//	        
//	    }
	    public void newt(){
	    	numPanel.removeAll();
			numPanel.setLayout(new GridLayout(mm.row,mm.line));
	    	for(int i=1; i<=mm.line; i++)
				for(int j=1;j<=mm.row; j++){
					JLabel xxx = new JLabel();
					xxx.setOpaque(true);
					xxx.setText(mm.matrix[i][j]+"");
					if(mm.answer[i][j] == 1)
						xxx.setBackground(Color.yellow);
					else
						xxx.setBackground(Color.white);
					xxx.setBorder(BorderFactory.createLineBorder(Color.red));
					xxx.setHorizontalAlignment(SwingConstants.CENTER);
					numPanel.add(xxx);
				}
	    }
}
