package com.realnet.retired.Services;
import com.realnet.retired.Repository.RetiredRepository;
import com.realnet.retired.Entity.Retired;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class RetiredService {
@Autowired
private RetiredRepository Repository;








public Retired Savedata(Retired data) {








Retired save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Retired> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Retired> getdetails() {
				return (List<Retired>) Repository.findAll();
			}


public Retired getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Retired update(Retired data,Integer id) {
	Retired old = Repository.findById(id).get();
old.setDescription(data.getDescription());

old.setActive (data.isActive());

old.setPlayer_name(data.getPlayer_name());

old.setCan_batter_bat_again(data.getCan_batter_bat_again());

final Retired test = Repository.save(old);
  return test;}}
