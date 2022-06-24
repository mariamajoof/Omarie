package com.tsi.mariama.joof.program;


import org.springframework.beans.factory.annotation.Autowired;//Tells spring to connect the thing to the database
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;// This start the web server
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*") //front end can be able to access the api. needed for receiving request via api
@SpringBootApplication// this start the spring framework
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url


// this class is related to the database
public class MyFirstMicroServiceApplication {
	//connect this to the database
	@Autowired
	private  FilmActorRepository filmActorRepository;
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	@Autowired
	private LanguageRepository languageRepository;


	//*****************************
	//DECLARING VARIABLES//
	//****************************

	private String saved = "Saved";
	private String languageErrorMsg = "Language does not exist";


// This is where the program starts. This tell spring boot where to run the program
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	//set up the constructor- tell it what it needs
	public MyFirstMicroServiceApplication(ActorRepository actorRepository,

										  LanguageRepository languageRepository,
										  CategoryRepository categoryRepository,
										  FilmRepository filmRepository,
										  FilmActorRepository filmActorRepository,
										  FilmCategoryRepository filmCategoryRepository){
			this.actorRepository = actorRepository;

			this.categoryRepository = categoryRepository;
			this.languageRepository = languageRepository;
			this.filmCategoryRepository = filmCategoryRepository;
			this.filmRepository = filmRepository;
			this.filmActorRepository = filmActorRepository;
	}

	//*****************************
		//ACTOR//
	//****************************

	//Get data from actor table

	//Http request that is saying get all actors
	@GetMapping("/allActors")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody// This tells the url what to response
	//this function will return a list of actor, going through the list of actors
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// add actor to the table
	//
	// @PostMapping:maps HTTP POST requests onto specific handler methods
	@PostMapping("/addActor")// handle the HTTP POST requests matched with given URI expression
	//making function that takes param given by user
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody String addActor(@RequestParam String first_name, @RequestParam String last_name ){

		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return saved;
	}

	//update data
	@PutMapping("/updateActor")//Annotation for mapping HTTP PUT requests onto specific handler methods.
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody String updateActor(@RequestParam int actor_id, @RequestParam String first_name, @RequestParam String last_name ){
		if (actorRepository.existsById(actor_id)) {
			Actor actor = actorRepository.findById(actor_id).get();
			actor.setFirst_name(first_name);
			actor.setLast_name(last_name);
			actorRepository.save(actor);
			return "Actor "  + actor_id +  " detail(s) is updated.";
		}
		else
		{
			return "Actor " + actor_id + " not found in the system.";
		}

	}

	//find actor by name

	//delete

	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	@DeleteMapping("/deleteActor")//maps HTTP DELETE requests onto specific handler methods.
	public @ResponseBody String removeActor (@RequestParam int actor_id){
		if (actorRepository.existsById(actor_id)) {
			actorRepository.deleteById(actor_id);
			return saved;
		}
		else {
			return "Actor not found";
		}

	}


	//*****************************
	//LANGUAGE//
	//****************************/

	//Get all languages
	@GetMapping("/allLanguages")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody
	Iterable<Language>getAllLanguages(){

		return languageRepository.findAll();
	}
	// Get language name by id.
	@GetMapping("language/id")//mapped the function to the url
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody String getLanguageById (@RequestParam Integer language_id){
		if (languageRepository.existsById(language_id)){
			Language language =  languageRepository.findById(language_id).get();
			String name = language.getName();
			return name;
		}
		else {
			return languageErrorMsg;
		}
	}
	//get language by name
	@GetMapping("/language/name")//mapped the function to the url
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody List<Language> getLanguageName(@RequestParam String name){
		return languageRepository.findByName(name);
	}

	//*****************************
	//FILM//
	//****************************/
	//Get all films
	@GetMapping("/allFilm")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody
	Iterable<Film>getAllFilm(){

		return filmRepository.findAll();
	}

	//Get film by ID// function not working
	@GetMapping("/film/id")//mapped the function to the url
	//This function will return a film id by checking if the Id existed
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody int getFilmById (@RequestParam int film_id){
			languageRepository.existsById(film_id);
			Film film =  filmRepository.findById(film_id).get();
			film.getFilm_id();
			return film_id;
	}
	//Search by  keywords
	//getting title and description
	@GetMapping("/film/WordSearch/{word}")//mapped the function to the url
	//@PathVariable: this extract the value of the template variable and assign the value to the method
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	// This function will return the film title and description.
	public @ResponseBody List<Film> getFilmByWordSearch(@PathVariable String word){
		//using % to match sql syntax
		return filmRepository.findByDescriptionLikeOrTitleLike("%" + word + "%", "%" + word + "%");

	}
	// list of film and category id in integer

//	public  int getCategoryId(){
//	return categoryRepository.findByName().getCategoryId();
//	}

	//link category and film table
	/////Display all the films within a category///

	//get film by category
	@GetMapping("/films/category")//mapped the function to the url
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	//this function return all the film category Ids within a category, when you type in category name
	public @ResponseBody Iterable<FilmCategory> getFilmIdByCategory(@RequestParam String name){
		return filmCategoryRepository.findByCategoryId(categoryRepository.findByName(name).getCategoryId());
	}
	//get film by name
	@GetMapping("/film/{film_id}")//mapped the function to the url
	// This function return a film title, when you type in the film id
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody Film getFilmByIdToName(@PathVariable int film_id){
		return filmRepository.findById(film_id).get();
	}

	@GetMapping("/category/{name}")//mapped the function to the url
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	//This function display all the films details within the category
	public @ResponseBody Iterable<Film> getCategoryName(@PathVariable String name) {
		Category filmsCat = categoryRepository.findByName(name);
		return filmsCat.films;
	}

	//Add Film
	@PostMapping("/addFilm")// handle the HTTP POST requests matched with given URI expression
	//@RequestParam: This is used to extract the query param from the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody String addFilm(@RequestParam String title, @RequestParam String description, @RequestParam int length, @RequestParam int language_id){

		Film addFilm = new Film(title,description,length,language_id);
		filmRepository.save(addFilm);
		return saved;
	}


	//*****************************
	//FILM CATEGORY//
	//****************************/

	//Get all film category
	@GetMapping("/film/category")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategory(){
		return filmCategoryRepository.findAll();
	}

	//*****************************
	//FILM ACTOR//
	//****************************/

	// Get all film actors

	@GetMapping("/allFilmActors")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActor(){
		return filmActorRepository.findAll();
	}

	//*****************************
	//CATEGORY//
	//****************************/

	// Get all category
	@GetMapping("/allCategory")//mapped the function to the url
	//@ResponseBody: This tells the url what to response. Basically its binds the method return value to the response value.
	public @ResponseBody
	Iterable<Category>getAllCategory(){
		return categoryRepository.findAll();
	}

}

