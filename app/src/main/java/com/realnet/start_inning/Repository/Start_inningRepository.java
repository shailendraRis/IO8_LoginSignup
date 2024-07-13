package com.realnet.start_inning.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.start_inning.Entity.Start_inning;

@Repository
public interface  Start_inningRepository  extends  JpaRepository<Start_inning, Integer>  { 
}