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
import com.realnet.feedback_form.Entity.FeedBack_Formt;
import com.realnet.feedback_form.Services.FeedBack_FormtService;

@RequestMapping(value = "/FeedBack_Formt")
@CrossOrigin("*")
@RestController
public class FeedBack_FormtController {
	@Autowired
	private FeedBack_FormtService Service;

	@Value("${projectPath}")
	private String projectPath;

	@PostMapping("/FeedBack_Formt")
	public FeedBack_Formt Savedata(@RequestBody FeedBack_Formt data) {
		FeedBack_Formt save = Service.Savedata(data);

		return save;
	}

	@PutMapping("/FeedBack_Formt/{id}")
	public FeedBack_Formt update(@RequestBody FeedBack_Formt data, @PathVariable Integer id) {
		FeedBack_Formt update = Service.update(data, id);
		return update;
	}

//	get all with pagination
	@GetMapping("/FeedBack_Formt/getall/page")
	public Page<FeedBack_Formt> getall(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<FeedBack_Formt> get = Service.getAllWithPagination(paging);

		return get;

	}

	@GetMapping("/FeedBack_Formt")
	public List<FeedBack_Formt> getdetails() {
		List<FeedBack_Formt> get = Service.getdetails();
		return get;
	}
// get all without authentication 

	@GetMapping("/token/FeedBack_Formt")
	public List<FeedBack_Formt> getallwioutsec() {
		List<FeedBack_Formt> get = Service.getdetails();
		return get;
	}

	@GetMapping("/FeedBack_Formt/{id}")
	public FeedBack_Formt getdetailsbyId(@PathVariable Integer id) {
		FeedBack_Formt get = Service.getdetailsbyId(id);
		return get;
	}

	@DeleteMapping("/FeedBack_Formt/{id}")
	public void delete_by_id(@PathVariable Integer id) {
		Service.delete_by_id(id);

	}

}