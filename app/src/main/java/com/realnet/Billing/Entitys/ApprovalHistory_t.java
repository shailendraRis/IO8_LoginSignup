package com.realnet.Billing.Entitys;
 import lombok.*;
 import javax.persistence.*;
 import java.time.LocalDateTime;
 import java.util.*;

 @Entity 
 @Data
 public class    ApprovalHistory_t{ 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String document_type;
 private Long document_id;
 private String actioned_by;
 private String action;
 private String comments;
 
 private String approvalStatus;

 }