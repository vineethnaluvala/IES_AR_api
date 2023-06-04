package in.vini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vini.entity.CitizenEntity;

public interface CitizenRepo extends JpaRepository<CitizenEntity, Integer> {

	public CitizenEntity findByEmail(String mail);
}
