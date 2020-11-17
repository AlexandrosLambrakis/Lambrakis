package models.subs;

import interfaces.SubscribableTrainer;
import interfaces.ViewSubscribable;
import models.Trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubTrainer implements SubscribableTrainer, ViewSubscribable {
    private final List<Trainer> trainers = new ArrayList<>();

    private SubTrainer(Trainer ...trainerArray) {
        trainers.addAll(Arrays.asList(trainerArray));
    }
    private SubTrainer(List<Trainer> trainerList) {
        trainers.addAll(trainerList);
    }

    @Override
    public void subscribeTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public void subscribeTrainers(Trainer... trainerArray) {
        trainers.addAll(Arrays.asList(trainerArray));
    }

    @Override
    public void viewSubscribable() {
        trainers.forEach(trainer -> System.out.println("\t"+trainer.customView("\t\t")));
    }

    public static SubTrainer build(Trainer ...trainer) {
        return new SubTrainer(trainer);
    }

    public static SubTrainer build(List<Trainer> trainerList) {
        return new SubTrainer(trainerList);
    }
}
