package com.otya.care.user;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CareService {

    private final CareMapper careMapper;

    public CareService(CareMapper careMapper) {
        this.careMapper = careMapper;
    }

    public void createCare(String name, String gender, int age, String address, String careNeeds, boolean allowDuplicate) throws CareDuplicateException {
        List<CareEntity> existingCares = careMapper.findByName(name); //重複チェック
        // 重複がない場合または許可されている場合、新しいデータを作成して挿入
        if (existingCares.isEmpty() || allowDuplicate) {

            CareEntity newCareEntity = new CareEntity();
            newCareEntity.setName(name);
            newCareEntity.setGender(gender);
            newCareEntity.setAge(age);
            newCareEntity.setAddress(address);
            newCareEntity.setCareNeeds(careNeeds);
            careMapper.insertCare(newCareEntity);
        } else {
            throw new CareDuplicateException("重複データが見つかりました。確認し、再度行って下さい。");

        }
    }
}
