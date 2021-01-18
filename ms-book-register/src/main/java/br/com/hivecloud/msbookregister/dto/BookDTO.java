package br.com.hivecloud.msbookregister.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class responsible to represents BookDTO
 * 
 * @author jlv
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private Long id;
	
	@NotBlank
	private String title;

	@NotBlank
	private String author;
	
	private String imageLink;
	
	@Min(1)
	private int pageCount;

	private String year;
}
