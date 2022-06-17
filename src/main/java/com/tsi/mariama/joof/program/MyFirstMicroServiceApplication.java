package com.tsi.mariama.joof.program;

import DummyCode.PaymentRepository;
import DummyCode.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;//tells spring to connect the thing to the databse
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;// this start the web server
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.List;


@CrossOrigin(origins = "*") //front end can be able to access the api. needed for receiving request via api
@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url



public class MyFirstMicroServiceApplication {
	@Autowired
	private  FilmActorRepository filmActorRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CustomerRepository customerRepository;
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


// this is where the program start. this tell spring boot where to run thr program
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	public MyFirstMicroServiceApplication(ActorRepository actorRepository,
										  CustomerRepository customerRepository,
										  LanguageRepository languageRepository,
										  CategoryRepository categoryRepository,
										  FilmRepository filmRepository,
										  FilmActorRepository filmActorRepository,
										  FilmCategoryRepository filmCategoryRepository){
			this.actorRepository = actorRepository;
			this.customerRepository = customerRepository;
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
	@GetMapping("/allActors")//maap the function to the url

	public @ResponseBody
	//this function will return a list of actor, going through the list of actors
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// add actor to the table
	@PostMapping("/addActor")
	//making function that takes param given by user
	public @ResponseBody String addActor(@RequestParam String first_name, @RequestParam String last_name ){

		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return saved;
	}

	//update data
	@PutMapping("/updateActor")
	public @ResponseBody String updateActor(@RequestParam int actor_id, @RequestParam String first_name, @RequestParam String last_name ){
		if (actorRepository.existsById(actor_id)) {
			Actor actor = actorRepository.findById(actor_id).get();
			actor.setFirst_name(first_name);
			actor.setLast_name(last_name);
			actorRepository.save(actor);
			return "Actor" + actor_id + "detail(s) is updated.";
		}
		else
		{
			return "Actor" + actor_id + "not found in the system.";
		}

	}
	//delete
	@DeleteMapping("/deleteActor")
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
	//CUSTOMER//
	//****************************/
	@GetMapping("/getAllCustomers")
	public @ResponseBody
	Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	// Add data to the table
	@PostMapping("/addCustomer")
	public @ResponseBody String addCustomer(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String email){

		Customer addCustomer = new Customer( first_name,last_name, email );
		customerRepository.save(addCustomer);
		return saved;
	}

	//update data
	@PutMapping("/updateCustomer")
	public @ResponseBody String updateCustomer(@RequestParam int customer_id, @RequestParam String first_name, @RequestParam String last_name, @RequestParam String email){
		if (customerRepository.existsById(customer_id)) {
			Customer customer = customerRepository.findById(customer_id).get();
			customer.setFirst_name(first_name);
			customer.setLast_name(last_name);
			customer.setEmail(email);

			customerRepository.save(customer);
			return "Customer" + customer_id + "detail(s) is updated.";
		}
		else
		{
			return "Customer" + customer_id + "not found in the system.";
		}

	}
	//delete
	@DeleteMapping("/deleteCustomer")
	public @ResponseBody String removeCustomer (@RequestParam int customer_id) {
		if (customerRepository.existsById(customer_id)) {
			customerRepository.deleteById(customer_id);
			return "Removed customer";
		} else {
			return "Customer not found";
		}
	}
	//*****************************
	//LANGUAGE//
	//****************************/

	//Get all languages
	@GetMapping("/allLanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){

		return languageRepository.findAll();
	}
	// Get language name by id.
	@GetMapping("language/id")
	public @ResponseBody String getLanguageById (@RequestParam int language_id, @RequestParam String name){
		if (languageRepository.existsById(language_id)){
			Language language =  languageRepository.findById(language_id).get();
			language.getName();
			return name;
		}
		else {
			return languageErrorMsg;
		}
	}
	//get language by name
	@GetMapping("/language/name")
	public @ResponseBody List<Language> getLanguageName(@RequestParam String name){
		return languageRepository.findByName(name);
	}

	//*****************************
	//FILM//
	//****************************/
	//Get all films
	@GetMapping("/allFilm")
	public @ResponseBody
	Iterable<Film>getAllFilm(){

		return filmRepository.findAll();
	}

	//Get film by ID
	@GetMapping("/film/id")
	public @ResponseBody int getFilmById (@RequestParam int film_id){
			languageRepository.existsById(film_id);
			Film film =  filmRepository.findById(film_id).get();
			film.getFilm_id();
			return film_id;
	}
	//Search by  keywords
	@GetMapping("/film/WordSearch")
	public @ResponseBody List<Film> getFilmByWordSearch(@RequestParam String wordSearch){
		return filmRepository.findByDescriptionLikeOrTitleLike("%" + wordSearch + "%", "%" + wordSearch + "%");

	}
	// list of film and category id in integer
	public  int getCategoryId( String name){
		return categoryRepository.findByName(name).getCategoryId();
	}
	//link category and film table
	//get film by category
	@GetMapping("/films/category")
	public @ResponseBody Iterable<FilmCategory> getFilmIdByCategory(@RequestParam String name){
		return filmCategoryRepository.findByCategoryId(categoryRepository.findByName(name).getCategoryId());
	}
	//get film bt name
	@GetMapping("/film/name")
	public @ResponseBody String getFilmByIdToName(@RequestParam int film_id){
		return filmRepository.findById(film_id).get().getTitle();
	}
	//getting title and description
	@GetMapping("/category/name")
	public @ResponseBody Iterable<Film> getCategoryName(@RequestParam String name) {
		Category filmsCat = categoryRepository.findByName(name);
		return filmsCat.films;
	}


	//Search by the film year by
//	@GetMapping("/film/releaseYear")
//	public @ResponseBody List<Film> getFilmReleaseYear (@RequestParam Year release_year){
//		return filmRepository.findByReleaseYear(release_year);
//	}

	//Delete film by Id
	@DeleteMapping("/deleteFilm")
	public @ResponseBody String removeFilm (@RequestParam int film_id) {
		if (filmRepository.existsById(film_id)) {
			filmRepository.deleteById(film_id);
			return "Removed film";
		} else {
			return "Film not found";
		}
	}

	//Add Film
	@PostMapping("/addFilm")
	public @ResponseBody String addFilm(@RequestParam String title, @RequestParam String description, @RequestParam int length, @RequestParam int language_id){

		Film addFilm = new Film(title,description,length,language_id);
		filmRepository.save(addFilm);
		return saved;
	}


	//*****************************
	//FILM CATEGORY//
	//****************************/

	//Get all film category
	@GetMapping("/film/category")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategory(){
		return filmCategoryRepository.findAll();
	}

	//*****************************
	//FILM ACTOR//
	//****************************/

	// Get all film actors

	@GetMapping("/allFilmActors")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActor(){
		return filmActorRepository.findAll();
	}
	// GET FILM BASED TO ACTOR SEARCH
	//@GetMapping("/actor/film")
//	public @ResponseBody String getFilmByActorSearch(@RequestParam String name ){
//		Actor filmActor = filmRepository.findAll(name);
//		return filmActor.films;
//
//	}

	//*****************************
	//CATEGORY//
	//****************************/

	// Get all category
	@GetMapping("/allCategory")
	public @ResponseBody
	Iterable<Category>getAllCategory(){
		return categoryRepository.findAll();
	}

}
