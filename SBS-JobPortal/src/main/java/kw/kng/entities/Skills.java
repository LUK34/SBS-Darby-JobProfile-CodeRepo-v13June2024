package kw.kng.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name="skills")
public class Skills
{
	//One JobSeekerProfile -> Many Skills -> One to Many Mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String experienceLevel;
	private String yearsOfExperience;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_seeker_profile")
	private JobSeekerProfile jobSeekerProfile;
	
}
