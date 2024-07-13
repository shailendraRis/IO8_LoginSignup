package com.realnet.suktest.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.suktest.Entity.Test1;

@Repository
public interface  Test1Repository  extends  JpaRepository<Test1, Integer>  { 
}