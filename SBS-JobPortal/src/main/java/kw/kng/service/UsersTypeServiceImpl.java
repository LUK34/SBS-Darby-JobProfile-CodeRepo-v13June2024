package kw.kng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kw.kng.entities.UsersType;
import kw.kng.repo.UsersTypeRepo;

@Service
public class UsersTypeServiceImpl implements UsersTypeService
{
	private final UsersTypeRepo utrepo;

	public UsersTypeServiceImpl(UsersTypeRepo utrepo) 
	{
		this.utrepo = utrepo;
	}

	@Override
	public List<UsersType> getAll() 
	{
		return utrepo.findAll();
	}
	

	
	
}
