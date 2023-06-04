package in.vini.service;

import java.util.List;

import in.vini.entity.CitizenEntity;
import in.vini.request.CitizenRequest;

public interface CitizenService {

	public String CreateApplication(CitizenRequest req);

	public  List<CitizenEntity> viewApplications();
}
