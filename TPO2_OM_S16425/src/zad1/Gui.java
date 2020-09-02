package zad1;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{
	
	String weather;
	double double1;
	double double2;
	String double3;
	JPanel jPanel;
	
	
	JLabel pogoda, przelicznikPorypany, kursZlotego, info;
	
	
	
	public Gui(String weather, double przelicznikKA, double Nbp) {
		
		setVisible(true);
		setSize(new Dimension(800,600));
		setLayout(new GridLayout(2,2));
		jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(5,1));
		add(jPanel);
		info = new JLabel("Informacje o czyms"  );
		jPanel.add(info);
		
		Service service = new Service();
		weather = service.pogoda(weather);
		pogoda = new JLabel(weather);
		jPanel.add(pogoda);
		
	//	przelicznikKA= service.getRateFor(wal);
		
		Nbp = service.getNBPRate();
		przelicznikPorypany = new JLabel(String.valueOf(Nbp));
		jPanel.add(przelicznikPorypany);
		
		
		
	
		
		setTitle("Service");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


}
