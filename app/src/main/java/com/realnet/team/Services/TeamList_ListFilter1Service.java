package com.realnet.team.Services;
import java.util.*;
import com.realnet.team.Repository.TeamsRepository;
import com.realnet.team.Entity.Teams;

import com.realnet.team.Entity.TeamList_ListFilter1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

@Service
 public class TeamList_ListFilter1Service {
@Autowired
private TeamsRepository Repository;




 public   List<TeamList_ListFilter1>   getlistbuilder() {
	List<Teams> list= Repository.findAll();
		ArrayList<TeamList_ListFilter1> l = new ArrayList<>();
		for (Teams data : list) {
{	
TeamList_ListFilter1 dummy = new TeamList_ListFilter1();
			dummy.setId(data.getId());
  dummy.setTeam_name(data.getTeam_name());
	l.add(dummy);
} 
} 		
return l;}



 public   List<TeamList_ListFilter1>   getlistbuilderparam( ) {
	List<Teams> list= Repository.findAll();
		ArrayList<TeamList_ListFilter1> l = new ArrayList<>();
		for (Teams data : list) {
{	
TeamList_ListFilter1 dummy = new TeamList_ListFilter1();
			dummy.setId(data.getId());
  dummy.setTeam_name(data.getTeam_name());
	l.add(dummy);
} 
} 		
return l;}
}