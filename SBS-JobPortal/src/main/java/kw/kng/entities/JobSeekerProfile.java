package kw.kng.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
@Table(name="job_seeker_profile")
public class JobSeekerProfile 
{
	//One User -> One JobSeekerProfile -> One to One Mapping
	//One JobSeekerProfile -> Many Skills -> One to Many Mapping
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String workAuthorization;
	private String employmentType;
	private String resume;
	
	@Column(nullable=true, length=64)
	private String profilePhoto;

	@OneToMany(targetEntity=Skills.class,  cascade=CascadeType.ALL,  mappedBy="jobSeekerProfile")
	private List<Skills> skills;

	public JobSeekerProfile(Users userId) 
	{
		this.userId = userId;
	}
	
	
	
	
	
}
