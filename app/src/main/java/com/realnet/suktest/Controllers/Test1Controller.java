package com.realnet.suktest.Controllers;
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
import com.realnet.suktest.Entity.Test1;
import com.realnet.suktest.Services.Test1Service ;
@RequestMapping(value = "/Test1")
 @CrossOrigin("*") 
@RestController
public class Test1Controller {
	@Autowired
	private Test1Service Service;

@Value("${projectPath}")
	private String projectPath;
 




	@PostMapping("/Test1")
		  public Test1 Savedata(@RequestBody Test1 data) {
		Test1 save = Service.Savedata(data)	;




 return save;
	  }
@PutMapping("/Test1/{id}")
	public  Test1 update(@RequestBody Test1 data,@PathVariable Integer id ) {
		Test1 update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Test1/getall/page")
	public Page<Test1> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Test1> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Test1")
	public List<Test1> getdetails() {
		 List<Test1> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Test1")
	public List<Test1> getallwioutsec() {
		 List<Test1> get = Service.getdetails();		
		return get;
}
@GetMapping("/Test1/{id}")
	public  Test1  getdetailsbyId(@PathVariable Integer id ) {
		Test1  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Test1/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}