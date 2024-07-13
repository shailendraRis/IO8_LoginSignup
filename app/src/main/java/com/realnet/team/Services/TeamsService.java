package com.realnet.team.Services;
import com.realnet.team.Repository.TeamsRepository;
import com.realnet.team.Entity.Teams;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class TeamsService {
@Autowired
private TeamsRepository Repository;












public Teams Savedata(Teams data) {












Teams save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Teams> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Teams> getdetails() {
				return (List<Teams>) Repository.findAll();
			}


public Teams getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Teams update(Teams data,Integer id) {
	Teams old = Repository.findById(id).get();
old.setTeam_name(data.getTeam_name());

 

old.setDescription(data.getDescription());

old.setMembers(data.getMembers());

old.setMatches(data.getMatches());

old.setActive (data.isActive());

final Teams test = Repository.save(old);
  return test;}}
