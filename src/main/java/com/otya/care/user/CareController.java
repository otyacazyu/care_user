package com.otya.care.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        String care_needs = form.getCareNeeds();

        careService.createCare(name,gender,age,address,care_needs,false);//ここでcareService.create()に必要なデータを渡す
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/care_user/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("問題なく登録されました"); //リクエストを作成して返信する

    }
    @PutMapping("care_user/{name}")    //既存のケア情報を更新する（PUT）
    public ResponseEntity<String> updateCare(@PathVariable String name, @RequestBody CareForm from){
        List<CareEntity> existingCares = careMapper.findByName(name);

        if(!existingCares.isEmpty()){// 提供されたフォームデータに基づいてケア情報を更新する。
            CareEntity existaingCareEntity = existingCares.get(0);// ユニークな名前を想定
            existingCares.setGender(from.getGender());
            existingCares.setAge(from.getAge());
            existingCares.setAddress(from.getAddress());
            existingCares.setCareNeeds(from.getCareNeeds());

            CareMapper.updateCare(existaingCareEntity);// データベースのケア情報を更新する

            return ResponseEntity.ok("ケア情報が更新されました。");
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}





