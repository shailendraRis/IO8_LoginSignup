package com.realnet.retired_out.Controllers;
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
import com.realnet.retired_out.Entity.Retired_out;
import com.realnet.retired_out.Services.Retired_outService ;
@RequestMapping(value = "/Retired_out")
 @CrossOrigin("*") 
@RestController
public class Retired_outController {
	@Autowired
	private Retired_outService Service;

@Value("${projectPath}")
	private String projectPath;
 






	@PostMapping("/Retired_out")
		  public Retired_out Savedata(@RequestBody Retired_out data) {
		Retired_out save = Service.Savedata(data)	;






 return save;
	  }
@PutMapping("/Retired_out/{id}")
	public  Retired_out update(@RequestBody Retired_out data,@PathVariable Integer id ) {
		Retired_out update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/Retired_out/getall/page")
	public Page<Retired_out> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Retired_out> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/Retired_out")
	public List<Retired_out> getdetails() {
		 List<Retired_out> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/Retired_out")
	public List<Retired_out> getallwioutsec() {
		 List<Retired_out> get = Service.getdetails();		
		return get;
}
@GetMapping("/Retired_out/{id}")
	public  Retired_out  getdetailsbyId(@PathVariable Integer id ) {
		Retired_out  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/Retired_out/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}