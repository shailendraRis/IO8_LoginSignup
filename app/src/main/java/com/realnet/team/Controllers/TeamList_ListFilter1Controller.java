package com.realnet.team.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
import com.realnet.team.Entity.TeamList_ListFilter1;
import com.realnet.team.Services.TeamList_ListFilter1Service ;
@RequestMapping(value = "/TeamList_ListFilter1")
@RestController
public class TeamList_ListFilter1Controller {
	
	@Autowired
	private TeamList_ListFilter1Service Service;

		@GetMapping("/TeamList_ListFilter1")
	public List<TeamList_ListFilter1> getlist() {
		 List<TeamList_ListFilter1> get = Service.getlistbuilder();		
		return get;
}
		@GetMapping("/TeamList_ListFilter11")
	public List<TeamList_ListFilter1> getlistwithparam( ) {
		 List<TeamList_ListFilter1> get = Service.getlistbuilderparam( );		
		return get;
}
}