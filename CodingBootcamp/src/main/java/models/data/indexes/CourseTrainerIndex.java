package models.data.indexes;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static models.data.Courses.*;
import static models.data.Trainers.*;

public enum CourseTrainerIndex {
    JAVA_FULL_TRAINERS   (COURSE_0.getIndex(), asList(TRAINER_0.getIndex(), TRAINER_1.getIndex())),
    JAVA_PART_TRAINERS   (COURSE_1.getIndex(), singletonList(TRAINER_0.getIndex())),
    CSHARP_FULL_TRAINERS (COURSE_2.getIndex(), asList(TRAINER_2.getIndex(), TRAINER_3.getIndex())),
    CSHARP_PART_TRAINERS (COURSE_3.getIndex(), singletonList(TRAINER_2.getIndex())),
    PHP_FULL_TRAINERS    (COURSE_4.getIndex(), singletonList(TRAINER_4.getIndex())),
    PHP_PART_TRAINERS    (COURSE_5.getIndex(), singletonList(TRAINER_5.getIndex()));

    private final int courseIndex;
    private final List<Integer> trainerIndexes;

    public int getCourseIndex() {
        return courseIndex;
    }

    public List<Integer> getTrainerIndexes() {
        return trainerIndexes;
    }

    CourseTrainerIndex(int courseIndex, List<Integer> trainerIndexes) {
        this.courseIndex = courseIndex;
        this.trainerIndexes = trainerIndexes;
    }
}
