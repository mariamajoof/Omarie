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
		actorRepository.deleteById(actor_id);
		return saved;
	}

}
