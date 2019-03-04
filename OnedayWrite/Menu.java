import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import sun.swing.SwingAccessor.JTextComponentAccessor;

//메뉴를 세 패널로 나눠서 프레임에 배치함(CardLayout)


//첫 번째 메뉴바

class First_Menubar extends JPanel {
	public First_Menubar (Menu panel) {
		setPreferredSize(new Dimension(500, 100));
		
		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		JButton m1_1 = new JButton("ToDoList 추가");
		JButton m1_2 = new JButton("ToDoList 보기");
		JButton m2_1 = new JButton("일정 추가");
		JButton m2_2 = new JButton("일정 보기");
		
		m1_1.setUI(new StyledButtonUI_menu());
		m1_1.setBackground(c3);
		
		m1_2.setUI(new StyledButtonUI_menu());
		m1_2.setBackground(c2);
		
		m2_1.setUI(new StyledButtonUI_menu());
		m2_1.setBackground(c3);
		
		m2_2.setUI(new StyledButtonUI_menu());
		m2_2.setBackground(c2);
		
		
		m1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,  "menu1_1");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		m1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards, "menu1_2");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		m2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu2_1");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		m2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu2_2");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		JPanel btns_menu = new JPanel();
		btns_menu.add(m1_1);
		btns_menu.add(m1_2);
		btns_menu.add(m2_1);
		btns_menu.add(m2_2);
		
		setLayout(new FlowLayout());
		add(btns_menu);
		
	}	
}


//두 번째 메뉴바

class Second_Menubar extends JPanel {
	public Second_Menubar(Menu panel) {
		setPreferredSize(new Dimension(500, 100));
		
		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		JButton m3_1 = new JButton("Q & A 추가");
		JButton m3_2 = new JButton("Q & A 보기");
		JButton m4_1 = new JButton("DIARY 추가");
		JButton m4_2 = new JButton("DIARY 보기");
		
		m3_1.setUI(new StyledButtonUI_menu());
		m3_1.setBackground(c3);
		
		m3_2.setUI(new StyledButtonUI_menu());
		m3_2.setBackground(c2);
		
		m4_1.setUI(new StyledButtonUI_menu());
		m4_1.setBackground(c3);
		
		m4_2.setUI(new StyledButtonUI_menu());
		m4_2.setBackground(c2);
		
		
		m3_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.secondCards.getLayout());
				cardLayout.show(panel.secondCards,"menu3_1");
				panel.secondCards.revalidate();
				panel.secondCards.repaint();
			}
		});

		m3_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.secondCards.getLayout());
				cardLayout.show(panel.secondCards,"menu3_2");
				panel.secondCards.revalidate();
				panel.secondCards.repaint();
			}
		});

		m4_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.secondCards.getLayout());
				cardLayout.show(panel.secondCards,"menu4_1");
				panel.secondCards.revalidate();
				panel.secondCards.repaint();
			}
		});

		m4_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.secondCards.getLayout());
				cardLayout.show(panel.secondCards,"menu4_2");
				panel.secondCards.revalidate();
				panel.secondCards.repaint();
			}
		});
		
		JPanel btns_menu = new JPanel();
		btns_menu.add(m3_1);
		btns_menu.add(m3_2);
		btns_menu.add(m4_1);
		btns_menu.add(m4_2);
		
		setLayout(new FlowLayout());
		add(btns_menu);
	}
}


// 첫 번째 - 추가
class menu1_1 extends JPanel {
	Date d = new Date();
	
	public menu1_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));
		
		JLabel menu1 = new JLabel("< To do List > 추가");
		menu1.setFont(new Font("돋움체", Font.BOLD, 20));
		
		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(3, 1));
		
		JTextArea input = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(input);
		
		JPanel btns_input = new JPanel();
		
		JButton save = new JButton("저장");
		JButton clear = new JButton("지우기");
		
		save.setUI(new StyledButtonUI_etc());
		save.setBackground(c2);
		
		clear.setUI(new StyledButtonUI_etc());
		clear.setBackground(c2);
		
		btns_input.add(save);
		btns_input.add(clear);
		
		add(menu1);
		add(scrollPane);
		add(btns_input);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					PreparedStatement ps = connection.prepareStatement("INSERT INTO ToDoList VALUES(?, ?, ?)");
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ds = f.format(d);
					ps.setString(2, ds);
					f = new SimpleDateFormat("yyyy-MM");
					ds = f.format(d);
					ps.setString(3, ds);
					
					int res = ps.executeUpdate();
					if(res == 1) {
					JOptionPane.showMessageDialog(null, "저장 완료", "알림", JOptionPane.WARNING_MESSAGE);
					ps.close();
					connection.close();
					}
				} catch (ClassNotFoundException | SQLException e1){
					JOptionPane.showMessageDialog(null, "To Do List 데이터베이스 연결 오류 : " + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		
	}
}

// 첫번째 - 보기
class menu1_2 extends JPanel {
	
	Date d = new Date();
	
	String colName[] = {"목록", "저장 시간"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row = 0;
	
	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ToDoList where date = ?");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
			
			String ds = f.format(d);
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String todolist = rs.getString("todolist");
				String date = rs.getString("datetime");
				
				Object data[] = {todolist, date};
				model.addRow(data);
			}
			
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정

			TableColumnModel tcmSchedule = table.getColumnModel(); // 정렬할 테이블의 ColumnModel을 가져옴
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // 반복문을 이용하여 테이블을 가운데 정렬로 지정
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "To Do List 데이터베이스 연결 오류 : " + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public menu1_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu1 = new JLabel("< To do List > 보기");
		menu1.setFont(new Font("돋움체", Font.BOLD, 20));
		
		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(4, 1));
		
		JPanel btns_input = new JPanel();
		btns_input.setLayout(new FlowLayout());
		
		update = new JButton();
		delete = new JButton();
		
		JTextField input = new JTextField(40);
		JPanel input_panel = new JPanel();
		input_panel.add(input);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) { //마우스로 선택한 행의 정보를 각각의 텍스트필드에 출력하기 
				row = table.getSelectedRow();

				input.setText((String)model.getValueAt(row, 0));
			}

		});
		
		update.setText("수정");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(c2);
		
		delete.setText("DELETE");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(c2);
		
		btns_input.add(update);
		btns_input.add(delete);
		
		add(menu1);
		add(scrollPane);
		add(btns_input);
		
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				
				if(row < 0) return;
				String query = "UPDATE ToDoList SET todolist = ?, datetime = ?, date = ? WHERE todolist = ? AND datetime = ?";

				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					PreparedStatement ps = connection.prepareStatement(query);

					//modelUpdate.fireTableDataChanged();
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = f.format(d);
					ps.setString(2, dsUpdate);
					f = new SimpleDateFormat("yyyy-MM");
					dsUpdate = f.format(d);
					ps.setString(3, dsUpdate);
					ps.setString(4, (String)model.getValueAt(row, 0));
					ps.setString(5, (String)model.getValueAt(row, 1));
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch(ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류 : " + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
				
				model.setRowCount(0);
				select();
				input.setText("");
				
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());        // 선택된 버튼의 텍스트값 출력

				//row = table.getSelectedRow();
				if(row<0) return; // 선택이 안된 상태면 -1리턴

				String query = "DELETE FROM ToDoList WHERE todolist = ? AND datetime = ?";

				try{
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, (String)model.getValueAt(row, 0));
					//System.out.println((String)model.getValueAt(row, 0));
					ps.setString(2, (String)model.getValueAt(row, 1));
					//System.out.println((String)model.getValueAt(row, 1));

					int cnt = ps.executeUpdate();

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류 : " + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}

				model.removeRow(row);
			}
		});
		
	}
}

// 두 번째 - 추가
class menu2_1 extends JPanel {
	Date d = new Date();
	
	public menu2_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu2 = new JLabel("< SCHEDULE > 추가");
		menu2.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(3, 1));
		
		JTextArea input = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(input);
		JPanel btns_input = new JPanel();

		JButton save = new JButton("저장");
		JButton clear = new JButton("지우기");
		
		save.setUI(new StyledButtonUI_etc());
		save.setBackground(c2);

		clear.setUI(new StyledButtonUI_etc());
		clear.setBackground(c2);
		
		btns_input.add(save);
		btns_input.add(clear);
		
		add(menu2);
		add(input);
		add(btns_input);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

					PreparedStatement ps = connection.prepareStatement("INSERT INTO Schedule VALUES(?, ?, ?)");
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ds = f.format(d);
					ps.setString(2, ds);
					f = new SimpleDateFormat("yyyy-MM-dd");
					ds = f.format(d);
					ps.setString(3, ds);


					int res = ps.executeUpdate();
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "저장 완료", "알 림", JOptionPane.WARNING_MESSAGE);
					}

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});

	}
}

///두 번째 - 보기
class menu2_2 extends JPanel{
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	String ds = f.format(d);

	String colName[] = {"SCHEDULE", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);

	JButton update = null;
	JButton delete = null;

	int row = 0;

	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Schedule where date = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				String sche = rs.getString("schedule");
				String date = rs.getString("datetime");

				Object data[] = {sche, date};
				model.addRow(data);
			}

			ps.close();
			rs.close();

			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정

			TableColumnModel tcmSchedule = table.getColumnModel(); // 정렬할 테이블의 ColumnModel을 가져옴
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // 반복문을 이용하여 테이블을 가운데 정렬로 지정
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
		}
	}

	public menu2_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu2 = new JLabel("< SCHEDULE > 보기");
		menu2.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);

		setLayout(new GridLayout(4, 1));
		
		JPanel btns_input = new JPanel();
		btns_input.setLayout(new FlowLayout());
		
		update = new JButton();
		delete = new JButton();

		JTextField input = new JTextField(40);
		
		//JPanel jp_input = new JPanel();
		//jp_input.add(input);

		select();

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) { //마우스로 선택한 행의 정보를 각각의 텍스트필드에 출력하기 
				row = table.getSelectedRow();

				input.setText((String)model.getValueAt(row, 0));
			}

		});

		update = new JButton();
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());

				//row = table.getSelectedRow();
				if(row<0) return;

				String query = "UPDATE Schedule SET schedule = ?, datetime = ?, date = ? WHERE schedule = ? AND datetime = ?";

				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

					PreparedStatement ps = connection.prepareStatement(query);

					//modelUpdate.fireTableDataChanged();
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = f.format(d);
					ps.setString(2, dsUpdate);
					f = new SimpleDateFormat("yyyy-MM-dd");
					dsUpdate = f.format(d);
					ps.setString(3, dsUpdate);
					ps.setString(4, (String)model.getValueAt(row, 0));
					ps.setString(5, (String)model.getValueAt(row, 1));

					int cnt = ps.executeUpdate();

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
				model.setRowCount(0);
				select();
				input.setText("");
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());        // 선택된 버튼의 텍스트값 출력

				//row = table.getSelectedRow();
				if(row<0) return; // 선택이 안된 상태면 -1리턴

				String query = "DELETE FROM Schedule WHERE schedule = ? AND datetime = ?";

				try{
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, (String)model.getValueAt(row, 0));
					//System.out.println((String)model.getValueAt(row, 0));
					ps.setString(2, (String)model.getValueAt(row, 1));
					//System.out.println((String)model.getValueAt(row, 1));

					int cnt = ps.executeUpdate();

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Schedule 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}

				model.removeRow(row);
			}
		});

		
		update.setText("수정");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(c2);
		
		delete.setText("삭제");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(c2);
		
		btns_input.add(update);
		btns_input.add(delete);

		add(menu2);
		add(scrollPane);
		add(input);
		add(btns_input);
	}
}

//세 번째 - 추가
class menu3_1 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("MMdd");
	
	public menu3_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< Q & A > 추가");
		menu3.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(4, 1));

		JTextArea input = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(input);
		
		JPanel jp_q = new JPanel();
		JTextField q = new JTextField(40);
		q.setHorizontalAlignment(JTextField.CENTER);
		jp_q.add(q);
		
		try {
			String ds = f.format(d);
			
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			PreparedStatement ps = connection.prepareStatement("SELECT q FROM Q where qdate = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			String Q = rs.getString("q");
			
			q.setText(Q);
			
			ps.close();
			rs.close();
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Q & A 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
		}
		q.setEditable(false);
		q.setFont(new Font("돋움체", Font.BOLD, 17));

		JPanel btns_input = new JPanel();
		
		JButton save = new JButton("SAVE");
		save.setUI(new StyledButtonUI_etc());
		save.setBackground(c2);
		
		JButton clear = new JButton("CLEAR");
		clear.setUI(new StyledButtonUI_etc());
		clear.setBackground(c2);
		
		btns_input.add(save);
		btns_input.add(clear);
		
		add(menu3);
		add(jp_q);
		add(input);
		add(btns_input);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					f = new SimpleDateFormat("yyyyMMdd");
					String ds = f.format(d);
					String Qa = null;
					
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					PreparedStatement ps = connection.prepareStatement("SELECT qa FROM QA where fdate = ?");
					ps.setString(1, ds);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						Qa = rs.getString("qa");
					}
					
					if(Qa == null) {
						ps = connection.prepareStatement("INSERT INTO QA VALUES(?, ?, ?, ?, ?, ?)");
						ps.setString(1, input.getText());
						f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						ds = f.format(d);
						ps.setString(2, ds);
						f = new SimpleDateFormat("yyyyMMdd");
						ds = f.format(d);
						ps.setString(3, ds);
						f = new SimpleDateFormat("MMdd");
						ds = f.format(d);
						ps.setString(4, ds);
						f = new SimpleDateFormat("yyyy");
						ds = f.format(d);
						ps.setString(5, ds);
						f = new SimpleDateFormat("MM");
						ds = f.format(d);
						ps.setString(6, ds);
						
						int res = ps.executeUpdate();
						if(res == 1) {
							JOptionPane.showMessageDialog(null, "저장 완료", "알 림", JOptionPane.WARNING_MESSAGE);
						}
					} else if(Qa != null) {
						JOptionPane.showMessageDialog(null, "이미 저장된 Q & A가 있습니다.", "알 림", JOptionPane.WARNING_MESSAGE);
					}
					
					ps.close();
					rs.close();
					
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Q & A 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
	}
}

//세 번째 - 보기
class menu3_2 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("MMdd");
	String ds = f.format(d);

	String colName[] = {"Q & A", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);

	JButton update = null;
	JButton delete = null;

	int row = 0;
	
	static String txt_content_1= "<Q&A>";
	static String xml_content_1_2 = "";
	static String xml_content_1_3 = "";

	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

			PreparedStatement ps = connection.prepareStatement("SELECT * FROM QA where mddate = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String qa = rs.getString("qa");
				String date = rs.getString("datetime");

				Object data[] = {qa, date};

				txt_content_1 = txt_content_1 + qa + "/" + date + "*" ; //넣을 문자열
				xml_content_1_2 = xml_content_1_2 + qa + "*"; //q&a중 a만 갖고온 것
				xml_content_1_3 = xml_content_1_3 + date + "*"; //q&a중 datetime만 갖고온 것

				model.addRow(data);

				//여기서 내보내기 파일 내용 추가
			}

			ps.close();
			rs.close();

			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정

			TableColumnModel tcmSchedule = table.getColumnModel(); // 정렬할 테이블의 ColumnModel을 가져옴
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // 반복문을 이용하여 테이블을 가운데 정렬로 지정
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Q & A 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
		}
	}

	public menu3_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< Q & A > 보기");
		menu3.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(4, 1));
		
		JPanel btns_input = new JPanel();
		btns_input.setLayout(new FlowLayout());
		
		update = new JButton();
		delete = new JButton();

		JTextField input = new JTextField(40);
		//JPanel up = new JPanel();
		//up.add(input);

		select();

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) { //마우스로 선택한 행의 정보를 각각의 텍스트필드에 출력하기 
				row = table.getSelectedRow();

				input.setText((String)model.getValueAt(row, 0));
			}

		});
		
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());

				//row = table.getSelectedRow();
				if(row < 0) return;

				String query = "UPDATE QA SET QA = ?, datetime = ?, finddate = ?, mddate = ?, year = ?, month = ? WHERE qa = ? AND datetime = ?";

				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

					PreparedStatement ps = connection.prepareStatement(query);

					//modelUpdate.fireTableDataChanged();
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = f.format(d);
					ps.setString(2, dsUpdate);
					f = new SimpleDateFormat("yyyyMMdd");
					dsUpdate = f.format(d);
					ps.setString(3, dsUpdate);
					f = new SimpleDateFormat("MMdd");
					dsUpdate = f.format(d);
					ps.setString(4, dsUpdate);
					f = new SimpleDateFormat("yyyy");
					dsUpdate = f.format(d);
					ps.setString(5, dsUpdate);
					f = new SimpleDateFormat("MM");
					dsUpdate = f.format(d);
					ps.setString(6, dsUpdate);

					int cnt = ps.executeUpdate();

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Q & A 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
				model.setRowCount(0);
				select();
				input.setText("");
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());        // 선택된 버튼의 텍스트값 출력

				//row = table.getSelectedRow();
				if(row < 0) return; // 선택이 안된 상태면 -1리턴

				String query = "DELETE FROM QA WHERE qa = ? AND datetime = ?";

				try{
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, (String)model.getValueAt(row, 0));
					//System.out.println((String)model.getValueAt(row, 0));
					ps.setString(2, (String)model.getValueAt(row, 1));
					//System.out.println((String)model.getValueAt(row, 1));

					int cnt = ps.executeUpdate();

					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Q & A 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}

				model.removeRow(row);
				input.setText("");
			}
		});

		update.setText("수정");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(c2);
		
		delete.setText("삭제");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(c2);
		
		btns_input.add(update);
		btns_input.add(delete);

		add(menu3);
		add(scrollPane);
		add(input);
		add(btns_input);
	}

}

// 네 번째 - 추가
class menu4_1 extends JPanel {
	Date d = new Date();

	public menu4_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu4 = new JLabel("< DIARY > 추가");
		menu4.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(3, 1));
		
		JTextArea input = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(input);

		JPanel btns_input = new JPanel();
		
		JButton save = new JButton("저장");
		save.setUI(new StyledButtonUI_etc());
		save.setBackground(c2);
		
		JButton clear = new JButton("지우기");
		clear.setUI(new StyledButtonUI_etc());
		clear.setBackground(c2);
		
		btns_input.add(save);
		btns_input.add(clear);

		add(menu4);
		add(input);
		add(btns_input);

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {						
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");

					PreparedStatement ps = connection.prepareStatement("INSERT INTO DIARY VALUES(?, ?, ?, ?, ?)");						
					ps.setString(1, input.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ds = f.format(d);
					ps.setString(2, ds);
					f = new SimpleDateFormat("yyyy-MM-dd");
					ds = f.format(d);
					ps.setString(3, ds);
					f = new SimpleDateFormat("yyyy");
					ds = f.format(d);
					ps.setString(4, ds);
					f = new SimpleDateFormat("MM");
					ds = f.format(d);
					ps.setString(5, ds);

					int res = ps.executeUpdate();
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "정상적으로 저장되었습니다.", "알 림", JOptionPane.WARNING_MESSAGE);
					}

					ps.close();

					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "DIARY 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
	}
}

// 네 번째 - 보기
class menu4_2 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	String ds = f.format(d);
	
	Color bg = new Color(238, 238, 238);
	String colName[] = {"DIARY", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row = 0;
	
	static String txt_content_2= "<DIARY>";
	static String xml_content_2_1 = "";
	static String xml_content_2_2 = "";

	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM DIARY where date = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String sche = rs.getString("diary");
				String date = rs.getString("datetime");
				
				Object data[] = {sche, date};
				model.addRow(data);
				
				txt_content_2 = txt_content_2 + sche + "/" + date +"*" ; //넣을 문자열
				xml_content_2_1 = xml_content_2_1 + sche + "*"; //diary중 스케줄만 갖고온 것
				xml_content_2_2 = xml_content_2_2 + date + "*"; //diary중 datetime만 갖고온 것

			}
						
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
			
			TableColumnModel tcmSchedule = table.getColumnModel(); // 정렬할 테이블의 ColumnModel을 가져옴
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // 반복문을 이용하여 테이블을 가운데 정렬로 지정
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
					
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "DIARY 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public menu4_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu4 = new JLabel("< DIARY > 보기");
		menu4.setFont(new Font("돋움체", Font.BOLD, 20));

		Color c1 = new Color(254, 67, 101);
		Color c2 = new Color(252, 157, 154);
		Color c3 = new Color(249, 205, 173);
		Color c4 = new Color(200, 200, 169);
		
		setLayout(new GridLayout(4, 1));
		
		JPanel btns_input = new JPanel();
		btns_input.setLayout(new FlowLayout());
		
		update = new JButton();
		delete = new JButton();
		
		JTextField input = new JTextField(40);
		//JPanel jp_input = new JPanel();
		//jp_input.add(input);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			   @Override
			   public void mouseReleased(MouseEvent e) {}
			   @Override
			   public void mousePressed(MouseEvent e) {}
			   @Override
			   public void mouseExited(MouseEvent e) {}
			   @Override
			   public void mouseEntered(MouseEvent e) {}
			   
			   @Override
			   public void mouseClicked(MouseEvent e) { //마우스로 선택한 행의 정보를 각각의 텍스트필드에 출력하기 
			    row = table.getSelectedRow();
			    
			    input.setText((String)model.getValueAt(row, 0));
			   }	   
		});
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				if(row<0) return;
				
				String query = "UPDATE DIARY SET diary = ?, datetime = ?, date = ?, year = ?, month = ? WHERE diary = ? AND datetime = ?";
				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// 필요한 질의문은 connection 객체를 통하여 실행
					PreparedStatement ps = connection.prepareStatement(query);
					
					//modelUpdate.fireTableDataChanged();
					ps.setString(1, input.getText());
					SimpleDateFormat fUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = fUpdate.format(d);
					ps.setString(2, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy-MM-dd");
					dsUpdate = fUpdate.format(d);
					ps.setString(3, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy");
					dsUpdate = fUpdate.format(d);
					ps.setString(4, dsUpdate);
					fUpdate = new SimpleDateFormat("MM");
					dsUpdate = fUpdate.format(d);
					ps.setString(5, dsUpdate);
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "DIARY 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				}
				model.setRowCount(0);
				select();
				input.setText("");
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getActionCommand());        // 선택된 버튼의 텍스트값 출력
				 
				 //row = table.getSelectedRow();
				 if(row<0) return; // 선택이 안된 상태면 -1리턴
				 
				 String query = "DELETE FROM DIARY WHERE diary = ? AND datetime = ?";
				 
				 try{
					 Class.forName("org.sqlite.JDBC");
					 Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					 PreparedStatement ps = connection.prepareStatement(query);
					 
					 ps.setString(1, (String)model.getValueAt(row, 0));
					 //System.out.println((String)model.getValueAt(row, 0));
					 ps.setString(2, (String)model.getValueAt(row, 1));
					 //System.out.println((String)model.getValueAt(row, 1));
					 
					 int cnt = ps.executeUpdate();
					 
					 ps.close();
					 connection.close();
				 } catch (ClassNotFoundException | SQLException e1) {
					 JOptionPane.showMessageDialog(null, "DIARY 데이터베이스 연결 오류" + e1.getMessage(), "알 림", JOptionPane.WARNING_MESSAGE);
				 }
				 
				 model.removeRow(row);
				 input.setText("");
			}
		});

		btns_input.add(update);
		btns_input.add(delete);

		update.setText("수정");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(c2);
		
		delete.setText("삭제");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(c2);
		
		add(menu4);
		add(scrollPane);
		add(input);
		add(btns_input);
	}
	 
}

public class Menu extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JPanel firstCards = new JPanel();
	public static JPanel secondCards = new JPanel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 메뉴 1, 2
					Menu menu1 = new Menu();
					menu1.setPreferredSize(new Dimension(500, 375));
					menu1.setBounds(100, 100, 450, 300);
					
					menu1.firstCards.setBorder(new EmptyBorder(0, 0, 0, 0));
					menu1.firstCards.setLayout(new CardLayout(0, 0));
					menu1.add(firstCards);
					
					menu1_1 menu1_1 = new menu1_1(menu1);
					menu1_2 menu1_2 = new menu1_2(menu1);
					menu2_1 menu2_1 = new menu2_1(menu1);
					menu2_2 menu2_2 = new menu2_2(menu1);
					
					menu1.firstCards.add(menu1_1, "menu1_1");
					menu1.firstCards.add(menu1_2, "menu1_2");
					menu1.firstCards.add(menu2_1, "menu2_1");
					menu1.firstCards.add(menu2_2, "menu2_2");
					
					First_Menubar menubar1 = new First_Menubar(menu1);
					
					//메뉴 3, 4
					Menu menu2 = new Menu();
					menu2.setPreferredSize(new Dimension(500, 375));
					menu2.setBounds(100, 100, 450, 300);
				
					menu2.firstCards.setBorder(new EmptyBorder(0, 0, 0, 0));
					menu2.firstCards.setLayout(new CardLayout(0, 0));
					menu2.add(firstCards);
					
					menu3_1 menu3_1 = new menu3_1(menu1);
					menu3_2 menu3_2 = new menu3_2(menu1);
					menu4_1 menu4_1 = new menu4_1(menu1);
					menu4_2 menu4_2 = new menu4_2(menu1);
					
					menu2.firstCards.add(menu3_1, "menu3_1");
					menu2.firstCards.add(menu3_2, "menu3_2");
					menu2.firstCards.add(menu4_1, "menu4_1");
					menu2.firstCards.add(menu4_2, "menu4_2");
					
					Second_Menubar menubar2 = new Second_Menubar(menu2);
					
					JFrame jf = new JFrame("Cardlayout");
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setPreferredSize(new Dimension(500,750));
					jf.setBackground(Color.WHITE);
					
					Box boxlayout = Box.createVerticalBox();
					boxlayout.add(menubar1);
					boxlayout.add(Box.createVerticalStrut(10));
					boxlayout.add(menu1);
					boxlayout.add(Box.createVerticalStrut(10));
					boxlayout.add(menubar2);
					boxlayout.add(Box.createVerticalStrut(10));
					boxlayout.add(menu2);
					jf.add(boxlayout, BorderLayout.CENTER);
					jf.pack();
					jf.setVisible(true);
					
					String fileName_txt = "Info_OnedayWirte.txt";
					
					try{

						// txt 파일 생성 부분
						String txt = menu3_2.txt_content_1 + menu4_2.txt_content_2;
						try{
							// 파일 객체 생성
				
							File file = new File("Info_OnedayWirte.txt");
							file.createNewFile();
							// true 지정시 파일의 기존 내용에 이어서 작성
							BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "UTF-8"));
	
							// 파일안에 문자열 쓰기
							fw.write(txt);
							fw.flush();
							// 객체 닫기
							fw.close();
							
							System.out.println(txt);
						} catch (Exception e){
							e.printStackTrace();
						}
						// txt 파일 생성 부분

					} catch(Exception e){
						e.printStackTrace();
					}

					// XML 파일 생성 부분
					Document doc = new DocumentImpl();
					Element root = doc.createElement("Information");
					//여기가 일기 부분
					Element diary = doc.createElement("Diary"); //<Diary>
					Element content_d = doc.createElement("content"); //content
					Element datetime_d = doc.createElement("datetime"); //datetime
					content_d.setTextContent(menu4_2.xml_content_2_1);
					datetime_d.setTextContent(menu4_2.xml_content_2_2);

					//여기가 Q&A 부분
					Element qa = doc.createElement("QA"); //<QA>
					Element content_qa = doc.createElement("content_qa"); //content_q
					Element datetime_qa = doc.createElement("datetime_qa"); //datetime_qa
					content_qa.setTextContent(menu3_2.xml_content_1_2);
					datetime_qa.setTextContent(menu3_2.xml_content_1_3);

					root.appendChild(diary);
					diary.appendChild(content_d);
					diary.appendChild(datetime_d);

					root.appendChild(qa);
					qa.appendChild(content_qa);
					qa.appendChild(datetime_qa);

					doc.appendChild(root);
					String fileName_xml = "info_onedaywrite.xml";
					try
					{
						FileOutputStream fileoutputstream = new FileOutputStream(new File("info_onedaywrite.xml"));
						OutputFormat outputformat = new OutputFormat();
						//outputformat.setEncoding("UTF-8");
						outputformat.setIndent(4);
						outputformat.setIndenting(true);
						outputformat.setPreserveSpace(false);

						XMLSerializer serializer = new XMLSerializer();
						serializer.setOutputFormat(outputformat);
						serializer.setOutputByteStream(fileoutputstream);
						serializer.asDOMSerializer();
						serializer.serialize(doc.getDocumentElement());

						StringWriter stringOut = new StringWriter();
						XMLSerializer str_serial = new XMLSerializer( stringOut, outputformat );
						str_serial.asDOMSerializer();
						str_serial.serialize( doc.getDocumentElement() );

						System.out.println(stringOut.toString());
					} catch (Exception e)
					{
						e.printStackTrace();
					} // XML파일 생성 부분


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}