package guru.qa.tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();

    public static String first_name = "Irina";
    public static String last_name = "Krbtv";
    public static String userEmail = faker.internet().emailAddress();
    public static String currentAddress = faker.leagueOfLegends().champion();
    public static String phone_number = "88005553535";
}
