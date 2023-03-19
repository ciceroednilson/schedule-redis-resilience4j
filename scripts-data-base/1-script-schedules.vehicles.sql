CREATE TABLE IF NOT EXISTS tb_car_brands(
   `id` 		   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `description`   VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS tb_car_models(
   `id` 		   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `id_brand`      INT NOT NULL, 
   `description`   VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_brand) REFERENCES tb_car_brands(id)
);


