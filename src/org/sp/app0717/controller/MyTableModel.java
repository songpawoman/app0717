package org.sp.app0717.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import org.sp.app0717.model.EmpDAO;

//Model과 View를 분리시켜 개발하기 위해서는 컨트롤러가 중재해야 하고, 
//javase 의 JTable에서의 컨트롤러 역할은 TableModel 인터페이스가 담당
public class MyTableModel extends AbstractTableModel{
	EmpDAO empDAO;
	String[][] data;
	
	public MyTableModel() {
		empDAO = new EmpDAO();
		data=empDAO.selectAll();//사원 정보 가져오기
	}
	//아래의 오버라이딩 된 모든~ 메서드는 개발자가 호출하는것이 아니라, 
	//JTable이 표를 어떻게 보여줄지를 결정하는 데이터이기 때문에, JTable이 스스로 호출
	public int getRowCount() {
		//System.out.println("getRowCount() 호출");
		return data.length;
	}
	public int getColumnCount() {
		//System.out.println("getColumnCount() 호출");
		return data[0].length;
	}
	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+", "+col+") 호출");
		return data[row][col];
	}

}





