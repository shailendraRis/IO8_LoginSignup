package com.realnet.start_inning.Controllers;
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
import com.realnet.start_inning.Entity.Start_inning;
import com.realnet.start_inning.Services.Start_inningService ;
@RequestMapping(value = "/Start_inning")
 @CrossOrigin("*") 
@RestController
public class Start_inningController {
	@Autowired
	private Start_inningService Service;

@Value("${projectPath}")
	private String projectPath;
 








	@PostMapping("/Start_inning")
		  public Start_inning Savedata(@RequestBody Start_inning data) {
		Start_inning save = Service.Savedata(data)	;








 return save;
	  }
@PutMapping("/Start_inning/{id}")
	public  Start_inning update(@RequestBody Start_inning data,@PathVariable Integer id ) {
		Start_inning update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Start_inning/getall/page")
	public Page<Start_inning> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Start_inning> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Start_inning")
	public List<Start_inning> getdetails() {
		 List<Start_inning> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Start_inning")
	public List<Start_inning> getallwioutsec() {
		 List<Start_inning> get = Service.getdetails();		
		return get;
}
@GetMapping("/Start_inning/{id}")
	public  Start_inning  getdetailsbyId(@PathVariable Integer id ) {
		Start_inning  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Start_inning/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}