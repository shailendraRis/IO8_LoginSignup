package com.realnet.retired.Controllers;
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
import com.realnet.retired.Entity.Retired;
import com.realnet.retired.Services.RetiredService ;
@RequestMapping(value = "/Retired")
 @CrossOrigin("*") 
@RestController
public class RetiredController {
	@Autowired
	private RetiredService Service;

@Value("${projectPath}")
	private String projectPath;
 








	@PostMapping("/Retired")
		  public Retired Savedata(@RequestBody Retired data) {
		Retired save = Service.Savedata(data)	;








 return save;
	  }
@PutMapping("/Retired/{id}")
	public  Retired update(@RequestBody Retired data,@PathVariable Integer id ) {
		Retired update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Retired/getall/page")
	public Page<Retired> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Retired> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Retired")
	public List<Retired> getdetails() {
		 List<Retired> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Retired")
	public List<Retired> getallwioutsec() {
		 List<Retired> get = Service.getdetails();		
		return get;
}
@GetMapping("/Retired/{id}")
	public  Retired  getdetailsbyId(@PathVariable Integer id ) {
		Retired  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Retired/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}