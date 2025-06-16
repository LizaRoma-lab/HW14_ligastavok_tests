package testutils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FakeData {
    Faker faker = new Faker(new Locale("en-GB"));
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public String userNumber = faker.phoneNumber().subscriberNumber(10),
            userDateOfBirth = formatter.format(faker.date().birthday()),
            userEmail = faker.internet().emailAddress(),
            userPassword = faker.internet()
                    .password(8, 30, true, true, false);

}
