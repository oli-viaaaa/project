package library;

import java.util.ArrayList;
import java.util.List;

/*
 * 데이터 보관
 */

public class DatabaseClass {
	// 필드
	public List<Book> bookList;// 책 ArrayList
	public List<Movie> movieList; // 영화 ArrayList
	public List<Rental> rentalList; // 대여 ArrayList

	// 생성자
	public DatabaseClass() {
		bookList = new ArrayList<Book>();
		movieList = new ArrayList<Movie>();
		rentalList = new ArrayList<Rental>();
	}

	// 책 목록 출력화면에서 사용할 메소드(책 ArrayList를 보내줌)
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	// 영화 목록 출력화면에서 사용할 메소드
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}// 대출 목록

	public List<Rental> getRentalList() {
		return rentalList;
	}

	public void setRentalList(List<Rental> rentalList) {
		this.rentalList = rentalList;
	}

	// 도서 추가 메소드
	public void addBook(Book book) {
		this.bookList.add(book);
	}

	// 영화 추가 메소드
	public void addMovie(Movie movie) {
		this.movieList.add(movie);
	}

	// 대출 추가 메소드
	public void addRental(Rental rental) {
		this.rentalList.add(rental);
	}

}
