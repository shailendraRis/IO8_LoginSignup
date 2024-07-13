package com.realnet.feedback_form.Services;

import com.realnet.feedback_form.Repository.FeedBack_FormtRepository;
import com.realnet.feedback_form.Entity.FeedBack_Formt;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.realnet.SequenceGenerator.Service.SequenceService;
import com.realnet.Notification.Entity.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeedBack_FormtService {
	@Autowired
	private FeedBack_FormtRepository Repository;

	public FeedBack_Formt Savedata(FeedBack_Formt data) {

		FeedBack_Formt save = Repository.save(data);
		return save;
	}

//	get all with pagination
	public Page<FeedBack_Formt> getAllWithPagination(Pageable page) {
		return Repository.findAll(page);
	}

	public List<FeedBack_Formt> getdetails() {
		return (List<FeedBack_Formt>) Repository.findAll();
	}

	public FeedBack_Formt getdetailsbyId(Integer id) {
		return Repository.findById(id).get();
	}

	public void delete_by_id(Integer id) {
		Repository.deleteById(id);
	}

	public FeedBack_Formt update(FeedBack_Formt data, Integer id) {
		FeedBack_Formt old = Repository.findById(id).get();
		old.setName(data.getName());

		old.setPhone_number(data.getPhone_number());

		old.setEmail_field(data.getEmail_field());

		old.setShare_your_experience(data.getShare_your_experience());

		final FeedBack_Formt test = Repository.save(old);
		return test;
	}
}
