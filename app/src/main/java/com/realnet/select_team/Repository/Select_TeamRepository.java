package com.realnet.select_team.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.select_team.Entity.Select_Team;

@Repository
public interface  Select_TeamRepository  extends  JpaRepository<Select_Team, Integer>  { 
}