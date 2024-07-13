package com.realnet.retired_out.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 

import com.realnet.retired_out.Entity.Retired_out;

@Repository
public interface  Retired_outRepository  extends  JpaRepository<Retired_out, Integer>  { 
}