package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity(name="board1")
public class Board {
	@Id
	@GeneratedValue
	private Long bno;
	private String title;
	private String content;
	// private String writer;
	
	@ManyToOne // 다대일 관계
	private Member member;
	
}
