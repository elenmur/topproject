package automationpractice;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmail {

    public static String createRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        System.out.println(generatedString);

        String randomEmail = generatedString + "@mail.by";
        return randomEmail;
    }
}

