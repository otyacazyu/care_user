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
        String careNeeds = form.getCareNeeds();

        careService.createCare(name,gender,age,address,careNeeds,false);//ここでcareService.create()に必要なデータを渡す
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/care_user/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("問題なく登録されました"); //リクエストを作成して返信する

    }
    @PutMapping("care_user/{id}")    //既存のケア情報を更新する（PUT）
    public ResponseEntity<String> updateCare(@PathVariable Long id, @RequestBody CareForm from){
        List<CareEntity> existingCares = careMapper.findByName(String.valueOf(id));

        if(!existingCares.isEmpty()){// 提供されたフォームデータに基づいてケア情報を更新する。
            CareEntity existingCareEntity = existingCares.get(0);// ユニークな名前を想定
            existingCareEntity.setGender(from.getGender());
            existingCareEntity.setAge(from.getAge());
            existingCareEntity.setAddress(from.getAddress());
            existingCareEntity.setCareNeeds(from.getCareNeeds());

            careService.updateCare(from.getGender(),
                    from.getAge(),
                    from.getAddress(),
                    from.getCareNeeds()
            );

            careMapper.updateCare(existingCareEntity);// データベースのケア情報を更新する

            return ResponseEntity.ok("ケア情報が更新されました。");
        }else{// 指定された名前のケアユーザーが見つからない場合
            return ResponseEntity.notFound().build();
        }

    }
}





