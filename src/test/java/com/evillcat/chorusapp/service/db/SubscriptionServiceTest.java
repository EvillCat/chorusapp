package com.evillcat.chorusapp.service.db;

import static com.evillcat.chorusapp.service.db.SubscriptionServiceTestUtil.SUB_MEMBER;
import static org.junit.Assert.*;

import com.evillcat.chorusapp.ChorusappApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@SpringBootTest(classes = ChorusappApplication.class)
public class SubscriptionServiceTest {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private MemberService memberService;

    @Test
    public void testSubscribe_Ok() {
        subscriptionService.subscribeMember(SUB_MEMBER);
        assertEquals(SUB_MEMBER, memberService.getAll().get(0));
    }

}