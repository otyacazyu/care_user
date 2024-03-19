package com.otya.care.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CareMapper {


    @Select("SELECT * FROM care_users")//GET 一括取得する。// 既存のケア情報をすべて取得する
    List<Care> findAll();

    @Select("SELECT * FROM care_users WHERE id = #{id}")
    List<CareEntity> findByName(String name);//名前を指定してケア情報を取得する

    @Update("UPDATE care_users SET gender = #{gender}, age = #{age}, address = #{address}, care_needs =#{careNeeds} WHERE id = #{id} ")
    void updateCare(CareEntity careEntity);//PUT ケア情報の一部を変更し、登録する

    // 新しいケア情報を挿入する(id 列を指定せず、UUIDはデフォルト値で生成される
    @Insert("INSERT INTO care_users (name, gender, age, address, care_needs) VALUES (#{name}, #{gender}, #{age}, #{address}, #{care_needs})")
    void insertCare(CareEntity care);



}
