package library;

/*
 * 영화 클래스
 */

public class Movie {

	private String genre; // 장르
	private String name; // 제목
	private double ratings; // 평점
	private String director; // 감독
	private int time; // 상영시간

	public Movie() {
		super();
	}

	public Movie(String genre, String name, Double ratings, String director, int time) {
		super();
		this.genre = genre;
		this.name = name;
		this.ratings = ratings;
		this.director = director;
		this.time = time;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Movie [genre=" + genre + ", naem=" + name + ", ratings=" + ratings + ", director=" + director
				+ ", time=" + time + "]";
	}

}
