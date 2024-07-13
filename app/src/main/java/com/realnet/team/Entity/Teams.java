package com.realnet.team.Entity;
 import lombok.*;
import com.realnet.WhoColumn.Extension; 
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    Teams extends Extension { 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

private String  team_name;

private String  logoname;
private String  logopath ;


@Column(length = 2000)
private String description;

private String  members;

private String  matches;

private boolean active;


}
