package models;

import com.github.javafaker.Faker;

public class MyStatusFactory {
    static Faker faker = new Faker();

    public static MyStatus get() {
        return MyStatus.builder()
                .statusText(faker.cat().name())
                .build();
    }
}
