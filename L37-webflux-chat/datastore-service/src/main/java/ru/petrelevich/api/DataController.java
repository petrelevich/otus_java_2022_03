package ru.petrelevich.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import ru.petrelevich.domain.Message;
import ru.petrelevich.domain.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.petrelevich.service.DataStore;

@RestController
public class DataController {
    private static final Logger log = LoggerFactory.getLogger(DataController.class);
    private final DataStore dataStore;
    private final Scheduler workerPool;

    public DataController(DataStore dataStore, Scheduler workerPool) {
        this.dataStore = dataStore;
        this.workerPool = workerPool;
    }

    @PostMapping(value = "/msg/{roomId}")
    public void messageFromChat(@PathVariable("roomId") String roomId,
                                @RequestBody MessageDto messageDto) {
        var messageStr = messageDto.messageStr();
        log.info("messageFromChat, roomId:{}, msg:{}", roomId, messageStr);

        Mono.just(new Message(roomId, messageStr))
                .publishOn(workerPool)
                .doOnNext(msg -> log.info("msg saving:{}", msg))
                .flatMap(dataStore::saveMessage)
                .publishOn(workerPool)
                .doOnNext(msgSaved -> log.info("msgSaved id:{}", msgSaved.getId()))
                .subscribe();

        log.info("messageFromChat, roomId:{}, msg:{} done", roomId, messageStr);
    }

    @GetMapping(value = "/msg/{roomId}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<MessageDto> getMessagesByRoomId(@PathVariable("roomId") String roomId) {
        log.info("getMessagesByRoomId, roomId:{}", roomId);
        return dataStore.loadMessages(roomId)
                .map(message -> new MessageDto(message.getMsgText()));
    }
}
