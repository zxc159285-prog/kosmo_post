package com.karina.app.account;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDTO {
	private String accountNum;
	private String username;
	private Long productNum;
	private Long accountPw;
	private Long accountBalance;
	private LocalDate accountDate;
}