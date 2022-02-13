package tokyo.boblennon.mwc22back.infrastructure.developer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tokyo.boblennon.mwc22back.domain.developer.Developer;

@Repository
public interface DevRepositoryJPA extends JpaRepository<Developer, UUID> {

}
