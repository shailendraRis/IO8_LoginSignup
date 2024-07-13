package com.realnet.select_team.Services;
import com.realnet.select_team.Repository.Select_TeamRepository;
import com.realnet.select_team.Entity.Select_Team;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class Select_TeamService {
@Autowired
private Select_TeamRepository Repository;




public Select_Team Savedata(Select_Team data) {




Select_Team save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Select_Team> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Select_Team> getdetails() {
				return (List<Select_Team>) Repository.findAll();
			}


public Select_Team getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Select_Team update(Select_Team data,Integer id) {
	Select_Team old = Repository.findById(id).get();
old.setTeam_name(data.getTeam_name());

old.setTeam_name(data.getTeam_name());

final Select_Team test = Repository.save(old);
  return test;}}
