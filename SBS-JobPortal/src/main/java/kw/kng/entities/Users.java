package kw.kng.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class Users 
{
	//One `UsersType` -> Many `Users` (One to Many Bi-Directional Mapping) 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique=true)
	private String email;
	
	@NotEmpty
	private String password;
	
	private boolean isActive;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registrationDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userTypeId", referencedColumnName="userTypeId")
	private UsersType userTypeId;
	
}
