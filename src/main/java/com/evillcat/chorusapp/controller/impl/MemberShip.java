package com.evillcat.chorusapp.controller.impl;

import com.evillcat.chorusapp.controller.IMemberShip;
import com.evillcat.chorusapp.controller.response.BaseResponse;
import com.evillcat.chorusapp.dto.MemberRegistrationDto;
import com.evillcat.chorusapp.model.Member;
import com.evillcat.chorusapp.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberShip implements IMemberShip {

    private final SubscriptionService subscriptionService;
    private static final String SUCCESS_SUBSCRIBE_MSG = "Вы были успешно подписаны.";
    private static final String UNSUCCESS_SUBSCRIBE_MSG = "Произошла ошибка. Вы не подписаны.";
    private static final String SUCCESS_UNSUBSCRIBE_MSG = "Вы успешно отписались.";
    private static final String UNSUCCESS_UNSUBSCRIBE_MSG = "Вы не смогли отписаться... Новости будут приходить.";

    @Override
    public BaseResponse<Member> subscribe(MemberRegistrationDto memberDto) {
        Member member = Member.builder()
            .nameAndSurname(memberDto.getName())
            .phoneNumber(memberDto.getPhoneNumber())
            .build();
        boolean isSubscribed = subscriptionService.subscribeMember(member);

        return isSubscribed ? new BaseResponse<>(member, SUCCESS_SUBSCRIBE_MSG)
            : new BaseResponse<>(member, UNSUCCESS_SUBSCRIBE_MSG);
    }

    @Override
    public BaseResponse<Member> unSubscribe(Long id) {
        Member member = Member.builder().id(id).build();
        boolean isUnsubscribed = subscriptionService.unsubscribe(member);
        return isUnsubscribed ? new BaseResponse<>(member, SUCCESS_UNSUBSCRIBE_MSG) : new BaseResponse<>(member,
            UNSUCCESS_UNSUBSCRIBE_MSG);
    }
}
