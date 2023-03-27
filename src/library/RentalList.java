package library;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * 대출 목록 조회 클래스
 */

public class RentalList extends JFrame implements ActionListener{

	public DatabaseClass db;
	
	// 책 목록이 보여질 테이블
	private JTable table;
	// 테이블의 다양한 기능을 사용할 클래스 생성
	private DefaultTableModel tableModel;
    
    // 기본 생성자
    public RentalList() {
    }
    
    public RentalList(DatabaseClass db) {
    	this.db = db;
    	
    	// 테이블 세팅
    	String[] columnNames = {"이름", "핸드폰 번호", "대여목록", "대여기간"};
    	List<Rental> rentalList = db.getRentalList();
    	Object[][] data = new Object[rentalList.size()][4];
    	
    	for (int i = 0; i < rentalList.size(); i++) {
			Rental rental = rentalList.get(i);
			data[i][0] = rental.getName();
			data[i][1] = rental.getPhone();
			data[i][2] = rental.getInventory();
			data[i][3] = rental.getPeriod();
		}
    	
    	tableModel = new DefaultTableModel(data, columnNames);
    	table = new JTable(tableModel);
    	
    	JButton closeButton = new JButton("닫기");
    	
    	// 액션 리스너 부착
    	closeButton.addActionListener(this);
    	
    	// 메인 패널 생성
    	JPanel mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
    	
    	// 입력 필드들이 놓을 input 패널 생성
    	JPanel inputPanel = new JPanel();
    	inputPanel.setLayout(new GridLayout(5,2));
    	
    	// input 패널을 메인 패널에 다시 부착
    	mainPanel.add(inputPanel, BorderLayout.SOUTH);
    	mainPanel.add(closeButton, BorderLayout.SOUTH);
    	
    	// 프레임 설정
    	setTitle("대여 정보 조회");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setContentPane(mainPanel);
    	pack();
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    	this.dispose();
    	
    	MainMenu mainMenu = new MainMenu(db);
    	mainMenu.setVisible(true);
    }
    public static void main(String[] args) {
    	new RentalList(new DatabaseClass());
    }
}
