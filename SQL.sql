--- Գտնել այն մատակարաներին, որոնք մատակարարում են համակարգիչներ

SELECT maker
from user_management.product
where type='PC'

---- Գտնել մատակարաներին և նրանց մատակարարած մոդելների քանակը:
SELECT maker, count(model) AS 'Product count'
FROM product

---- Գտնել որ մատակարը քանի տեսակի ապրանք է մատակարարում:
SELECT maker, count(DISTINCT type) AS 'Type count'
FROM product
GROUP BY maker;

---- Գտնել laptop-ների միջին գինը:
SELECT AVG (price)
FROM laptop

---- Գտնել համակարգիչների կոդերը, մոդելները, արագությունները, գինը և մատակարարներին:
SELECT code, pc.model, speed, price, maker
from pc
INNER JOIN product ON pc.model = product.model

----Գտնել գունավոր տպիչների կոդը, մոդելները,գինն ու մատակարարին: Կարգավորել կոդերը ըստ գնի նվազման կարգով:

SELECT code, printer.model, price, maker
from printer
INNER JOIN product ON printer.model = product.model 
ORDER BY price DESC;

----Գտնել յուրաքանչյուր  մատակարարի մատակարարած համակարգիչների կոդերը, մոդելները, արագությունները, գինը: Գտնել նաև այն մոդելները, որոնց մասին ինֆորմացիա PC-ում չկա:

SELECT code, product.model, speed, price,maker 
from pc
INNER JOIN product ON product.model = pc.model
where type = 'PC'

---- Գտնել յուրաքանչյուր  մատակարարի մատակարարած համակարգիչների միջին գները: Այն մատակարարների համար, որոնց մատակարարած  համակարգիչների մասին ինֆորմացիա PC-ում չկա, միջին գին համարել 0-ն:

SELECT maker, AVG (price)
from product
INNER JOIN pc ON product.model=pc.model
where type = 'PC'
GROUP BY maker

