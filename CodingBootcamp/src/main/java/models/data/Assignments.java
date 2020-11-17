package models.data;

import models.assignments.AssignmentType;

import java.time.LocalDate;

public enum Assignments {
    ASSIGNMENT_0(0, "AB-01", AssignmentType.GROUP,       "Java Group Project",       LocalDate.of(2020, 1, 10), 2, 18),
    ASSIGNMENT_1(1, "AB-06", AssignmentType.INDIVIDUAL,  "Java Individual Project",  LocalDate.of(2020, 11, 18),12, 2),
    ASSIGNMENT_2(2, "AB-07", AssignmentType.INDIVIDUAL,  "Java Individual Project",  LocalDate.of(2020, 12, 3), 12, 30),
    ASSIGNMENT_3(3, "AB-03", AssignmentType.GROUP,       "C# Group Project",         LocalDate.of(2020, 4, 21), 6, 20),
    ASSIGNMENT_4(4, "AB-04", AssignmentType.INDIVIDUAL,  "C# Individual Project",    LocalDate.of(2020, 6, 22), 7, 25),
    ASSIGNMENT_5(5, "AB-05", AssignmentType.INDIVIDUAL,  "C# Individual Project",    LocalDate.of(2020, 9, 10), 10, 20),
    ASSIGNMENT_6(6, "AB-02", AssignmentType.GROUP,       "PHP Group Project",        LocalDate.of(2020, 2, 18), 3, 20),
    ASSIGNMENT_7(7, "AB-08", AssignmentType.INDIVIDUAL,  "PHP Individual Project",   LocalDate.of(2020, 2, 18), 3, 20)
    ;

    private final int index;
    private final String title;
    private final AssignmentType assignmentType;
    private final String description;
    private final LocalDate subDateTime;
    private final int oralMark;
    private final int totalMark;

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    Assignments(int index, String title, AssignmentType assignmentType, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.index = index;
        this.title = title;
        this.assignmentType = assignmentType;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
}
