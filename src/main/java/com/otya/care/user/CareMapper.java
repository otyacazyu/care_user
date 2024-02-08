package com.otya.care.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CareMapper {

    @Select("SELECT * FROM care_users") //GET 一括取得する。// 既存のケア情報をすべて取得する
    List<Care> findAll();

    @Select("SELECT * FROM care_users WHERE name = #{name}")
    List<CareEntity> findByname(String name);//名前を指定してケア情報を取得する

    // 新しいケア情報を挿入する
    @Insert("INSERT INTO care_users (name, gender, age, address, care_needs) VALUES (#{name}, #{gender}, #{age}, #{address}, #{care_needs})")
    void insertCare(CareEntity care);
}
