package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AboutMe {

    String location;
    String occupation;
    String interest;
    String whyDoYouWorkout;
    String howDidYourStart;
    String whatMotivatesYou;
    String mainGoal;
    String longTermGoals;
    String shortTermGoals;
    String music;
    String Food;
    String supplements;
    String exercises;
    String magazines;
    String movies;

}
