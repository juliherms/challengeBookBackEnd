package br.com.hivecloud.msbookregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserDTO {

	private Long idUser;

	private Long idBook;

	private int level;

	private String title;

	private String description;

	private Integer status;
}
