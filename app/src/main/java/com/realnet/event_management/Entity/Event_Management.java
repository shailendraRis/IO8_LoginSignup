package com.realnet.event_management.Entity;
 import lombok.*;
import com.realnet.WhoColumn.Extension; 
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    Event_Management extends Extension { 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

private String  practice_match;

private String  admin_name;

private String  ground;

private String datetime;

private String  name;


@Column(length = 2000)
private String description;

private boolean active;


}
