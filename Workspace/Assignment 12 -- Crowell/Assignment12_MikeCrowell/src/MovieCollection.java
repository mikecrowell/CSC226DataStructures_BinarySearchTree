import java.util.*;


public class MovieCollection{

	BSTNode<Movie> root;
	int numItems;
	Queue<Movie> tempStorage;
	
	public MovieCollection() {
		this.root = null;
		this.numItems = 0;
	}
	

	
	public void addMovie(String title, String director, String genre, int boxOfficeTotal){
		Movie movie = new Movie(title, director, genre, boxOfficeTotal);
		root = recAdd(movie, root);
	}
	
	
	private BSTNode<Movie> recAdd(Movie movie, BSTNode<Movie> root)
	  {
	    if (root == null){
	      root = new BSTNode<Movie>(movie);
	    }else if (movie.compareTo((Movie) root.getInfo()) < 0){
	      root.setLeft(recAdd(movie, root.getLeft())); 
	    }else if (movie.compareTo((Movie) root.getInfo()) > 0){
	      root.setRight(recAdd(movie, root.getRight())); 
	    }
	    return root;
	  }	

	
	public void updateBoxOfficeTotal(String title, int newTotal){
		Movie movie = recGet(title, root);
		movie.setBoxOfficeTotal(newTotal);
	}	
	

	  private Movie recGet(String title, BSTNode<Movie> collection)
	  {
	    if (collection == null){
	      return null;
	    }else if(title.compareTo(collection.getInfo().getTitle()) < 0){
	      return recGet(title, collection.getLeft());        
	    }else if(title.compareTo(collection.getInfo().getTitle()) > 0){
	      return recGet(title, collection.getRight());  
	    }else{
	      return collection.getInfo(); 
	    }
	  }

	  
		public ArrayList<Movie> getMoviesWithGenre(String genre){
			ArrayList<Movie> list = new ArrayList<Movie>();
			inorderRetrieve(root, list);
			ArrayList<Movie> newList = new ArrayList<Movie>();
			for(Movie m : list){
				if(genre.equalsIgnoreCase(m.getGenre())){
					newList.add(m);
				}					
			}
			return newList;
		}	  
	  

	public double getBoxOfficeTotals(){
		double total = 0;
		ArrayList<Movie> list = new ArrayList<Movie>();
		inorderRetrieve(root, list);
		for(Movie m : list){
			total += m.getBoxOfficeTotal();
		}		
		return total;
	}
	

	private void inorderRetrieve(BSTNode<Movie> cursor, ArrayList<Movie> list){
		if(cursor == null){
			return;
		}else{
			inorderRetrieve(cursor.getLeft(), list);
			list.add(cursor.getInfo()); 
			inorderRetrieve(cursor.getRight(), list);							
		}
	}	


	@Override
	public String toString() {
		String s = "Movie Collection:\n";
		ArrayList<Movie> list = new ArrayList<Movie>();
		inorderRetrieve(root, list);
		for(Movie m : list){
			s += m.getTitle() + " - " + m.getDirector() + " - " + m.getGenre() + " - " + m.getBoxOfficeTotal() + "\n";
		}
		return s;
	}
		
	
}
