
public class MovieTester {


	public static void main(String[] args) {

		MovieCollection collection = new MovieCollection();
		
		System.out.println("Add 1 movie");
		collection.addMovie("Star Wars", "George Lucas", "Sci Fi", 100);
		
		System.out.println(collection);
		
		System.out.println("");
		System.out.println("Add 5 more movies");
		collection.addMovie("Empire Strikes Back", "George Lucas", "Sci Fi", 200);
		collection.addMovie("Return of the Jedi", "George Lucas", "Sci Fi", 300);
		collection.addMovie("Phantom Menace", "George Lucas", "Sci Fi", 400);
		collection.addMovie("Toy Story", "John Smith", "Animation", 1000);
		collection.addMovie("Cars", "John Smith", "Sci Fi", 1000);
		
		System.out.println(collection);
		
		System.out.println("");
		System.out.println("Add 2 movies that already exist");
		collection.addMovie("Empire Strikes Back", "George Lucas", "Sci Fi", 200);
		collection.addMovie("Return of the Jedi", "George Lucas", "Sci Fi", 300);	
		
		System.out.println(collection);
		
		System.out.println("");
		System.out.println("Update total for Star Wars and Toy Story");
		collection.updateBoxOfficeTotal("Star Wars", 99999);
		collection.updateBoxOfficeTotal("Toy Story", 99999);
		
		System.out.println(collection);
		
		System.out.println("");
		System.out.println("Update totals for all so math is easier");
		collection.updateBoxOfficeTotal("Star Wars", 1);
		collection.updateBoxOfficeTotal("Toy Story", 2);
		collection.updateBoxOfficeTotal("Cars", 3);
		collection.updateBoxOfficeTotal("Return of the Jedi", 4);
		collection.updateBoxOfficeTotal("Empire Strikes Back", 5);
		collection.updateBoxOfficeTotal("Phantom Menace", 6);
		
		System.out.println(collection);
		
		System.out.println("");
		System.out.println("Get sum of box office total for collection");
		System.out.println("Total: " + collection.getBoxOfficeTotals());
		
	}

}
