package com.zain.javacoffee.controller;

import com.zain.javacoffee.model.Friend;
import com.zain.javacoffee.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.validator.ValidatorException;

import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend) throws ValidatorException {
        if (friend.getID() == 0 && friend.getFirstName() != null && friend.getLastName() != null) {
            return friendService.save(friend);
        } else throw new ValidatorException("friend cant be saved");

    }

    @GetMapping("/friend")
    Iterable<Friend> read() {
        return friendService.findAll();
    }

    @GetMapping("/friend/{id}")
    Optional<Friend> findByID(@PathVariable Integer id) {
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(@RequestParam(value = "first", required = false) String firstName, @RequestParam(value = "last", required = false) String lastName) {
        if (firstName != null) {
            return friendService.findByFirstName(firstName);
        } else if (lastName != null) {
            return friendService.findByLastName(lastName);
        } else if (firstName != null && lastName != null) {
            return friendService.findByFirstNameAndLastName(firstName, lastName);
        } else {
            return friendService.findAll();
        }
    }

    @PutMapping("/friend")
    ResponseEntity update(@RequestBody Friend friend) {
        if (!friendService.findById(friend.getID()).isPresent()) {
            return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
        } else {
            return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/friend/{id}")
    void deleteByID(@PathVariable Integer id) {
        friendService.deleteById(id);
    }

}
