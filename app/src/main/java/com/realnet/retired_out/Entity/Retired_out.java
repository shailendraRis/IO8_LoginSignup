package com.realnet.retired_out.Entity;
 import lombok.*;
import com.realnet.WhoColumn.Extension; 
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    Retired_out extends Extension { 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

@Column(length = 2000)
private String description;

private boolean active;

private String player_name;


}
