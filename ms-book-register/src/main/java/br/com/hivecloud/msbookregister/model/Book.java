package br.com.hivecloud.msbookregister.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class responsible to represents book in the system
 * 
 * @author jlv
 *
 */
@Entity
@Table(name = "TB_BOOK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	private String author;
	
	private String imageLink;
	
	private int pageCount;

	private String year;
	
}
