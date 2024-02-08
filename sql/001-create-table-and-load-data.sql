DROP TABLE IF EXISTS care_users;

CREATE TABLE care_users(
  id UUID DEFAULT UUID() PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  gender VARCHAR(10),
  age INT,
  address VARCHAR(250),
  care_needs VARCHAR(50),
  PRIMARY KEY (id)
);

INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("東京　太郎","男性",88,"東京都","要介護５");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("大阪　洋子","女性",65,"大阪府","要支援１");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("長野　恵子","女性",71,"長野県","要介護２");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("岩手　巌","男性",80,"岩手県","要介護４");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("秋田　稲穂","女性",61,"秋田県","要支援２");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("海道　北","女性",91,"北海道","要介護５");
INSERT INTO care_users (name,gender,age,address,care_needs) VALUES ("沖縄　渚","男性",70,"東京都","要介護５");
