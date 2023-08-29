package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get() {
        return AboutMe.builder()
                .t1(faker.address().city())
                .t2(faker.job().title())
                .t3(faker.esports().game())
                .t4(faker.beer().name())
                .t5(faker.beer().name())
                .t6(faker.beer().name())
                .t7(faker.beer().name())
                .t8(faker.beer().name())
                .t9(faker.beer().name())
                .t10(faker.music().genre())
                .t11(faker.food().dish())
                .t12(faker.food().fruit())
                .t13(faker.dog().name())
                .t14(faker.cat().name())
                .t15(faker.funnyName().name())
                .build();
    }
}
