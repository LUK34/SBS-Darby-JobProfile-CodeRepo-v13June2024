package kw.kng.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="recruiter_profile")
public class RecruiterProfile 
{
	//One User -> One RecruiterProfile - One to One Mapping
	
	@Id
	private int userAccountId;
	
	@OneToOne
	@JoinColumn(name="user_account_id")
	@MapsId
	private Users userId; //This is going and refering the above attribute of that entity
	
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String country;
	private String company;
	
	@Column(nullable=true, length=64)
	private String profilePhoto;

	public RecruiterProfile(Users users)
	{
		this.userId = users;
	}
	
	

}

/*

The @MapsId annotation in JPA is used to map a composite primary key and its relationships. 
It allows you to map an entity's primary key to another entity's primary key.
In your case, it’s being used in a one-to-one relationship between RecruiterProfile and Users.

Explanation of @MapsId
-----------------------------------
1. Primary Key Mapping: 
The @MapsId annotation indicates that the primary key of the RecruiterProfile entity is also a foreign key to the primary key of the Users entity.

2. Shared Primary Key:
The primary key of the RecruiterProfile entity (userAccountId) is mapped to the primary key of the Users entity (userId). 
This means both entities share the same primary key value.

3. Foreign Key Mapping:
The @JoinColumn(name="user_account_id") annotation specifies the foreign key column (user_account_id) in the RecruiterProfile table that maps to the id column in the Users table. 
 
 */











