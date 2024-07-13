package com.realnet.start_inning.Services;
import com.realnet.start_inning.Repository.Start_inningRepository;
import com.realnet.start_inning.Entity.Start_inning;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class Start_inningService {
@Autowired
private Start_inningRepository Repository;








public Start_inning Savedata(Start_inning data) {








Start_inning save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Start_inning> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Start_inning> getdetails() {
				return (List<Start_inning>) Repository.findAll();
			}


public Start_inning getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Start_inning update(Start_inning data,Integer id) {
	Start_inning old = Repository.findById(id).get();
old.setSelect_match(data.getSelect_match());

old.setSelect_team(data.getSelect_team());

old.setSelect_player(data.getSelect_player());

old.setDatetime_field(data.getDatetime_field());

final Start_inning test = Repository.save(old);
  return test;}}
