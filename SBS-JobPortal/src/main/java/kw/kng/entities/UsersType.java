package kw.kng.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="users_type")
public class UsersType 
{
	//One `UsersType` -> Many `Users` (One to Many Bi-Directional Mapping) 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userTypeId;
	
	private String userTypeName;
	
	@OneToMany(targetEntity=Users.class,  mappedBy="userTypeId",  cascade=CascadeType.ALL)
	private List<Users> users;
}
















