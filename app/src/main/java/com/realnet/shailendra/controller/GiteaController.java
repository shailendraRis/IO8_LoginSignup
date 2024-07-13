package com.realnet.shailendra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.realnet.shailendra.service.GiteaService;


@RestController
@RequestMapping("/api/gitea")
public class GiteaController {

	  @Autowired
	    private GiteaService giteaService;

	  //Example
//	  PATCH http://localhost:8080/api/gitea/repos/johndoe/myrepo/rename?newName=newrepo
	  //Authorization: token YOUR_GITEA_TOKEN
	  //Content-Type: application/json

	  
	    @PatchMapping("/repos/{owner}/{repo}/rename")
	    public ResponseEntity<String> renameRepository(
	            @PathVariable String owner,
	            @PathVariable String repo,
	            @RequestParam String newName) {
	        return giteaService.updateRepositoryName(owner, repo, newName);
	    }

	    
	    //Example
//	    DELETE http://localhost:8080/api/gitea/repos/johndoe/myrepo
	    //Authorization: token YOUR_GITEA_TOKEN
		//Content-Type: application/json

	    @DeleteMapping("/repos/{owner}/{repo}")
	    public ResponseEntity<String> deleteRepository(
	            @PathVariable String owner,
	            @PathVariable String repo) {
	        return giteaService.deleteRepository(owner, repo);
	    }
	    
}
