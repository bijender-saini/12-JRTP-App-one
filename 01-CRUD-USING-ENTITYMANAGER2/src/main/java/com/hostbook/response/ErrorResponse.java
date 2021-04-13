package com.hostbook.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorResponse {


	private Date date;
	private HttpStatus status;
	private String msg;
}
