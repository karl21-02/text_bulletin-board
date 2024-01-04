package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		Global.initScanner();
		new App().run();
		Global.exitScanner();
	}
}
