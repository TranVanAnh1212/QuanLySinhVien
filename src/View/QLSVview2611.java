package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import Controls.QLSVControl2611;
import Controls.QLSVControlKeyPress2611;
import Files.readFromFile2611;
import Model.Dates;
import Model.QLSVModel2611;
import Model.Student2611;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class QLSVview2611 extends JFrame {
	
	private QLSVControl2611 control;
	private QLSVControlKeyPress2611 ctrlKP = new QLSVControlKeyPress2611();
	private QLSVModel2611 model;
	
	private JPanel contentPane;
	public JTextField txtMaSv;
	public JTextField txtTenSv;
	public JTextField txtQueQuan;
	public JTextField txtNganhHoc;
	public JTextField txtDiemTichLuy;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public ButtonGroup btnG;
	public JMenuItem mnItemSave;
	public JMenuItem mnItemExit;
	public JTextField txtSearch_Id;
	public JButton btnUpdate;
	public JButton btnDelete;
	private JPanel pnlStudentInformation;
	private JPanel pnlControl;
	public JMenuItem mnItemLogIn;
	public JMenuItem mnItemLogOut;
	private JButton btnSearch;
	public JButton btnInsert;
	private JTable table;
	public JMenuItem mnItemFAQ;
	public JMenuItem mnItemAbout;
	public JTextField txtDay;
	public JTextField txtMonth;
	public JTextField txtYear;
	public JMenuItem mnItemShowListStu;
	private JPanel contentPanel_Login;
	public JPasswordField pwPassword;
	public JTextField txtUserName;
	public JDialog dialogLogIn;
	public JButton btnDialogLogIn;
	public JButton btnDialogCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVview2611 myFrame = new QLSVview2611();
					myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVview2611() {
		this.model = new QLSVModel2611();
		this.ctrlKP = new QLSVControlKeyPress2611();
		this.control  = new QLSVControl2611(this);
		
		setIconImage( getIcons( "Student-MaleFemale") );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 628);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
		mnItemSave = new JMenuItem("Save");
		mnItemSave.setIcon(new ImageIcon( getIcons( "save")));
		mnItemSave.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnItemSave.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		mnItemSave.addActionListener(control);
		
		mnItemLogIn = new JMenuItem("Log In");
		mnItemLogIn.setIcon( new ImageIcon( getIcons( "Button-Log-In")));
		mnItemLogIn.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnFile.add(mnItemLogIn);
		mnItemLogIn.addActionListener(control);
		
		mnItemLogOut = new JMenuItem("Log Out");
		mnItemLogOut.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnItemLogOut.setIcon( new ImageIcon( getIcons( "system-log-out")));
		mnFile.add(mnItemLogOut);
		mnItemLogOut.addActionListener(control);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		mnFile.add(mnItemSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mnItemExit = new JMenuItem("Exit");
		mnItemExit.setIcon(new ImageIcon( getIcons( "Close-2")));
		mnItemExit.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnItemExit.addActionListener(control);
		mnItemExit.setAccelerator( KeyStroke.getKeyStroke( (char) KeyEvent.VK_ESCAPE));
		mnFile.add(mnItemExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnEdit);
		
		JMenuItem mnItemUndo = new JMenuItem("Undo");
		mnItemUndo.setIcon(new ImageIcon( getIcons( "Arrows-Undo")));
		mnItemUndo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnItemUndo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		mnEdit.add(mnItemUndo);
		
		JMenuItem mnItemRedo = new JMenuItem("Redo");
		mnItemRedo.setIcon(new ImageIcon( getIcons( "Arrows-Redo" ) ));
		mnItemRedo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
		mnEdit.add(mnItemRedo);
		
		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);
		
		mnItemShowListStu = new JMenuItem("Show list students");
		mnItemShowListStu.setIcon(new ImageIcon( getIcons( "Programming-Show-Property" ) ));
		mnItemShowListStu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnItemShowListStu.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | java.awt.Event.SHIFT_MASK ));
		mnItemShowListStu.addActionListener(control);
		mnEdit.add(mnItemShowListStu);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAbout);
		
		mnItemFAQ = new JMenuItem("Help");
		mnItemFAQ.setIcon(new ImageIcon( getIcons("FAQ") ));
		mnItemFAQ.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAbout.add(mnItemFAQ);
		
		mnItemAbout = new JMenuItem("About");
		mnItemAbout.setIcon(new ImageIcon( getIcons( "Very-Basic-About")));
		mnItemAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnItemAbout.addActionListener(control);
		mnAbout.add(mnItemAbout);
		contentPane = new JPanel();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlStudentInformation = new JPanel();
		pnlStudentInformation.setBorder(
				new TitledBorder( 
						new EtchedBorder(
								EtchedBorder.LOWERED, 
								new Color(255, 255, 255), 
								new Color(160, 160, 160)), 
						"Th\u00F4ng Tin Sinh Vi\u00EAn", 
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)
						)
				);
		pnlStudentInformation.setBounds(10, 179, 746, 191);
		contentPane.add(pnlStudentInformation);
		pnlStudentInformation.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Mã Sinh Viên:");
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(10, 34, 114, 30);
		pnlStudentInformation.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Tên Sinh Viên:");
		lblStudentName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentName.setBounds(10, 74, 114, 30);
		pnlStudentInformation.add(lblStudentName);
		
		JLabel lblStudentBirth = new JLabel("Ngày Sinh:");
		lblStudentBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentBirth.setBounds(10, 114, 114, 30);
		pnlStudentInformation.add(lblStudentBirth);
		
		JLabel lblStudentGender = new JLabel("Giới Tính:");
		lblStudentGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentGender.setBounds(10, 154, 114, 30);
		pnlStudentInformation.add(lblStudentGender);
		
		JLabel lblStudentAddress = new JLabel("Quê Quán:");
		lblStudentAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentAddress.setBounds(389, 34, 114, 30);
		pnlStudentInformation.add(lblStudentAddress);
		
		JLabel lblStudentMajor = new JLabel("Ngành Học:");
		lblStudentMajor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentMajor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentMajor.setBounds(389, 74, 114, 30);
		pnlStudentInformation.add(lblStudentMajor);
		
		JLabel lblStudentGPA = new JLabel("Điểm Tích Lũy:");
		lblStudentGPA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentGPA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentGPA.setBounds(389, 114, 114, 30);
		pnlStudentInformation.add(lblStudentGPA);
		
		txtMaSv = new JTextField();
		txtMaSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSv.setBounds(128, 34, 229, 30);
		pnlStudentInformation.add(txtMaSv);
		txtMaSv.requestFocus();
		txtMaSv.setColumns(10);
		
		txtTenSv = new JTextField();
		txtTenSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSv.setColumns(10);
		txtTenSv.setBounds(128, 74, 229, 30);
		pnlStudentInformation.add(txtTenSv);
		
		txtQueQuan = new JTextField();
		txtQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQueQuan.setColumns(10);
		txtQueQuan.setBounds(507, 34, 229, 30);
		pnlStudentInformation.add(txtQueQuan);
		
		txtNganhHoc = new JTextField();
		txtNganhHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNganhHoc.setColumns(10);
		txtNganhHoc.setBounds(507, 74, 229, 30);
		pnlStudentInformation.add(txtNganhHoc);
		
		txtDiemTichLuy = new JTextField();
		txtDiemTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiemTichLuy.setColumns(10);
		txtDiemTichLuy.setBounds(507, 114, 229, 30);
		pnlStudentInformation.add(txtDiemTichLuy);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNam.setBounds(155, 154, 60, 30);
		pnlStudentInformation.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNu.setBounds(260, 154, 51, 30);
		pnlStudentInformation.add(rdbtnNu);
		
		btnG = new ButtonGroup();
		btnG.add(rdbtnNu);
		btnG.add(rdbtnNam);
		
		txtDay = new JTextField();
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDay.setBounds(128, 114, 51, 30);
		pnlStudentInformation.add(txtDay);
		txtDay.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(186, 114, 15, 30);
		pnlStudentInformation.add(lblNewLabel);
		
		txtMonth = new JTextField();
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMonth.setColumns(10);
		txtMonth.setBounds(211, 114, 51, 30);
		pnlStudentInformation.add(txtMonth);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtYear.setColumns(10);
		txtYear.setBounds(297, 114, 60, 30);
		pnlStudentInformation.add(txtYear);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(272, 113, 15, 30);
		pnlStudentInformation.add(lblNewLabel_1);
		
		pnlControl = new JPanel();
		pnlControl.setBorder(
				new TitledBorder(
						null, 
						"", 
						TitledBorder.LEADING, 
						TitledBorder.TOP, 
						null, 
						null
						)
				);
		pnlControl.setBounds(10, 481, 746, 67);
		contentPane.add(pnlControl);
		pnlControl.setLayout(null);
		
		btnInsert = new JButton("Thêm");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.setBounds(10, 21, 133, 34);
		btnInsert.addActionListener(control);
		btnInsert.addKeyListener(ctrlKP);
		pnlControl.add(btnInsert);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(404, 21, 133, 34);
		btnDelete.addActionListener(control);
		pnlControl.add(btnDelete);
		
		btnDialogCancel = new JButton("Hủy");
		btnDialogCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDialogCancel.setBounds(601, 21, 133, 34);
		btnDialogCancel.addActionListener(control);
		pnlControl.add(btnDialogCancel);
		
		btnUpdate = new JButton("Cập Nhật");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(207, 21, 133, 34);
		btnUpdate.addActionListener(control);
		pnlControl.add(btnUpdate);
		
		JPanel pnlSearchStudent = new JPanel();
		pnlSearchStudent.setBorder(
				new TitledBorder(
						new EtchedBorder(
								EtchedBorder.LOWERED, 
								new Color(255, 255, 255), 
								new Color(160, 160, 160)), 
								"T\u00ECm Ki\u1EBFm Sinh Vi\u00EAn", 
								TitledBorder.CENTER, TitledBorder.TOP, 
								null, 
								new Color(0, 0, 0)
						)
				);
		pnlSearchStudent.setBounds(10, 380, 746, 79);
		contentPane.add(pnlSearchStudent);
		pnlSearchStudent.setLayout(null);
		
		btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setBounds(538, 22, 133, 34);
		btnSearch.addActionListener(control);
		pnlSearchStudent.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSearch_Id = new JLabel("Nhập Mã Sinh Viên Muốn Tìm:");
		lblSearch_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearch_Id.setBounds(39, 22, 205, 30);
		pnlSearchStudent.add(lblSearch_Id);
		
		txtSearch_Id = new JTextField();
		txtSearch_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSearch_Id.setColumns(10);
		txtSearch_Id.setBounds(265, 25, 230, 30);
		pnlSearchStudent.add(txtSearch_Id);
		
		JPanel pnlDisplayStudentList = new JPanel();
		pnlDisplayStudentList.setBorder(
				new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
						"Hi\u1EC3n th\u1ECB th\u00F4ng tin sinh vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDisplayStudentList.setBounds(10, 10, 746, 159);
		contentPane.add(pnlDisplayStudentList);
		pnlDisplayStudentList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 726, 128);
		pnlDisplayStudentList.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "Qu\u00EA qu\u00E1n", "Ng\u00E0nh h\u1ECDc", "\u0110i\u1EC3m t\u00EDch l\u0169y"
			}
		));
		table.getTableHeader().setFont( new Font( "Arial" , Font.PLAIN, 14 )); // set font for title column
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		// ===== Dialog ===============
		dialogLogIn = new JDialog();
		dialogLogIn.setTitle("Đăng Nhập");
		dialogLogIn.setBounds(100, 100, 405, 230);
		dialogLogIn.getContentPane().setLayout(new BorderLayout());
		contentPanel_Login = new JPanel();
		contentPanel_Login.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel_Login, BorderLayout.CENTER);
		contentPanel_Login.setLayout(null);
		dialogLogIn.add(contentPanel_Login);
		
		JLabel lblUserName = new JLabel("Tên Đăng Nhập:");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(10, 10, 111, 38);
		contentPanel_Login.add(lblUserName);
		
		JLabel lblPassWord = new JLabel("Mật Khẩu");
		lblPassWord.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassWord.setBounds(10, 70, 111, 38);
		contentPanel_Login.add(lblPassWord);
		
		btnDialogLogIn = new JButton("Đăng Nhập");
		btnDialogLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDialogLogIn.setBounds(36, 135, 150, 38);
		btnDialogLogIn.addActionListener(control);
		contentPanel_Login.add(btnDialogLogIn);
		
		btnDialogCancel = new JButton("Hủy");
		btnDialogCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDialogCancel.setBounds(223, 135, 150, 38);
		btnDialogCancel.addActionListener(control);
		contentPanel_Login.add(btnDialogCancel);
		
		pwPassword = new JPasswordField();
		pwPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwPassword.setEchoChar('*');
		pwPassword.setBounds(138, 70, 235, 38);
		contentPanel_Login.add(pwPassword);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserName.setColumns(10);
		txtUserName.setBounds(138, 10, 235, 38);
		contentPanel_Login.add(txtUserName);
		dialogLogIn.setLocationRelativeTo(null);
		
		
		this.setLocationRelativeTo(null);
		this.setTitle("Quản Lý Sinh Viên.");
		this.setVisible(true);
		this.dialogLogIn.setVisible(true);
		this.update_Delete_Enabled(false);
		this.ComponentIsEnabled(false);

	}
	
//	phương thức set Icon 
	private Image getIcons( String iconName ) {
		URL icon = QLSVview2611.class.getResource( "/imagins/"+ iconName +"-icon.png");
		return Toolkit.getDefaultToolkit().createImage(icon);
	}
	
	public void update_Delete_Enabled( boolean enable )  {
		this.btnUpdate.setEnabled(enable);
		this.btnDelete.setEnabled(enable);
	}
	
//	phương thức setEnabled cho các component trước khi đăng nhập
	public void ComponentIsEnabled ( boolean enable) {
//		khung nhập dữ liệu
		txtMaSv.setEnabled(enable);
		txtTenSv.setEnabled(enable);
		txtDay.setEnabled(enable);
		txtMonth.setEnabled(enable);
		txtYear.setEnabled(enable);
		txtQueQuan.setEnabled(enable);
		txtNganhHoc.setEnabled(enable);
		rdbtnNam.setEnabled(enable);
		rdbtnNu.setEnabled(enable);
		txtDiemTichLuy.setEnabled(enable);
		
//		khung tìm kiếm
		txtSearch_Id.setEnabled(enable);
	
//		khung các button
		btnInsert.setEnabled(enable);
		btnDialogCancel.setEnabled(enable);
		btnSearch.setEnabled(enable);
		rdbtnNam.setEnabled(enable);
		rdbtnNu.setEnabled(enable);
		btnG.clearSelection();
		
//		khung menuItem
		mnItemLogOut.setEnabled(enable);
		mnItemLogIn.setEnabled( !enable );
		
	}

//	xóa trắng các textField
	public void deleteForm() {
		this.txtMaSv.setText("");
		this.txtTenSv.setText("");
		this.txtDay.setText("");
		this.txtMonth.setText("");
		this.txtYear.setText("");
		this.btnG.clearSelection();
		this.txtQueQuan.setText("");
		this.txtNganhHoc.setText("");
		this.txtDiemTichLuy.setText("");
		this.txtMaSv.requestFocus();
	}
		
//	add Student to Table
	public void addRowTable(String studentId, String studentName, Dates studentBirth, boolean gender, 
			String studentAddress, String studentMajor, double studentGPA ) 
	{
		String isGender = ( gender == true ) ? "Nam" : "Nữ";
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(
        		new Object[]
        				{ studentId, studentName, studentBirth, isGender, studentAddress, studentMajor, studentGPA}
        		);
	}
	
//	phương thức xóa 1 row trong bảng
	public void deleteRowTable( String studentId) {
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		for ( int i = 0; i < rowCount; i++) {
			String idFind =String.valueOf( model_tb.getValueAt(i, 0)) ;
			if ( idFind.equals( studentId )) {
				model_tb.removeRow(i);
				break;
			}
			
		}
		
	}

//	phương thức hiển thị kết quả tìm kiếm
	public void showSearchResult(Student2611 sv) {
		String data = sv.toString();
		
		this.txtMaSv.setText(sv.getStudentId());
		this.txtTenSv.setText(sv.getStudentName());
		this.txtDay.setText( "0" + String.valueOf( sv.getStudentBirth().getDay()) );
		this.txtMonth.setText( "0" + String.valueOf( sv.getStudentBirth().getMonth() ));
		this.txtYear.setText( String.valueOf( sv.getStudentBirth().getYear() ));
		if ( sv.getGender() ) {
			this.rdbtnNam.setSelected(true);
		} 
		
		if ( !sv.getGender() ) {
			this.rdbtnNu.setSelected(true);
		}
		this.txtQueQuan.setText(sv.getStudentAddress());
		this.txtNganhHoc.setText(sv.getStudentMajor());
		this.txtDiemTichLuy.setText(Double.toString(sv.getStudentGPA()));
	}
	
//	cập nhật sinh viên có trong bảng
	public void updateStudent( String studentId, String studentName, Dates studentBirth, boolean gender, 
			String studentAddress, String studentMajor, double studentGPA ) 
	{
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		for ( int i = 0; i < rowCount; i++) {
			String idFind =String.valueOf( model_tb.getValueAt(i, 0)) ;
			if ( idFind.equals( studentId )) {
				model_tb.setValueAt( studentName, i, 1);
				model_tb.setValueAt( studentBirth, i, 2);
				model_tb.setValueAt( gender == true ? "Nam" : "Nữ", i, 3);
				model_tb.setValueAt( studentAddress, i, 4);
				model_tb.setValueAt( studentMajor, i, 5);
				model_tb.setValueAt( String.valueOf( studentGPA ), i, 6);
				break;
			}
		}
	}
	
//	các phương thức để lấy các giá trị từ các textField
	public void non_editable( boolean bool) {
		this.txtMaSv.setEditable(bool);
	}
	
	public String getTextStudentId() {
		return this.txtMaSv.getText();
	}
	
	public String getTextStudentName() {
		return this.txtTenSv.getText();
	}
	
	public int  getTextDay() {
		return Integer.parseInt( this.txtDay.getText()) ;
	}
	
	public int getTextMonth() {
		return Integer.parseInt( this.txtMonth.getText() );
	}
	
	public int getTextYear() {
		return Integer.parseInt( this.txtYear.getText() );
	}
	
	public boolean  getTextStudentGender() {
		if ( this.rdbtnNam.isSelected() ) return true;
		if ( this.rdbtnNu.isSelected() ) return false;
		return true ;
	}
	
	public String getTextStudentAddress() {
		return this.txtQueQuan.getText();
	}
	
	public String getTextStudentMajor() {
		return this.txtNganhHoc.getText();
	}
	
	public String getTextStudentGPA() {
		return this.txtDiemTichLuy.getText();
	}

	
}

	