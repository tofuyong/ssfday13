package ibf2022.ssf.day13;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class Day13Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day13Application.class, args);
	}

	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);

			File fileDir = new File(dataDir);

			// just for testing
			if (!fileDir.exists()) {
				fileDir.mkdir();
				System.out.println("***" + fileDir.getAbsolutePath());
				System.out.println("***" + fileDir.getPath());
				System.out.println("***" + fileDir.getParent());
			} else {
				System.out.println(fileDir.getAbsolutePath());
			}
		}
	}

}
