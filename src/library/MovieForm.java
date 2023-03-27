package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieForm extends JFrame implements ActionListener {

	public DatabaseClass db;
	
	private JTextField genreField;
	private JTextField nameField;
	private JTextField ratingsField;
	private JTextField directorField;
	private JTextField timeFilField;
	
	// 기본 생성자
	public MovieForm() {
	}
	
	public MovieForm(DatabaseClass db) {
		this.db = db;
		
		// 텍스트필드(입력칸)와 레이블 설정
		genreField = new JTextField(10);
		nameField = new JTextField(10);
		ratingsField = new JTextField(10);
		directorField = new JTextField(10);
		timeFilField = new JTextField(10);
		
		JLabel genreLabel = new JLabel("장르 : ");
		JLabel nameLabel = new JLabel("제목 : ");
		JLabel ratingsLabel = new JLabel("평점 : ");
		JLabel directorLabel = new JLabel("감독 : ");
		JLabel timeLabel = new JLabel("상영시간 : ");
		
		// 추가 버튼 생성
		JButton addButton = new JButton("추가");
		
		// 액션 리스너 부착(추가 버튼 클릭시 할일 정의)
		// 버튼 클릭시 actionPerformed()가 호출됨.
		addButton.addActionListener(this); // 액션 리스터 부착

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 2));
		inputPanel.add(genreLabel);
		inputPanel.add(genreField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(ratingsLabel);
		inputPanel.add(ratingsField);
		inputPanel.add(directorLabel);
		inputPanel.add(directorField);
		inputPanel.add(timeLabel);
		inputPanel.add(timeFilField);
		
		// 메인 패널에 input패널 부착
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		// 메인 패널에 "추가"버튼 부착
		mainPanel.add(addButton, BorderLayout.SOUTH);

		// 프레임(윈도우 창) 설정
		setTitle("영화 정보 입력");
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
			String genre = genreField.getText();
			String name = nameField.getText();
			double ratings = Double.parseDouble(ratingsField.getText());
			String director = directorField.getText();
			int time = Integer.parseInt(timeFilField.getText());
			
			Movie movie = new Movie(genre,name,ratings,director,time);
			
			this.db.addMovie(movie);
			
			// 객체 성공적으로 등록 완료 메세지
			JOptionPane.showMessageDialog(this, "등록완료");

			// 영화 등록 후 현재 화면 닫기
			this.dispose();

			// 이동해갈 메인 메뉴 생성
			MainMenu mainMenu = new MainMenu(db);

			// 메인 메뉴 보이기
			mainMenu.setVisible(true);
			
			
		}
	
	
}
