package org.spring.codingStory.config;

import lombok.RequiredArgsConstructor;
import org.spring.codingStory.buschatbot.entity.BusAnswer;
import org.spring.codingStory.buschatbot.entity.BusIntention;
import org.spring.codingStory.buschatbot.repository.BusAnswerRepository;
import org.spring.codingStory.buschatbot.repository.BusChatBotIntentionRepository;
import org.spring.codingStory.mRank.entity.RankEntity;
import org.spring.codingStory.mRank.repository.MRankRepository;
import org.spring.codingStory.member.entity.MemberEntity;
import org.spring.codingStory.member.repository.MemberRepository;
import org.spring.codingStory.member.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StartComponent implements CommandLineRunner {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final MRankRepository mRankRepository;

  private final BusAnswerRepository busAnswerRepository;
  private final BusChatBotIntentionRepository busChatBotIntentionRepository;


  @Override
  public void run(String... args) throws Exception {


    Optional<MemberEntity> member = memberRepository.findByUserEmail("admin@naver.com");

    MemberEntity memberEntity = MemberEntity.builder()
            .role(Role.ADMIN)
            .userEmail("admin@naver.com")
            .userPw(passwordEncoder.encode("1234"))
            .name("관리자")
            .phoneNumber("10504010")
            .department("본사")
            .mRank("사장")
            .address("서울")
            .memberAttachFile(0)
            .build();


    if (!member.isPresent()) {
      memberRepository.save(memberEntity);
    }


    Optional<RankEntity> rank1 = mRankRepository.findByRankName("사원");
    Optional<RankEntity> rank2 = mRankRepository.findByRankName("팀장");
    Optional<RankEntity> rank3 = mRankRepository.findByRankName("지점장");
    Optional<RankEntity> rank4 = mRankRepository.findByRankName("사장");

    RankEntity rankEntity = RankEntity.builder()
            .rankName("사원")
            .build();
    RankEntity rankEntity1 = RankEntity.builder()
            .rankName("팀장")
            .build();
    RankEntity rankEntity2 = RankEntity.builder()
            .rankName("지점장")
            .build();
    RankEntity rankEntity3 = RankEntity.builder()
            .rankName("사장")
            .build();


    if (!rank1.isPresent()) {
      mRankRepository.save(rankEntity);
    }
    if (!rank2.isPresent()) {
      mRankRepository.save(rankEntity1);
    }
    if (!rank3.isPresent()) {
      mRankRepository.save(rankEntity2);
    }
    if (!rank4.isPresent()) {
      mRankRepository.save(rankEntity3);
    }


    Optional<BusAnswer> bus1 = busAnswerRepository.findByKeyword("안녕");
    Optional<BusAnswer> bus2 = busAnswerRepository.findByKeyword("기타");
    Optional<BusAnswer> bus3 = busAnswerRepository.findByKeyword("버스");
    Optional<BusAnswer> bus4 = busAnswerRepository.findByKeyword("정류장");
    BusAnswer busAnswer = BusAnswer.builder()
            .no(1)
            .content("안녕하세요! 버스 봇 입니다")
            .keyword("안녕")
            .build();
    if (!bus1.isPresent()) {
      busAnswerRepository.save(busAnswer);
    }

    BusAnswer busAnswer2 = BusAnswer.builder()
            .no(2)
            .content("다시 입력해주세요")
            .keyword("기타")
            .build();
    if (!bus2.isPresent()) {
      busAnswerRepository.save(busAnswer2);
    }

    BusAnswer busAnswer3 = BusAnswer.builder()
            .no(3)
            .content("문의하신 버스에 대한 정보입니다")
            .keyword("버스")
            .build();
    if (!bus3.isPresent()) {
      busAnswerRepository.save(busAnswer3);
    }

    BusAnswer busAnswer4 = BusAnswer.builder()
            .no(4)
            .content("문의하신 정류장에 대한 정보입니다")
            .keyword("정류장")
            .build();

    if (!bus4.isPresent()) {
      busAnswerRepository.save(busAnswer4);
    }

    Optional<BusIntention> int1=busChatBotIntentionRepository.findByName("안녕");
    Optional<BusIntention> int2=busChatBotIntentionRepository.findByName("기타");
    Optional<BusIntention> int3=busChatBotIntentionRepository.findByName("버스");
    Optional<BusIntention> int4=busChatBotIntentionRepository.findByName("정류장");


    BusIntention intention = BusIntention.builder()
            .name("안녕")
            .answer(busAnswer)
            .build();
    if(!int1.isPresent()){
    busChatBotIntentionRepository.save(intention);
    }

    BusIntention intention2 = BusIntention.builder()
            .name("기타")
            .answer(busAnswer2)
            .build();
    if(!int2.isPresent()){
    busChatBotIntentionRepository.save(intention2);
    }

    BusIntention intention3 = BusIntention.builder()
            .name("버스")
            .answer(busAnswer3)
            .build();
    if(!int3.isPresent()){
    busChatBotIntentionRepository.save(intention3);
    }

    BusIntention intention4 = BusIntention.builder()
            .name("정류장")
            .answer(busAnswer4)
            .build();
    if(!int4.isPresent()){
    busChatBotIntentionRepository.save(intention4);
    }


  }


}
