package com.zain.javacoffee.service;

import com.zain.javacoffee.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FriendServiceTest {

    @Autowired
    FriendService friendService;

    @Test
    public void testCreateRead() {
        Friend friend = new Friend("Ben","Stokes");
        friendService.save(friend);

        Iterable<Friend> friends = friendService.findByFirstName("Ben");
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Ben");


    }

}