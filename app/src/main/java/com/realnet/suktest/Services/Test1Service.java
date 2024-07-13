package com.realnet.suktest.Services;
import com.realnet.suktest.Repository.Test1Repository;
import com.realnet.suktest.Entity.Test1;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class Test1Service {
@Autowired
private Test1Repository Repository;




public Test1 Savedata(Test1 data) {




Test1 save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<Test1> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<Test1> getdetails() {
				return (List<Test1>) Repository.findAll();
			}


public Test1 getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public Test1 update(Test1 data,Integer id) {
	Test1 old = Repository.findById(id).get();
old.setName(data.getName());

old.setTest2(data.getTest2());

final Test1 test = Repository.save(old);
  return test;}}
