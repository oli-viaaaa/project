package library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 초기화면_메인메뉴
 * 	- 프로그램 구동 후 가장 먼저 보이는 화면
 */

public class MainMenu extends JFrame implements ActionListener {

	// 데이터베이스 역할을 하는 변수 선언
	// 생성자에서 전달 받음
	public DatabaseClass db;

	// 화면에서 사용할 입력필드, 버튼, 레이블 변수 선언
	private JLabel titLabel;
	private JButton bookButton;
	private JButton movieButton;
	private JButton rentalButton;
	private JButton bookListButton;
	private JButton movieListButton;
	private JButton rentalListButton;
	private JButton exitButton;

	// 생성자
	public MainMenu(DatabaseClass db) {
		this.db = db;

		List<Book> bookList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();
		List<Rental> rentalList = new ArrayList<>();

		// 프레임 설정
		setTitle("문헌 정보실");
		setLayout(new GridLayout(8, 3));
		setSize(300, 400);

		// 프레임 타이틀 설정
		titLabel = new JLabel("목록");
		titLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titLabel);

		// 각 화면을 버튼으로 만들어서 프레임에 부착 - 도서 등록
		bookButton = new JButton("도서 등록");
		bookButton.addActionListener(this);
		add(bookButton); // 버튼을 프레임에 부착

		// Movie Register button
		movieButton = new JButton("영화 등록");
		movieButton.addActionListener(this);
		add(movieButton);

		// Rental Register button
		rentalButton = new JButton("대출 등록");
		rentalButton.addActionListener(this);
		add(rentalButton);

		// BooKList button
		bookListButton = new JButton("도서 목록");
		bookListButton.addActionListener(this);
		add(bookListButton);

		// MovieList button
		movieListButton = new JButton("영화 목록");
		movieListButton.addActionListener(this);
		add(movieListButton);

		// RentalList button
		rentalListButton = new JButton("대출 목록");
		rentalListButton.addActionListener(this);
		add(rentalListButton);

		// Exit button
		exitButton = new JButton("나가기");
		exitButton.addActionListener(this);
		add(exitButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 액션
	public void actionPerformed(ActionEvent e) {
		// 도서 등록폼이 눌렀을 경우
		if (e.getSource() == bookButton) {
			System.out.println("도서 등록");
			// 현재의 메인 메뉴 화면 닫기
			this.dispose();
			// 이동해갈 화면 객체 생성(도서 등록폼)
			BookForm bookForm = new BookForm(db);
			// 이동해갈 화면 보이기
			bookForm.setVisible(true);

		} else if (e.getSource() == movieButton) {
			// 영화 등록폼이 눌렸을 경우
			System.out.println("영화 등록");
			// 현재의 메인 메뉴 화면 닫기
			this.dispose();
			// 이동해갈 화면 객체 생성(영화 등록폼)
			MovieForm movieForm = new MovieForm(db);
			// 이동해갈 화면 보이기
			movieForm.setVisible(true);

		} else if (e.getSource() == rentalButton) {
			// 대출 등록 폼이 눌렸을 경우
			System.out.println("대출 등록");
			// 현재의 메인 메뉴 화면 닫기
			this.dispose();
			// 이동해갈 화면 객체 생성(대출 등록 폼)
			RentalForm rentalForm = new RentalForm(db);
			// 이동해갈 화면 보이기
			rentalForm.setVisible(true);

		} else if (e.getSource() == bookListButton) {
			System.out.println("도서 조회");
			// 현재 화면 닫기
			this.dispose();
			// 이동해갈 화면 객체 생성
			BookList bookList = new BookList(db);
			// 이동해갈 화면 보이기
			bookList.setVisible(true);

		} else if (e.getSource() == movieListButton) {
			System.out.println("영화 조회");
			// 현재 화면 닫기
			this.dispose();
			// 이동해갈 화면 객체 생성
			MovieList movieList = new MovieList(db);
			// 이동해갈 화면 보이기
			movieList.setVisible(true);

		} else if (e.getSource() == rentalListButton) {
			System.out.println("대출 조회");
			this.dispose();
			RentalList rentalList = new RentalList(db);
			rentalList.setVisible(true);

		} else if (e.getSource() == exitButton) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new MainMenu(new DatabaseClass());
	}
}
