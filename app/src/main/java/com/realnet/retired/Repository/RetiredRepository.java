package com.realnet.retired.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.retired.Entity.Retired;

@Repository
public interface  RetiredRepository  extends  JpaRepository<Retired, Integer>  { 
}