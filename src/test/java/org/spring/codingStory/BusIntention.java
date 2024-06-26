package org.spring.codingStory;

import org.junit.jupiter.api.Test;
import org.spring.codingStory.buschatbot.entity.BusAnswer;
import org.spring.codingStory.buschatbot.repository.BusAnswerRepository;
import org.spring.codingStory.buschatbot.repository.BusChatBotIntentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BusIntention {

  @Autowired
  BusAnswerRepository busAnswerRepository;
  @Autowired
  BusChatBotIntentionRepository busChatBotIntentionRepository;

  @Test
  public void busIntention(){
    BusAnswer busAnswer=BusAnswer.builder()
            .no(1)
            .content("안녕하세요! 버스 봇 입니다")
            .keyword("안녕")
            .build();
    busAnswerRepository.save(busAnswer);
    BusAnswer busAnswer2=BusAnswer.builder()
            .no(2)
            .content("다시 입력해주세요")
            .keyword("기타")
            .build();
    busAnswerRepository.save(busAnswer2);
    BusAnswer busAnswer3=BusAnswer.builder()
            .no(3)
            .content("문의하신 버스에 대한 정보입니다")
            .keyword("버스")
            .build();
    busAnswerRepository.save(busAnswer3);
    BusAnswer busAnswer4=BusAnswer.builder()
            .no(4)
            .content("문의하신 정류장에 대한 정보입니다")
            .keyword("정류장")
            .build();
    busAnswerRepository.save(busAnswer4);


    org.spring.codingStory.buschatbot.entity.BusIntention intention= org.spring.codingStory.buschatbot.entity.BusIntention.builder()
            .name("안녕")
            .answer(busAnswer)
            .build();
    busChatBotIntentionRepository.save(intention);
    org.spring.codingStory.buschatbot.entity.BusIntention intention2= org.spring.codingStory.buschatbot.entity.BusIntention.builder()
            .name("기타")
            .answer(busAnswer2)
            .build();
    busChatBotIntentionRepository.save(intention2);
    org.spring.codingStory.buschatbot.entity.BusIntention intention3= org.spring.codingStory.buschatbot.entity.BusIntention.builder()
            .name("버스")
            .answer(busAnswer3)
            .build();
    busChatBotIntentionRepository.save(intention3);
    org.spring.codingStory.buschatbot.entity.BusIntention intention4= org.spring.codingStory.buschatbot.entity.BusIntention.builder()
            .name("정류장")
            .answer(busAnswer4)
            .build();
    busChatBotIntentionRepository.save(intention4);

  }


}
