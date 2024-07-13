package com.realnet.feedback_form.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.feedback_form.Entity.FeedBack_Form;

@Repository
public interface  FeedBack_FormRepository  extends  JpaRepository<FeedBack_Form, Integer>  { 
}