package Controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Dates;
import Model.LogIn2611;
import Model.QLSVModel2611;
import Model.Student2611;
import View.Dialog_About_Me;
import View.QLSVview2611;

public class QLSVControl2611 implements ActionListener {
	private QLSVview2611 view2611;
	private Student2611 sv;
	private QLSVModel2611 model = new QLSVModel2611();
	private LogIn2611 logIn = new LogIn2611();
		
	public QLSVControl2611() {
		super();
	}

	public QLSVControl2611(QLSVview2611 view2611) {
			super();
			this.view2611 = view2611;
			sv = new Student2611();
			
		}
	
	// KHU VỰC BẮT SỰ KIỆN  
	@Override
	public void actionPerformed(ActionEvent e) {
		String pressBtn = e.getActionCommand();
		
		//BĂT SỰ KIỆN CHO MenuItem THOÁT
		if ( e.getSource() == view2611.mnItemExit) {
			int a = JOptionPane.showConfirmDialog(view2611, "Xác Nhận Thoát ? ", "Cảnh Báo !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if ( a == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		// BẮT SỰ KIỆN MENUITEM LƯU
		if ( e.getSource() == this.view2611.mnItemSave ) {
			this.model.writeDataToFile();
			JOptionPane.showMessageDialog(view2611, "Lưu thành công !", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		}
		
//		 BẮT SỰ KIỆN MENUITEM ĐĂNG NHẬP
		if ( e.getSource() == this.view2611.mnItemLogIn ) {

		}
		
		// BẮT SỰ KIỆN MENUITEM ĐĂNG XUẤT
		if ( e.getSource() == this.view2611.mnItemLogOut ) {
			JOptionPane.showMessageDialog(view2611, "Đã Đăng Xuất", "Thông Báo", JOptionPane.OK_OPTION);
			this.view2611.deleteForm();
			this.view2611.ComponentIsEnabled(false);
			
		}
		
//		BẮT SỰ KIỆN MENUITEM HIỂN THỊ DS SV
		if ( e.getSource() == this.view2611.mnItemShowListStu ) {
//			this.model.arrSv = readFromFile2611.read();
//			System.out.println("Sau khi an show stu ");
			this.model.displayStudent();
		}
		
//		BẮT SỰ KIỆN MENUITEM ABOUT		
		if ( e.getSource() == this.view2611.mnItemAbout) {
			new Dialog_About_Me();
		}
		
		
		// BẮT SỰ KIỆN CHO NÚT THÊM SINH VIÊN
		if ( pressBtn.equals("Thêm")) {
			try {
				this.btnInsertStudent();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		// BẮT SỰ KIỆN CHO NÚT XÓA SINH VIÊN
		if ( pressBtn.equals("Xóa")) {
			this.btnDeleteStudent();
		} 
		
		// BẮT SỰ KIỆN CHO NÚT TÌM KIẾM SINH VIÊN
		if ( pressBtn.equals("Tìm Kiếm") ) {
			this.btnSearchStudent(sv);
			
		} 
		
		// BẮT SỰ KIỆN CHO NÚT HỦY
		if ( pressBtn.equals("Hủy")) {
			this.btnCancel();
			
		} 
		
		// BẮT SỰ KIỆN CHO NÚT CẬP NHẬT
		if (pressBtn.equals("Cập Nhật")) {
			this.btnUpdateStudent();
			
		}
		
		// Dialog Control actionListenner
		
		if ( e.getSource() == this.view2611.btnDialogLogIn ) {
			this.checkAccount();
		}
		
		if ( e.getSource() == this.view2611.btnDialogCancel ) {
			this.view2611.dialogLogIn.setVisible(false);
		}
	}
	
	
//	KHU VỰC BẮT SỰ KIỆN CHO JFRAME QLSVView2611
	
	// phuong thức cập nhật sinh viên
	private void btnUpdateStudent() {
		try {
			String maSv = this.view2611.txtMaSv.getText();
			String tenSv = this.view2611.txtTenSv.getText();
			int day = Integer.parseInt( this.view2611.txtDay.getText());
			int month = Integer.parseInt( this.view2611.txtMonth.getText());
			int year = Integer.parseInt( this.view2611.txtYear.getText());
			Dates studentBirth = new Dates(day, month, year);
			boolean gioiTinh = true;
			if ( this.view2611.rdbtnNam.isSelected() ) {
				gioiTinh = true;
			}
			if ( this.view2611.rdbtnNu.isSelected() ) {
				gioiTinh = false;
			}
			String queQuan = this.view2611.txtQueQuan.getText();
			String nganhHoc = this.view2611.txtNganhHoc.getText();
			double diemTichLuy = Double.parseDouble( this.view2611.txtDiemTichLuy.getText() );
			
			if ( this.model.search(sv, maSv) != null ) {
				sv = this.model.search(sv, maSv);
				model.UpdateStudent(maSv, tenSv, studentBirth, gioiTinh, queQuan, nganhHoc, diemTichLuy);
				view2611.updateStudent(maSv, tenSv, studentBirth, gioiTinh, queQuan, nganhHoc, diemTichLuy);
				model.displayStudent();
			}
			
			this.view2611.deleteForm();
			this.view2611.non_editable(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// PHƯƠNG THỨC XÓA SINH VIÊN
	private void btnDeleteStudent() {
		Boolean isSuccess = false; // tạo một biến lưu trữ trạng thái là false
		String MaSvMuonXoa = this.view2611.txtMaSv.getText(); // kiểm tra xem mã sv muốn xóa có giống mã sv nhập vào từ textField xóa hay không
		if ( this.model.search(sv, MaSvMuonXoa) != null ) { // nếu kết quả tìm kiếm khác rỗng
			sv = this.model.search(sv, MaSvMuonXoa); // gán cho biến sv là sinh viên đã tìm được
			isSuccess = true; // trạng thái chuyển về true
			this.model.deleteStu(sv); // gọi phương thức xóa sv
			
		}
		
		if ( isSuccess ) { // nếu trạng thái là true, thông báo là đã xóa thành công
			JOptionPane.showMessageDialog(view2611, "Xóa Thành Công !" , "Thông Báo", JOptionPane.OK_OPTION);
			this.model.displayStudent();
			this.view2611.deleteForm(); // xóa trắng các formoo textField
			this.view2611.deleteRowTable(MaSvMuonXoa);
			this.view2611.non_editable(true);
			this.view2611.update_Delete_Enabled(false);
		} else { // nếu biến trạng thái là false, thông báo không thành công
			JOptionPane.showConfirmDialog(view2611, "Xóa Không Thành Công" , "Thông Báo", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

	// PHƯƠNG THỨC HỦY CHO NÚT HỦY
	private void btnCancel() {
		int a = JOptionPane.showConfirmDialog(view2611, "Xác Nhận Hủy ? ", "Cảnh Báo !", JOptionPane.YES_NO_OPTION);
		if ( a == JOptionPane.YES_OPTION) {
			this.view2611.deleteForm();
			this.view2611.txtMaSv.setEditable(true);
		}
	}

	//PHƯƠNG THỨC THÊM SINH VIÊN CHO NÚT THÊM 
	private void btnInsertStudent() {
		String studentID = this.view2611.getTextStudentId();
		String studentName = this.view2611.getTextStudentName();
		Dates studentBirth = new Dates(this.view2611.getTextDay(), this.view2611.getTextMonth(), this.view2611.getTextYear());
		boolean studentGender = this.view2611.getTextStudentGender();
		String studentAddress = this.view2611.getTextStudentAddress();
		String studentMajor = this.view2611.getTextStudentMajor();
		double studentGPA = Double.parseDouble( this.view2611.getTextStudentGPA());
		
		Student2611 sv = new Student2611(studentID, studentName, studentBirth, studentGender, studentAddress, studentMajor, studentGPA);
		
		JOptionPane.showMessageDialog(view2611, "Thêm Sinh Viên Thành Công !", "Thông Báo", JOptionPane.NO_OPTION);
		this.view2611.addRowTable(studentID, studentName, studentBirth, studentGender, studentAddress, studentMajor, studentGPA);
		this.view2611.deleteForm();
		this.model.insert(sv);
		this.model.displayStudent();
	}
	
	private double checkGPA() {
		double diemTichLuy = 0;
		if ( this.view2611.txtDiemTichLuy.getText() != "") {
			diemTichLuy = Double.parseDouble( this.view2611.txtDiemTichLuy.getText());
			if ( diemTichLuy < 0 && diemTichLuy > 4) {
				this.view2611.txtDiemTichLuy.setText("");
				JOptionPane.showMessageDialog(view2611, "Điểm tích lũy không được vượt quá 4.0", "Thông Báo", JOptionPane.YES_OPTION);
				return checkGPA();
			} else {
				return diemTichLuy;
			}
			
		}
		
		return diemTichLuy;
	}

	// PHƯƠNG THỨC TÌM KIẾM SINH VIÊN CHO NÚT TÌM KIẾM 
	public Student2611 btnSearchStudent(Student2611 sv) {
		String MaSvMuonTim = this.view2611.txtSearch_Id.getText();
		if ( this.model.search(sv, MaSvMuonTim) != null ) {
			sv = this.model.search(sv, MaSvMuonTim) ;
			this.view2611.showSearchResult(sv);
			this.view2611.non_editable(false);
			this.view2611.btnInsert.setEnabled(false);
			this.view2611.update_Delete_Enabled(true);
			this.view2611.txtSearch_Id.setText("");
			return sv;
		} else {
			JOptionPane.showConfirmDialog(view2611, "Không tìm thấy sinh viên nào", "Lỗi", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public boolean isUserName() {
		String userName = this.view2611.txtUserName.getText();
		return (userName.equals( this.logIn.getTenDangNhap())) ? true : false;
	}
	
	public boolean isPassword() {
		String password = String.valueOf( this.view2611.pwPassword.getPassword());
		return (password.equals(password)) ? true : false;
	}
	
	
	// Dialog Đăng nhập
	public void checkAccount() {
		if ( isPassword() && isUserName()) {
			this.view2611.ComponentIsEnabled(true);
			JOptionPane.showMessageDialog(view2611, "Đăng nhập thành công!");
			this.view2611.dialogLogIn.setVisible(false);
			this.view2611.txtMaSv.requestFocus();
		} else {
			JOptionPane.showMessageDialog(view2611, "Đăng nhập không thành công!");
		}
	}
	
	
}
