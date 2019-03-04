import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JColorChooser;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.*;
import org.w3c.dom.*;

import com.thehowtotutorial.splashscreen.JSplash;

public class Main_Background {

	//사용할 색상 미리 정의
	static Color c1 = new Color(254, 67, 101);
	static Color c2 = new Color(252, 157, 154);
	static Color c3 = new Color(249, 205, 173);
	static Color c4 = new Color(200, 200, 169);
	static Color mc = c4;
	static Color sc = c2;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//스플래쉬
				JSplash splash = new JSplash(Main_Background.class.getResource("javatitle.png"),
						true, true, false, "Version 1.0", null, Color.BLACK, Color.BLACK);

				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						splash.splashOn();
						splash.setProgress(0, "Loading Start");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(20, "Loading 20%");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(40,"Loading 40%");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(60,"Loading 60%");
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(80,"Starting Java Program");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.splashOff();

						//프레임
						JFrame frame = new JFrame();
						frame.setTitle("하루 글");
						frame.setLocation(200, 100);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setPreferredSize(new Dimension(1550,800));
				
						//frame에 붙이는 데 BoxLayout-Horizontal 사용
						Box boxh = Box.createHorizontalBox();
						boxh.add(new Cal()); //가로로 달력 붙임
						
						JMenuBar mb = new JMenuBar();
						JMenuItem ColorMenuItem = new JMenuItem("테마 컬러 선택");
						JMenu MainMenu = new JMenu("하루글 메인 메뉴");
						
						ColorMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								JColorChooser chooser = new JColorChooser();
								
								String Theme = e.getActionCommand();
								if(Theme.equals("테마 컬러 선택")) {
									Color theme = chooser.showDialog(null, "테마 컬러 선택", Color.YELLOW);
									
									if(theme !=null)
										Cal.choosec = theme;
								}
							}
						});
						
						MainMenu.add(ColorMenuItem);
						mb.add(MainMenu);
						frame.setJMenuBar(mb);
						
						//2, 2개 메뉴
						try {
							//메뉴바 1
							Menu menu1 = new Menu();
							JPanel firstCards = menu1.firstCards;
							menu1.setPreferredSize(new Dimension(500, 250));
							menu1.setBounds(100, 100, 450, 300);
							
							firstCards.setBorder(new EmptyBorder(0, 0, 0, 0));
							firstCards.setLayout(new CardLayout(0, 0));
							
							menu1.add(firstCards);
							menu1_1 menu1_1 = new menu1_1(menu1);
							menu1_2 menu1_2 = new menu1_2(menu1);
							menu2_1 menu2_1 = new menu2_1(menu1);
							menu2_2 menu2_2 = new menu2_2(menu1);

							menu1.revalidate();
							menu1.repaint();
							
							firstCards.add(menu1_1, "menu1_1");
							firstCards.add(menu1_2, "menu1_2");
							
							menu1.firstCards.add(menu2_1, "menu2_1");
							menu1.firstCards.add(menu2_2, "menu2_2");

							First_Menubar menubar1 = new First_Menubar(menu1);
							//메뉴바 1 끝
							
							//메뉴바 2
							Menu menu2 = new Menu();
							JPanel secondCards = menu2.secondCards;
							menu2.setPreferredSize(new Dimension(500, 250));
							menu2.setBounds(100, 100, 450, 300);
							
							secondCards.setBorder(new EmptyBorder(0, 0, 0, 0));
							secondCards.setLayout(new CardLayout(0, 0));
							
							menu2.add(secondCards);
							menu3_1 menu3_1 = new menu3_1(menu2);
							menu3_2 menu3_2 = new menu3_2(menu2);
							menu4_1 menu4_1 = new menu4_1(menu2);
							menu4_2 menu4_2 = new menu4_2(menu2);

							menu2.revalidate();
							menu2.repaint();
							
							secondCards.add(menu3_1, "menu3_1");
							secondCards.add(menu3_2, "menu3_2");
							
							menu2.secondCards.add(menu4_1, "menu4_1");
							menu2.secondCards.add(menu4_2, "menu4_2");

							Second_Menubar menubar2 = new Second_Menubar(menu2);
							//메뉴바 2 끝

							Box vboxlayout = Box.createVerticalBox();
							vboxlayout.add(menubar1);
							vboxlayout.add(menu1);

							vboxlayout.add(Box.createVerticalStrut(10));
							
							vboxlayout.add(menubar2);
							vboxlayout.add(menu2);
							
							JPanel jp = new JPanel();
							jp.add(vboxlayout);
							
						    boxh.add(jp);
						    frame.add(boxh);
						} catch (Exception e) {
							e.printStackTrace();
						}
						//frame.setContentPane(Cards);
						frame.pack();
						frame.setVisible(true);
			}
		});
				t.start();
	}
		}); //invoklater
	} //public static main
} //public class