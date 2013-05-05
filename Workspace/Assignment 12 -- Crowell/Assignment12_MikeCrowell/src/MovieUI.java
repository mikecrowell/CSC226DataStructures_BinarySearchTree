import java.util.ArrayList;
import java.util.Scanner;


public class MovieUI {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MovieCollection collection = new MovieCollection();
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("***** MOVIE COLLECTION *****");
		System.out.println("");
		System.out.println("****************************************");
        String userInput = "";
        while(!(userInput.equalsIgnoreCase("QUIT"))){

            System.out.println("");
            System.out.println("");
            System.out.println("Select from an option below");
            System.out.println("");
            System.out.println("\tadd - to add a movie\n" +
                    "\tupdate - to update box office total\n" +
                    "\tgenre - to view a list by genre\n" +
                    "\ttotal - to view to view sum of all box office totals\n" +
                    "\tcollection - to view movie collection\n" +
                    "\tquit - to end program");
            userInput = getStringInput("Enter Selection");
            if(userInput.equalsIgnoreCase("add")){
                String title = userInput = getStringInput("Enter movie title");   
                String director = getStringInput("Enter movie director"); 
                String genre = getStringInput("Enter movie genre");  
                int total = getIntInput("Enter the box office total (int value)"); 
                collection.addMovie(title, director, genre, total);
            }else if(userInput.equalsIgnoreCase("update")){ 
            	String title = userInput = getStringInput("Enter movie title");
            	int total = getIntInput("Enter new box office total (int value)");
                collection.updateBoxOfficeTotal(title, total);
            }else if(userInput.equalsIgnoreCase("genre")){  
                String genre = getStringInput("Enter genre to view");
    			ArrayList<Movie> list = new ArrayList<Movie>();
    			list = collection.getMoviesWithGenre(genre);
    			for(Movie m : list){
    				System.out.println("");
    				System.out.print(m.getTitle() + " ");
    				System.out.print(m.getDirector() + " ");
    				System.out.print(m.getGenre() + " ");
    				System.out.println(m.getBoxOfficeTotal());
    			}                
            }else if(userInput.equalsIgnoreCase("total")){
            	System.out.println("");
            	System.out.println("Total: " + collection.getBoxOfficeTotals());
            }else if(userInput.equalsIgnoreCase("collection")){
            	System.out.println("");
            	System.out.println(collection);
            }
        }
		

	}
	
	public static String getStringInput(String message){
        System.out.println("");
        System.out.println("\t" + message + ":");
        System.out.print("===>");  
        return scanner.nextLine();		
	}
	
	public static int getIntInput(String message){
    	boolean isValid = false;
		int value = 0;
        System.out.println("");
        System.out.println("\t" + message + " (int value):");
        System.out.print("===>");		
        while(!isValid){
            try{
                value = scanner.nextInt();
                isValid = true;
            }catch(RuntimeException e){
                scanner.nextLine();
            	System.out.println("Invalid entry.  Try again");
            } 
        }	
        return value;
	}

}
