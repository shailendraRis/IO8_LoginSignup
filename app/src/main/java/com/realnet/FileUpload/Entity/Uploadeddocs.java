package com.realnet.FileUpload.Entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
public class Uploadeddocs extends who_column {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ref;
	private String ref_table_name;

	private String uploadedfile_name;
	private String uploadedfile_path;

}
