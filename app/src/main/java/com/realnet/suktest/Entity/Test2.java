package com.realnet.suktest.Entity;
 import lombok.*;
import com.realnet.WhoColumn.Extension; 
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    Test2 extends Extension { 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

private String  name;

private String  description;


}
