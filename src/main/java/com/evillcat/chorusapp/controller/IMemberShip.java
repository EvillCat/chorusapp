package com.evillcat.chorusapp.controller;

import com.evillcat.chorusapp.controller.response.BaseResponse;
import com.evillcat.chorusapp.dto.MemberRegistrationDto;
import com.evillcat.chorusapp.model.Member;

public interface IMemberShip {

    /**
     * Подписка на события. При подписке пользователю будет присвоен стандартный статус(ACTIVE) и стандартная группа
     * (ALL).
     *
     * @param memberDto {@link MemberRegistrationDto} содержит информацию о пользователе.
     * @return вернет базовый ответ. Он содержит {@link Member} если регистрация успешна. Если регистрация не прошла,
     * то будет содержать null.
     */
    BaseResponse<Member> subscribe(MemberRegistrationDto memberDto);

    BaseResponse<Member> unSubscribe(Long id);

}
