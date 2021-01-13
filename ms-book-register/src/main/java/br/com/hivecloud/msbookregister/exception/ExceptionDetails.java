package br.com.hivecloud.msbookregister.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * This class responsible to represents details about exception
 * @author jlv
 *
 */
@Data
@SuperBuilder
public class ExceptionDetails {

	private String title;
	private int status;
	private String details;
	private String developerMessage;
	private LocalDateTime timestamp;
}
