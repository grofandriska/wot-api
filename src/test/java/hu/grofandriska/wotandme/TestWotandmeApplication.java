package hu.grofandriska.wotandme;

import org.springframework.boot.SpringApplication;

public class TestWotandmeApplication {

	public static void main(String[] args) {
		SpringApplication.from(WotandmeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
