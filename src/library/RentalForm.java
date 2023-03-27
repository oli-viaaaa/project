package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RentalForm extends JFrame implements ActionListener {

	public DatabaseClass db;
	
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField inventoryField;
	private JTextField periodField;
	
	// 기본 생성자
	public RentalForm() {
	}
	
	public RentalForm(DatabaseClass db){
		this.db = db;
		
		// 텍스트필드(입력칸)와 레이블 설정
		nameField = new JTextField(10);
		phoneField = new JTextField(10);
		inventoryField = new JTextField(10);
		periodField = new JTextField(10);
		
		JLabel nameLabel = new JLabel("이름 : ");
		JLabel phoneLabel = new JLabel("연락처 : ");
		JLabel inventoryLabel = new JLabel("대여목록 : ");
		JLabel periodLabel = new JLabel("대여기간 : ");
		
		// 대여 추가 버튼 생성
		JButton addButton = new JButton("추가");
		
		// 액션 리스너 부착(추가 버튼 클릭시 할일 정의)
		// 버튼 클릭시 actionPerformed()가 호출됨.
		addButton.addActionListener(this); // 액션 리스터 부착

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(phoneLabel);
		inputPanel.add(phoneField);
		inputPanel.add(inventoryLabel);
		inputPanel.add(inventoryField);
		inputPanel.add(periodLabel);
		inputPanel.add(periodField);
		
		// 메인 패널에 input패널 부착
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		// 메인 패널에 "추가"버튼 부착
		mainPanel.add(addButton, BorderLayout.SOUTH);

		// 프레임(윈도우 창) 설정
		setTitle("대여 정보 입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 메인 패널을 프레임의 루트 컨텐트에 저장
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 액션리스너
		public void actionPerformed(ActionEvent e) {
			// 화면에 입력 된 값을 임시 변수에 저장
			String name = nameField.getText();
			String phone = phoneField.getText();
			String inventory = inventoryField.getText();
			int period = Integer.parseInt(periodField.getText());
			
			// 화면에서 입력받은 데이터로 객체 생성
			Rental rental = new Rental(name, phone, inventory, period);
			
			// 생성한 학생 객체를 ArrayList 저장
			this.db.addRental(rental);
			
			// 객체 성공적으로 등록 완료 메세지
			JOptionPane.showMessageDialog(this, "등록완료");

			// 등록 후 현재 화면 닫기
			this.dispose();

			// 이동해갈 메인 메뉴 생성
			MainMenu mainMenu = new MainMenu(db);

			// 메인 메뉴 보이기
			mainMenu.setVisible(true);
		}
	
}
