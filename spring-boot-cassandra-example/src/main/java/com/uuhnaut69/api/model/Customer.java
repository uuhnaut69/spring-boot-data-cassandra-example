package com.uuhnaut69.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

/**
 * @author uuhnaut
 *
 */
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@PrimaryKey
	private UUID id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private boolean active;
}
