package library;

/*
 * 책 클래스
 */

public class Book {
	private int num; 		// 도서 번호
	private String writer; // 작가
	private String name; // 제목
	private String publisher; // 출판사

	// 기본 생성자
	public Book() {
		super();
	}

	public Book(int num, String writer, String name, String publisher) {
		super();
		this.num = num;
		this.writer = writer;
		this.name = name;
		this.publisher = publisher;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [num=" + num + ", writer=" + writer + ", name=" + name + ", publisher=" + publisher + "]";
	}

}
