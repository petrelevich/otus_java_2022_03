package ru.petrelevich.service;

import java.time.Duration;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.NonNull;
import ru.petrelevich.domain.Message;
import ru.petrelevich.repository.MessageRepository;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class DataStoreR2dbc implements DataStore {
    private final MessageRepository messageRepository;
    private final Scheduler workerPool;

    public DataStoreR2dbc(Scheduler workerPool, MessageRepository messageRepository) {
        this.workerPool = workerPool;
        this.messageRepository = messageRepository;
    }

    @Override
    public Mono<Message> saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Flux<Message> loadMessages(String roomId) {
        return messageRepository.findByRoomId(roomId)
                .delayElements(Duration.of(3, SECONDS), workerPool);
    }
}
