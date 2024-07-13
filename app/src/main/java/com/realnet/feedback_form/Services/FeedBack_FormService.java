package com.realnet.feedback_form.Services;
import com.realnet.feedback_form.Repository.FeedBack_FormRepository;
import com.realnet.feedback_form.Entity.FeedBack_Form;import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Service;

@Service
 public class FeedBack_FormService {
@Autowired
private FeedBack_FormRepository Repository;








public FeedBack_Form Savedata(FeedBack_Form data) {








FeedBack_Form save = Repository.save(data);
				return save;	
			}


//	get all with pagination
	public Page<FeedBack_Form> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}			
public List<FeedBack_Form> getdetails() {
				return (List<FeedBack_Form>) Repository.findAll();
			}


public FeedBack_Form getdetailsbyId(Integer id) {
	return Repository.findById(id).get();
			}


	public void delete_by_id(Integer id) {
 Repository.deleteById(id);
}


public FeedBack_Form update(FeedBack_Form data,Integer id) {
	FeedBack_Form old = Repository.findById(id).get();
old.setName(data.getName());

old.setPhone_number(data.getPhone_number());

old.setEmail_field(data.getEmail_field());

old.setShare_your_experience(data.getShare_your_experience());

final FeedBack_Form test = Repository.save(old);
  return test;}}
