package com.realnet.team.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.realnet.config.EmailService;
import com.realnet.users.entity1.AppUser;
import com.realnet.users.service1.AppUserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.*;
import com.realnet.team.Entity.Teams;
import com.realnet.team.Services.TeamsService ;
@RequestMapping(value = "/Teams")
 @CrossOrigin("*") 
@RestController
public class TeamsController {
	@Autowired
	private TeamsService Service;

@Value("${projectPath}")
	private String projectPath;
 












	@PostMapping("/Teams")
		  public Teams Savedata(@RequestBody Teams data) {
		Teams save = Service.Savedata(data)	;












 return save;
	  }
@PutMapping("/Teams/{id}")
	public  Teams update(@RequestBody Teams data,@PathVariable Integer id ) {
		Teams update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Teams/getall/page")
	public Page<Teams> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Teams> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Teams")
	public List<Teams> getdetails() {
		 List<Teams> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Teams")
	public List<Teams> getallwioutsec() {
		 List<Teams> get = Service.getdetails();		
		return get;
}
@GetMapping("/Teams/{id}")
	public  Teams  getdetailsbyId(@PathVariable Integer id ) {
		Teams  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Teams/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}