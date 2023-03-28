package library;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * 책 목록 조회 클래스 
 */

public class BookList extends JFrame implements ActionListener {

	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

	// 책 목록이 보여질 테이블
	private JTable table;
	// 테이블의 다양한 기능을 사용할 클래스 생성
	private DefaultTableModel tableModel;

	// 기본 생성자
	public BookList() {
	}

	public BookList(DatabaseClass db) {
		// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
		this.db = db;

		// 테이블 세팅
		String[] columnNames = { "책번호", "작가", "제목", "출판사" };
		List<Book> bookList = db.getBookList();// ArrayList<Book>의 갯수 만큼 행을 생성
		Object[][] data = new Object[bookList.size()][4];

		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			data[i][0] = book.getNum();
			data[i][1] = book.getWriter();
			data[i][2] = book.getName();
			data[i][3] = book.getPublisher();
		}

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);

		// Set up the button to add a new student
		JButton closeButton = new JButton("닫기");

		// 액션 리스너 부착
		closeButton.addActionListener(this);

		// 메인 패널 생성
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		// 입력 필드들이 놓을 input 패널 생성
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		

		// input 패널을 메인 패널에 다시 부착
		mainPanel.add(inputPanel, BorderLayout.SOUTH);
		// 닫기 버튼도 메인 패널에 부착
		mainPanel.add(closeButton, BorderLayout.SOUTH);

		// 프레임(윈도우 창)설정
		setTitle("도서 정보 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// 액션 리스너
	public void actionPerformed(ActionEvent e) {
		// 현재 열려있는 도서 조회 화면을 닫음
		this.dispose();

		MainMenu mainMenu = new MainMenu(db);
		mainMenu.setVisible(true);
	}

	public static void main(String[] args) {
		new BookList(new DatabaseClass());
	}
}
