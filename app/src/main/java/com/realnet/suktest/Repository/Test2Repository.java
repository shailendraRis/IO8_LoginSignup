package com.realnet.suktest.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.suktest.Entity.Test2;

@Repository
public interface  Test2Repository  extends  JpaRepository<Test2, Integer>  { 
}