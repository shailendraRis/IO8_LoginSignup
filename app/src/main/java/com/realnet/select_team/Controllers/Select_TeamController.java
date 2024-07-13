package com.realnet.select_team.Controllers;
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
import com.realnet.select_team.Entity.Select_Team;
import com.realnet.select_team.Services.Select_TeamService ;
@RequestMapping(value = "/Select_Team")
 @CrossOrigin("*") 
@RestController
public class Select_TeamController {
	@Autowired
	private Select_TeamService Service;

@Value("${projectPath}")
	private String projectPath;
 




	@PostMapping("/Select_Team")
		  public Select_Team Savedata(@RequestBody Select_Team data) {
		Select_Team save = Service.Savedata(data)	;




 return save;
	  }
@PutMapping("/Select_Team/{id}")
	public  Select_Team update(@RequestBody Select_Team data,@PathVariable Integer id ) {
		Select_Team update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Select_Team/getall/page")
	public Page<Select_Team> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Select_Team> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Select_Team")
	public List<Select_Team> getdetails() {
		 List<Select_Team> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Select_Team")
	public List<Select_Team> getallwioutsec() {
		 List<Select_Team> get = Service.getdetails();		
		return get;
}
@GetMapping("/Select_Team/{id}")
	public  Select_Team  getdetailsbyId(@PathVariable Integer id ) {
		Select_Team  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Select_Team/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}