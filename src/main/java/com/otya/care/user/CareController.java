package com.otya.care.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CareController {
    private final CareMapper careMapper;
    private final CareService careService;


    public CareController(CareMapper careMapper, CareService careService) {
        this.careMapper = careMapper;
        this.careService = careService;
    }

    @GetMapping("/care_user")
    public List<Care> careUser(){
        return careMapper.findAll();
    }

    @PostMapping("/care_user")
    public ResponseEntity<?> createCare(@RequestBody CareForm form) throws CareDuplicateException {
        String name = form.getName();
        String gender = form.getGender();
        int age = form.getAge();
        String address = form.getAddress();
        String careNeeds = form.getCareNeeds();

        careService.createCare(name,gender,age,address,careNeeds,false);//ここでcareService.create()に必要なデータを渡す
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/care_user/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("問題なく登録されました"); //リクエストを作成して返信する
    }
}
