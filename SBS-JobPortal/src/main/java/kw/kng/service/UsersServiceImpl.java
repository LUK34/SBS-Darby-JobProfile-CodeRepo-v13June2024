package kw.kng.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import kw.kng.entities.JobSeekerProfile;
import kw.kng.entities.RecruiterProfile;
import kw.kng.entities.Users;
import kw.kng.repo.JobSeekerProfileRepo;
import kw.kng.repo.RecruiterProfileRepo;
import kw.kng.repo.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService
{
	private final UsersRepo urepo;
	private final JobSeekerProfileRepo jsprepo;
	private final RecruiterProfileRepo rprepo;
	
	public UsersServiceImpl(UsersRepo urepo, 
											 JobSeekerProfileRepo jsprepo,
											 RecruiterProfileRepo rprepo ) 
	{
		this.urepo = urepo;
		this.jsprepo=jsprepo;
		this.rprepo=rprepo;
	}

	public Users addNew(Users users)
	{
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		Users savedUser = urepo.save(users);
//		savedUser.getUserId();
		int userTypeId= users.getUserTypeId().getUserTypeId(); //UsersType -> Users (One to Many relationship)
		/*
		 	Many users to One usersType :
		 	-------------------------------------------
		 	Users (Entity) ->
		 	 	private UsersType userTypeId; ->
		 	 		users.getUserTypeId() [ GET userTypeId from Users (Entity) ]-> 
		 	 				UsersType (Entity) ->
		 	 						private int userTypeId; ->
		 	 								users.getUserTypeId().getUserTypeId() [ GET userTypeId from UsersType (Entity) ]
		 */
		if(userTypeId == 1) //If the userTypeId==1 then it is RECRUITERS profile. Else JOB SEEKERS profile.
		{
			rprepo.save(new RecruiterProfile(savedUser));
		}
		else 
		{
			jsprepo.save(new JobSeekerProfile(savedUser));
		}
		return savedUser;
	}
	
	
	
}
