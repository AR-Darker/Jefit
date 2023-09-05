package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get() {
        return AboutMe.builder()
                .location(faker.address().city())
                .occupation(faker.job().title())
                .interest(faker.esports().game())
                .whyDoYouWorkout(faker.beer().name())
                .howDidYourStart(faker.beer().name())
                .whatMotivatesYou(faker.beer().name())
                .mainGoal(faker.beer().name())
                .longTermGoals(faker.beer().name())
                .shortTermGoals(faker.beer().name())
                .music(faker.music().genre())
                .Food(faker.food().dish())
                .supplements(faker.food().fruit())
                .exercises(faker.dog().name())
                .magazines(faker.cat().name())
                .movies(faker.funnyName().name())
                .build();
    }
}
