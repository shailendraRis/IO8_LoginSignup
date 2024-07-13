package com.realnet.retired_out.Services;
import com.realnet.retired_out.Repository.Retired_outRepository;
import com.realnet.retired_out.Entity.Retired_out;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class Retired_outService {
@Autowired
private Retired_outRepository Repository;






public Retired_out Savedata(Retired_out data) {






Retired_out save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Retired_out> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Retired_out> getdetails() {
				return (List<Retired_out>) Repository.findAll();
			}


public Retired_out getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Retired_out update(Retired_out data,Integer id) {
	Retired_out old = Repository.findById(id).get();
old.setDescription(data.getDescription());

old.setActive (data.isActive());

old.setPlayer_name(data.getPlayer_name());

final Retired_out test = Repository.save(old);
  return test;}}
