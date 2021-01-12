package br.com.hivecloud.msbookregister.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class responsible to represents BookDTO
 * @author jlv
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	@NotBlank
	private String name;

	@NotEmpty
	private int year;
}
