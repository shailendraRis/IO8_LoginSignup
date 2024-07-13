package com.realnet.api_registery.Entity;

import lombok.*;
import com.realnet.WhoColumn.Extension;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
public class Token_registery extends Extension {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String token_name;

	@Lob
	private String token;

}
