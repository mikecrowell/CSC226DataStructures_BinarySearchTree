
public class Movie implements Comparable<Movie>{

	private String title, director, genre;
	private int boxOfficeTotal;


	public Movie(String title, String director, String genre, int total) {
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.boxOfficeTotal = total;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}	
	
	public String toString(){
		return title + " - " + director + " - " + genre;
	}
	
	public int getBoxOfficeTotal() {
		return boxOfficeTotal;
	}

	public void setBoxOfficeTotal(int boxOfficeTotal) {
		this.boxOfficeTotal = boxOfficeTotal;
	}

	@Override
	public boolean equals(Object obj) {
		Movie movie = (Movie) obj;
		return (title.equalsIgnoreCase(movie.title) && director.equalsIgnoreCase(movie.director));
	}
	
	@Override
	public int compareTo(Movie movie) {
		if(title.equalsIgnoreCase(movie.title)){
			return director.compareTo(movie.director);
		}else{
			return title.compareTo(movie.title);
		}
	}

	

}
