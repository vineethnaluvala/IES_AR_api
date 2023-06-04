package in.vini.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vini.entity.CitizenEntity;
import in.vini.repo.CitizenRepo;
import in.vini.request.CitizenRequest;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepo repo;

	private Integer count = 101;

	@Override
	public String CreateApplication(CitizenRequest req) {

		CitizenEntity findByEmail = repo.findByEmail(req.getEmail());
		if (findByEmail == null) {

			CitizenEntity citizenEntity = new CitizenEntity();
			BeanUtils.copyProperties(req, citizenEntity);
			citizenEntity.setCaseNum(count);
			repo.save(citizenEntity);
			count++;
			return "application created";
		}

		return "email already exists";
	}

	@Override
	public List<CitizenEntity> viewApplications() {
		
		List<CitizenEntity> applications = repo.findAll();
		
		return applications;
	}

	

}
