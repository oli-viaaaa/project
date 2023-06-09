package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookForm extends JFrame implements ActionListener {

	public DatabaseClass db;

	private JTextField numField;
	private JTextField writerField;
	private JTextField nameField;
	private JTextField publisherField;

	// 기본 생성자
	public BookForm() {
	}

	public BookForm(DatabaseClass db) {
		this.db = db;

		// 텍스트필드(입력칸)와 레이블 설정
		numField = new JTextField(10);
		writerField = new JTextField(10);
		nameField = new JTextField(10);
		publisherField = new JTextField(10);

		JLabel numLabel = new JLabel("도서번호 : ");
		JLabel writerLabel = new JLabel(" 저       자 : ");
		JLabel nameLabel = new JLabel(" 제       목 : ");
		JLabel publisherLabel = new JLabel("출  판  사 : ");
		

		// 도서 추가 버튼 생성
		JButton addButton = new JButton("저장");

		// 액션 리스너 부착(추가 버튼 클릭시 할일 정의)
		// 버튼 클릭시 actionPerformed()가 호출됨.
		addButton.addActionListener(this); // 액션 리스터 부착

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		inputPanel.add(numLabel);
		inputPanel.add(numField);
		inputPanel.add(writerLabel);
		inputPanel.add(writerField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(publisherLabel);
		inputPanel.add(publisherField);
		

		// 메인 패널에 input패널 부착
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		// 메인 패널에 "추가"버튼 부착
		mainPanel.add(addButton, BorderLayout.SOUTH);

		// 프레임(윈도우 창) 설정
		setTitle("도서 정보 입력");
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
		int num = Integer.parseInt(numField.getText());
		String writer = writerField.getText();
		String name = nameField.getText();
		String publisher = publisherField.getText();

		// 화면에서 입력받은 데이터로 도서 객체 생성
		Book book = new Book(num, writer, name, publisher);

		// 생성한 학생 객체를 ArrayList 저장
		this.db.addBook(book);

		// 객체 성공적으로 등록 완료 메세지
		JOptionPane.showMessageDialog(this, "도서 정보가 저장되었습니다.");

		// 도서 등록 후 현재 화면 닫기
		this.dispose();

		// 이동해갈 메인 메뉴 생성
		MainMenu mainMenu = new MainMenu(db);

		// 메인 메뉴 보이기
		mainMenu.setVisible(true);
	}

}
