package org.cos.chatapp;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable // 커서를 닫지 않고 계속 유지
    @Query("{sender:?0, receiver:?1}")
    // Flux (흐름) => response를 유지하면서 데이터를 계속 흘려보내기
    Flux<Chat> mFindBySender(String sender, String receiver);
}
