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
 * 영화 목록 조회 클래스
 */
public class MovieList extends JFrame implements ActionListener{

	public DatabaseClass db;
	
	// 영화 목록이 보여질 테이블
	private JTable table;
	// 테이블을 다양한 기능을 사용할 수 있도록 해주는 클래스
    private DefaultTableModel tableModel;
    
    // 기본 생성자
    public MovieList() {
    }
    
    public MovieList(DatabaseClass db) {
    	this.db = db;
    	
    	// 테이블 세팅
    	String[] columnNames = {"장르", "제목", "평점", "감독", "상영시간"};
    	List<Movie> movieList = db.getMovieList();
    	Object[][] data = new Object[movieList.size()][5];
    	
    	for (int i = 0; i < movieList.size(); i++) {
			Movie movie = movieList.get(i);
			data[i][0] = movie.getGenre();
			data[i][1] = movie.getName();
			data[i][2] = movie.getRatings();
			data[i][3] = movie.getDirector();
			data[i][4] = movie.getTime();
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
    	setTitle("영화 정보 조회");
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
		new MovieList(new DatabaseClass());
	}
}
