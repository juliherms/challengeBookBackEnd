package br.com.hivecloud.msbookregister.dto;

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

	@NotBlank
	private String title;

	@NotBlank
	private String author;

	private int year;
}
