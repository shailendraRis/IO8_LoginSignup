package com.realnet.dashboard_builder_authsec.Entity;
 import lombok.*;
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    Dashboard extends Extension { 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

private String  name;

@Column(length = 5000)
private String  model;

private boolean isdashboard;


}
