package com.tsi.mariama.joof.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*") // needed for receiving request via api
@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url



public class MyFirstMicroServiceApplication {
	@Autowired
	private ActorRepository actorRepository;

	private String saved = "Saved";
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}
	public MyFirstMicroServiceApplication(ActorRepository actorRepository){
			this.actorRepository = actorRepository;
	}

	//Get data from actor table
	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// add data to the table
	@PostMapping("/addActor")
	public @ResponseBody String addActor(@RequestParam String first_name, @RequestParam String last_name ){

		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return saved;
	}

	//update data
	//@PutMapping("/updateActor")
	//public @ResponseBody String updateActor(@RequestParam String firstName, String lastName ){
		//Actor updateActor = new Actor()

	//}


	//delete

}
