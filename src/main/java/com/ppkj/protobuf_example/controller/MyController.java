package com.ppkj.protobuf_example.controller;

import com.ppkj.myprotobuf1.protobuf.User;
import com.ppkj.myprotobuf1.protobuf.common.CommonHeader;
import com.ppkj.myprotobuf1.protobuf.common.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {


    @GetMapping(value = "/my-controller/user", produces = MediaType.APPLICATION_PROTOBUF_VALUE)
    public ResponseEntity<User> getUser() {

        String id = UUID.randomUUID().toString().replace("-", "");

        User user = User.newBuilder()
                .setCommon(CommonHeader.newBuilder()
                        .setId(id)
                        .build())
                .setGender(Gender.Male)
                .setMyData(User.MyData.newBuilder()
                        .setName("YourName")
                        .setSurname("YourSurname")
                        .build())
                .build();

        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/my-controller/user", consumes = MediaType.APPLICATION_PROTOBUF_VALUE)
    public void putMessage(@RequestBody User user) {
        log.info("User : [{}]", user);
    }


}
