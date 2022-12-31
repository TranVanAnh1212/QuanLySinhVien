package TestView;

import javax.swing.UIManager;

import Model.QLSVModel2611;
import View.QLSVview2611;

public class testView2611 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSVview2611();
			QLSVModel2611 model = new QLSVModel2611();
			System.out.println("Trc khi an show stu");
//			model.arrSv = readFromFile2611.read();
			model.displayStudent();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
