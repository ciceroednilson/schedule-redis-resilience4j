##################################################################################################



ALTER TABLE tb_car_brands AUTO_INCREMENT = 535;

LOAD DATA LOCAL INFILE '/home/cicero/projects/migration-iintegration/data-sql/marcas-carros.csv' 
INTO TABLE tb_car_brands 
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

#####################################################################################################


ALTER TABLE tb_car_models AUTO_INCREMENT = 5029;

LOAD DATA LOCAL INFILE '/home/cicero/projects/migration-iintegration/data-sql/modelos-carro.csv' 
INTO TABLE tb_car_models 
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

