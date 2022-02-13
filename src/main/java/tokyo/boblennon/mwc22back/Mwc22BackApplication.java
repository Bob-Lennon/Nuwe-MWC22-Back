package tokyo.boblennon.mwc22back;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import picocli.CommandLine;
import tokyo.boblennon.mwc22back.domain.developer.Developer;
import tokyo.boblennon.mwc22back.infrastructure.developer.DevRepositoryImp;

@SpringBootApplication
public class Mwc22BackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Mwc22BackApplication.class, args);
	}

	@Autowired
	private MainRunner mainRunner;

	// Runs both the CLI (made with Picocli) and the multi-option Menu
	@Override
	public void run(String... args) throws Exception {
		var service = CommandLine.populateCommand(mainRunner, args);
		service.menu();
	}


	// Insert the data fron "resources/json/devs.json" into the MySql Database "localhost:3306/mwc22"
	@Bean
	CommandLineRunner runner(DevRepositoryImp devRepositoryImp) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Developer>> typeReference = new TypeReference<List<Developer>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/devs.json");
			try {
				if (devRepositoryImp.getAll().size() < 1) {
					List<Developer> devs = mapper.readValue(inputStream, typeReference);
					for (Developer d : devs) {
						d.setId(UUID.randomUUID().toString());
					}
					devRepositoryImp.addAll(devs);
					System.out.println("Developers Saved!");
				}
			} catch (IOException e) {
				System.out.println("Unable to save developers: " + e.getMessage());
			}
		};
	}

}
