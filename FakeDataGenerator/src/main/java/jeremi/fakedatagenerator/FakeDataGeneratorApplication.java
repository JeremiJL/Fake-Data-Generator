package jeremi.fakedatagenerator;

import com.github.javafaker.service.FakeValuesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
public class FakeDataGeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(FakeDataGeneratorApplication.class, args);

//        Faker faker = new Faker(new Locale("pl-PL"));
//        String name = faker.name().firstName();
//
//        System.out.println(name);
    }

}
