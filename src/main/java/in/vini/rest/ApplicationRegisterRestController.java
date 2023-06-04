package in.vini.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vini.entity.CitizenEntity;
import in.vini.request.CitizenRequest;
import in.vini.service.CitizenServiceImpl;

@RestController
public class ApplicationRegisterRestController {

	private Logger logger = LoggerFactory.getLogger(ApplicationRegisterRestController.class);

	@Autowired
	private CitizenServiceImpl service;

	@PostMapping("/create-application")
	public ResponseEntity<CitizenEntity> createApplication(@RequestBody CitizenRequest req) {

		try {

			String app = service.CreateApplication(req);

			if (app.contains("application created")) {
				return new ResponseEntity<CitizenEntity>(HttpStatus.CREATED);
			}
			return new ResponseEntity<CitizenEntity>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("error occured while creating appplication for citizen : ", e.getMessage());
			return new ResponseEntity<CitizenEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/view-applications")
	public List<CitizenEntity> viewApplications() {

		try {
			List<CitizenEntity> viewApplications = service.viewApplications();

			return viewApplications;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;

	}
}
