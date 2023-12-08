import javax.swing.*;		// Import Swing GUI package
import javax.swing.text.DefaultCaret;

import java.awt.*;			// Import Adavnced Window Toolkit (AWT) package
import java.awt.event.*;	// Import ART veent package (to program buttons)
import java.io.IOException;

public class GameGUI extends JFrame implements KeyListener {

	private JTextArea room;
	private JTextArea textArea1;
	private JTextArea prompt;
	private JTextField textField;
	private boolean convo;
	
	public void room(String s) {
		room.setText(s);
	}
	
	public void print(String s) {
		textArea1.append(s+"\n\n");
	}
	
	public void prompt(String s) {
		prompt.setText(s);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='\n') {
			try {
				if(!Game.getDead()) {
					if(!convo) {
						Game.gameMethod();
					} else {
						if(Game.talkingToWho().equals("remote?")){
							((Remote) Game.getItem("remote")).response(Integer.parseInt(textField.getText()));
						} else {
							Game.getCurrentRoom().getNPC(Game.talkingToWho()).response(Integer.parseInt(textField.getText()));
						}
					}
					textField.setText("");
				}
			} catch (ClassNotFoundException | IOException e1) {
				Game.print("[ERROR]");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public GameGUI() {
		setTitle("Text Game");
		setSize(755, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		room = new JTextArea();
		room.setFont(new Font(null, Font.PLAIN,15));
		room.setRows(5);
		room.setColumns(50);
		room.setLineWrap(true);
		room.setWrapStyleWord(true);
		room.setEditable(false);
		add(room);
		
		textArea1 = new JTextArea();
		textArea1.setFont(new Font(null, Font.PLAIN,15));
		textArea1.setRows(15);
		textArea1.setColumns(50);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		textArea1.setEditable(false);
		DefaultCaret caret = (DefaultCaret) textArea1.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea1);
		add(scroll);
		
		prompt = new JTextArea();
		prompt.setFont(new Font(null, Font.PLAIN,15));
		prompt.setRows(1);
		prompt.setColumns(50);
		prompt.setBackground(getForeground());
		prompt.setEditable(false);
		add(prompt);
		
		setTextField(new JTextField());
		getTextField().setFont(new Font(null, Font.PLAIN,15));
		getTextField().setColumns(50);
		getTextField().addKeyListener(this);
		add(getTextField());
		
		setVisible(true);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setConvo(boolean b) {
		convo = b;
	}

}
