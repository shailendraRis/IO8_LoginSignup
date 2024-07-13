package com.realnet.feedback_form.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.feedback_form.Entity.FeedBack_Formt;

@Repository
public interface  FeedBack_FormtRepository  extends  JpaRepository<FeedBack_Formt, Integer>  { 
}