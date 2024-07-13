package com.realnet.team.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.team.Entity.Teams;

@Repository
public interface  TeamsRepository  extends  JpaRepository<Teams, Integer>  { 
}