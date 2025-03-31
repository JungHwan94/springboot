package com.study.springboot.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Member1")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String email;

	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}
}