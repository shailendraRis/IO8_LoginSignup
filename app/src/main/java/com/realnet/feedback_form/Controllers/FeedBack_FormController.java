package com.realnet.feedback_form.Controllers;
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
import com.realnet.feedback_form.Entity.FeedBack_Form;
import com.realnet.feedback_form.Services.FeedBack_FormService ;
@RequestMapping(value = "/FeedBack_Form")
 @CrossOrigin("*") 
@RestController
public class FeedBack_FormController {
	@Autowired
	private FeedBack_FormService Service;

@Value("${projectPath}")
	private String projectPath;
 








	@PostMapping("/FeedBack_Form")
		  public FeedBack_Form Savedata(@RequestBody FeedBack_Form data) {
		FeedBack_Form save = Service.Savedata(data)	;








 return save;
	  }
@PutMapping("/FeedBack_Form/{id}")
	public  FeedBack_Form update(@RequestBody FeedBack_Form data,@PathVariable Integer id ) {
		FeedBack_Form update = Service.update(data,id);
		return update;
	}	 
//	get all with pagination
	@GetMapping("/FeedBack_Form/getall/page")
	public Page<FeedBack_Form> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<FeedBack_Form> get = Service.getAllWithPagination(paging);

		return get;

	}	
	@GetMapping("/FeedBack_Form")
	public List<FeedBack_Form> getdetails() {
		 List<FeedBack_Form> get = Service.getdetails();		
		return get;
}
// get all without authentication 

	@GetMapping("/token/FeedBack_Form")
	public List<FeedBack_Form> getallwioutsec() {
		 List<FeedBack_Form> get = Service.getdetails();		
		return get;
}
@GetMapping("/FeedBack_Form/{id}")
	public  FeedBack_Form  getdetailsbyId(@PathVariable Integer id ) {
		FeedBack_Form  get = Service.getdetailsbyId(id);
		return get;
	}
@DeleteMapping("/FeedBack_Form/{id}")
	public  void delete_by_id(@PathVariable Integer id ) {
	Service.delete_by_id(id);
		
	}

}