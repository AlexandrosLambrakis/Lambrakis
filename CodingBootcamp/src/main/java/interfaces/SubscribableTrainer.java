package interfaces;

import models.Trainer;

public interface SubscribableTrainer {
    void subscribeTrainer(Trainer trainer);
    void subscribeTrainers(Trainer ...trainerArray);
}
