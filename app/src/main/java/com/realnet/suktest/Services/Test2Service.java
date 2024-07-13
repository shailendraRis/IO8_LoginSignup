package com.realnet.suktest.Services;
import com.realnet.suktest.Repository.Test2Repository;
import com.realnet.suktest.Entity.Test2;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class Test2Service {
@Autowired
private Test2Repository Repository;




public Test2 Savedata(Test2 data) {




Test2 save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Test2> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Test2> getdetails() {
				return (List<Test2>) Repository.findAll();
			}


public Test2 getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Test2 update(Test2 data,Integer id) {
	Test2 old = Repository.findById(id).get();
old.setName(data.getName());

old.setDescription(data.getDescription());

final Test2 test = Repository.save(old);
  return test;}}
