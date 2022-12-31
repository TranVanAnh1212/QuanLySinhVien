package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_About_Me extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_About_Me dialog = new Dialog_About_Me();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_About_Me() {
		setTitle("About Me");
		setBounds(100, 100, 450, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information of Student Management", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 416, 258);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Infor_Dev = new JLabel("Dev: Trần văn Anh");
		lbl_Infor_Dev.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Infor_Dev.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Infor_Dev.setBounds(10, 24, 396, 28);
		panel.add(lbl_Infor_Dev);
		
		JLabel lbl_Infor = new JLabel("Được khởi công vào ngày 26/11/2022.  ");
		lbl_Infor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Infor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Infor.setBounds(10, 62, 396, 28);
		panel.add(lbl_Infor);
		
		JLabel lbl_Infor_1 = new JLabel("Sử dụng ngôn ngữ lập trình Java");
		lbl_Infor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Infor_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Infor_1.setBounds(10, 100, 396, 28);
		panel.add(lbl_Infor_1);
		
		JLabel lbl_Infor_1_1 = new JLabel("Đây là một ứng dụng quản lý Sinh viên");
		lbl_Infor_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Infor_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Infor_1_1.setBounds(10, 138, 396, 28);
		panel.add(lbl_Infor_1_1);
		
		JLabel lbl_Infor_1_2 = new JLabel("Hiện đang còn trong thời gian xây dựng và hoàn thiện");
		lbl_Infor_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Infor_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Infor_1_2.setBounds(10, 176, 396, 42);
		panel.add(lbl_Infor_1_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 278, 436, 39);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				okButton.setBounds(101, 0, 232, 37);
				buttonPane.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
