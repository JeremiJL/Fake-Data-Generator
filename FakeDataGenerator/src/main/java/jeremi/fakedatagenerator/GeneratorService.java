package jeremi.fakedatagenerator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GeneratorService {

    private static final Faker faker = new Faker();

    // I do not want to have this hardcoded in html file
    private final List<String> additionalFieldsList = Arrays.stream(Person.class.getDeclaredFields()).filter(f -> f.isAnnotationPresent(Additional.class)).map(f -> f.getName()).collect(Collectors.toList());
    private final List<String> languagesList = Arrays.asList("english","polish","dutch","french","ukrainian","spanish","italian","portuguese","czech");

    public List<String> getAdditionalFieldsList(){
        return additionalFieldsList;
    }

    public List<String> getLanguagesList(){
        return languagesList;
    }

    public List<Person> generatePersons(int number,String language, List<String> additionalFields){

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < number; i++){
            Person person = new Person();
            // Set obligatory fields
            person.setName(faker.name().firstName());
            person.setSurname(faker.name().lastName());
            person.setBirthday(faker.date().birthday(18,60));
            // Set additional fields
            if (additionalFields.contains("university"))
                person.setUniversity(faker.university().name());
            if (additionalFields.contains("country"))
                person.setCountry(faker.country().name());
            if (additionalFields.contains("phone"))
                person.setPhone(faker.phoneNumber().cellPhone());
            if (additionalFields.contains("email"))
                person.setEmail(faker.bothify(person.getName()+person.getSurname()+"###"+"@gmail.com"));
            if (additionalFields.contains("index"))
                person.setIndex(faker.idNumber().valid());
            if (additionalFields.contains("employment"))
                person.setEmployment(faker.job().field());
            if (additionalFields.contains("company"))
                person.setCompany(faker.company().name());
            if (additionalFields.contains("address"))
                person.setAddress(faker.address().streetAddress());

            // Add created Person to person list
            personList.add(person);
        }

        return personList;
    }
}
