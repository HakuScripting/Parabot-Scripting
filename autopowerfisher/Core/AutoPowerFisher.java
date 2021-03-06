package autopowerfisher.Core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.interfaces.Paintable;
//import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.rev317.api.methods.BotMouse;
import org.rev317.api.methods.Skill;

import autopowerfisher.Data.Variables;
import autopowerfisher.Strategies.fish.Bass;
import autopowerfisher.Strategies.fish.Lobster;
import autopowerfisher.Strategies.fish.MonkFish;
import autopowerfisher.Strategies.fish.Shrimp;
import autopowerfisher.Strategies.fish.SwordFish;
import autopowerfisher.Strategies.mode.Bank.Banker;
import autopowerfisher.Strategies.mode.Drop.PowerDrop;
import autopowerfisher.Strategies.randoms.OldMan;
import autopowerfisher.Strategies.walk.WalkToBank;
import autopowerfisher.Strategies.walk.WalkToFish;

@ScriptManifest(author = "Haku", category = Category.FISHING, description = "AIO Fishing just for Parabot.", name = "Auto Fisher", servers = { "PKHonor" }, version = 1.1)
public class AutoPowerFisher extends Script implements Paintable, MouseListener {

	GUI g = new GUI();
	public boolean guiwait = true;

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(255, 255, 255);
	private final Font font1 = new Font("Arial", 0, 14);

	private final Image img1 = getImage("http://i.imgur.com/x3CazTr.png");
	private final Image img2 = getImage("http://i.imgur.com/3amS1rs.png");
	

   // public static final Rectangle button = new Rectangle(442, 365, 52, 18);
   // private final Image img3 = getImage("https://dl.dropboxusercontent.com/s/wjvqlz0eo0eqhnw/v22t.png?dl=1&token_hash=AAEDdMhN2FXWmPf5-4HArzqWia_E_LjtRKYMZH_1aSJ6XA");
   // public static Timer paintTimer = new Timer();

	public String runTime(long i) {
		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;
		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

	@Override
	public boolean onExecute() {
		Variables.startTime = System.currentTimeMillis();
		Variables.fishingExp = Skill.FISHING.getExperience();
		Variables.Level = Skill.FISHING.getRealLevel();
		g.setVisible(true);
		while (guiwait == true) {
			sleep(500);

		}
		LogArea.log("Auto Power Fisher has started");
		LogArea.log("Please report any bugs or glitches to me (Haku)");
		Variables.strategies.add(new Shrimp());
		Variables.strategies.add(new Lobster());
		Variables.strategies.add(new Bass());
		Variables.strategies.add(new Lobster());
		Variables.strategies.add(new SwordFish());
		Variables.strategies.add(new MonkFish());
		Variables.strategies.add(new PowerDrop());
		Variables.strategies.add(new Banker());
		Variables.strategies.add(new WalkToBank());
		Variables.strategies.add(new WalkToFish());
		Variables.strategies.add(new OldMan());
		provide(Variables.strategies);
		return true;
	}

	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		if (!Variables.isHidePaint()) {
		g.drawImage(img1, 0, 337, null);
		}
		g.drawImage(img2, BotMouse.getMouseX(), BotMouse.getMouseY(), null);
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("Script updated for V2.04", 18, 444);
		g.drawString("Time Running:" + runTime(Variables.startTime), 20, 389);
		g.drawString(
				"Exp Gained:" + getExpGain(Skill.FISHING, Variables.fishingExp),
				21, 406);
		g.drawString(
				"Exp /PH:"
						+ getPerHour(getExpGain(Skill.FISHING,
								Variables.fishingExp)), 21, 425);
		g.drawString("FSpot Clicked:" + Variables.caught, 253, 388);
		g.drawString("Fish Dropped:" + Variables.dropped, 253, 406);
		g.drawString("TTL:", 292, 467);
		g.drawString("Status:" + Variables.status, 146, 468);
		g.drawString("Fishing Level:" + Skill.FISHING.getRealLevel(), 18, 467);
		g.drawString("Fishing like a:" + Variables.funny, 252, 423);
}



	public long getPerHour(long value) {
		return value * 3600000
				/ (System.currentTimeMillis() - Variables.startTime);
	}

	public long getExpGain(Skill name, int initial) {
		return (long) name.getExperience() - initial;
	}

	public long getLvlGain(Skill name, int initial) {
		return (long) name.getRealLevel() - initial;
	}

	@SuppressWarnings("serial")
	public class GUI extends JFrame {
		public GUI() {
			initComponents();
		}

		private void button1ActionPerformed(ActionEvent e) {
			String chosen = fishToCatch.getSelectedItem().toString();
			String mode = modeToUse.getSelectedItem().toString();
			if (chosen.equals("Shrimp")) {
				Variables.fishChosen = Variables.shrimp;
				Variables.inventoryFish = Variables.shrimpID;
			}
			if (chosen.equals("Bass")) {
				Variables.fishChosen = Variables.bass;
				Variables.inventoryFish = Variables.bassID;
			}
			if (chosen.equals("Lobster")) {
				Variables.fishChosen = Variables.lob;
				Variables.inventoryFish = Variables.lobsterID;
			}

			if (chosen.equals("SwordFish")) {
				Variables.fishChosen = Variables.swordFish;
				Variables.inventoryFish = Variables.swordFishID;
			}

			if (chosen.equals("Shark")) {
				Variables.fishChosen = Variables.shark;
				Variables.inventoryFish = Variables.sharkID;
			}

			if (chosen.equals("MonkFish")) {
				Variables.fishChosen = Variables.monkFish;
				Variables.inventoryFish = Variables.monkFishID;
			}

			if (mode.equals("Bank")) {
				Variables.bankMode = true;

			}

			if (mode.equals("Powermode")) {
				Variables.powerMode = true;
			}
		
			if(antiban.isSelected()) {
				Variables.antiBan = true;
			}
			
			if(chosen.equals("F1D1")) {
				Variables.m1d1Mode = true;
			}
			
			if(chosen.equals("Lobster")) {
				Variables.fishChosen = Variables.lob;
				Variables.inventoryFish = Variables.lobsterID;
			}

			guiwait = false;
			g.dispose();
		}

		private void initComponents() {
			// JFormDesigner - Component initialization - DO NOT MODIFY
			// //GEN-BEGIN:initComponents
			// Generated using JFormDesigner Evaluation license - AutoFisher
			// Autoisthelastname
			label1 = new JLabel();
			fishToCatch = new JComboBox<>();
			button1 = new JButton();
			antiban = new JRadioButton();
			modeToUse = new JComboBox<>();
			randoms = new JRadioButton();

			// ======== this ========
			Container contentPane = getContentPane();
			contentPane.setLayout(null);

			// ---- label1 ----
			label1.setText("Auto Fisher");
			label1.setFont(new Font("Segoe UI Light", Font.PLAIN, 26));
			contentPane.add(label1);
			label1.setBounds(new Rectangle(new Point(75, 10), label1
					.getPreferredSize()));

			// ---- fishToCatch ----
			fishToCatch.setModel(new DefaultComboBoxModel<>(new String[] {
					"Select a fish", "Shrimp", "Bass", "Lobster", "SwordFish", "MonkFish",
					"Shark", "Manta Ray" }));
			contentPane.add(fishToCatch);
			fishToCatch.setBounds(25, 65, 135, 25);

			// ---- button1 ----
			button1.setText("Start");
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button1ActionPerformed(e);
					button1ActionPerformed(e);
				}
			});
			contentPane.add(button1);
			button1.setBounds(95, 140, 120, button1.getPreferredSize().height);

			// ---- antiban ----
			antiban.setText("AntiBan");
			contentPane.add(antiban);
			antiban.setBounds(180, 95, 75, antiban.getPreferredSize().height);

			// ---- modeToUse ----
			modeToUse.setModel(new DefaultComboBoxModel<>(new String[] {
					"Select a mode", "Bank", "Powermode", "F1D1" }));
			contentPane.add(modeToUse);
			modeToUse.setBounds(25, 95, 135, 25);

			// ---- randoms ----
			randoms.setText("Randoms");
			contentPane.add(randoms);
			randoms.setBounds(180, 65, 75, randoms.getPreferredSize().height);

			contentPane.setPreferredSize(new Dimension(300, 220));
			setSize(300, 220);
			setLocationRelativeTo(getOwner());
			// JFormDesigner - End of component initialization
			// //GEN-END:initComponents
		}

		// JFormDesigner - Variables declaration - DO NOT MODIFY
		// //GEN-BEGIN:variables
		// Generated using JFormDesigner Evaluation license - AutoFisher
		// Autoisthelastname
		private JLabel label1;
		private JComboBox<String> fishToCatch;
		private JButton button1;
		private JRadioButton antiban;
		private JComboBox<String> modeToUse;
		private JRadioButton randoms;
		// JFormDesigner - End of variables declaration //GEN-END:variables
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    }

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
