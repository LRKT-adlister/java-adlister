USE adlister_db;
# SELECT * FROM categories WHERE id = 1 LIMIT 1; -R
# SELECT a.id, a.title FROM ads AS a LEFT JOIN ads_categories AS ac ON a.id = ac.ad_id JOIN categories AS c ON c.id = ac.cat_id WHERE a.title LIKE '%My%' OR c.title LIKE '%My%'
# SELECT a.id, a.title FROM ads AS a;
# SELECT id, title FROM ads WHERE title LIKE '%Third%';

TRUNCATE TABLE ads_categories;
# used to remove all records, performs the same as DELETE but w/o WHERE clause

DELETE FROM categories WHERE TRUE;
DELETE FROM ads WHERE TRUE;
DELETE FROM users WHERE TRUE;

# note to self: store hashed password for proper security in database -K
# placeholder needed for images
INSERT INTO users (id, username, email, password, profile_img)
VALUES  (1,'Leroy', 'leroy@email.com', 'leroypassword', profile_img),
        (2,'Ramon', 'ramon@email.com', 'ramonpassword', profile_img),
        (3,'Knoah', 'knoah@email.com', 'knoahpassword', profile_img),
        (4,'Trevor', 'trevor@email.com', 'trevorpassword', profile_img);

# should we add prices to our ads (LOW)
INSERT INTO ads (id, user_id, title, description, images)
VALUES (1, 1, 'My Ad', 'Description about ad here', images),
       (2, 1, 'My Second Ad', 'Description about second ad', images),
       (3, 1, 'My Third Ad', 'Description about third ad', images),
       (4, 1, 'My Fourth Ad', 'Description about fourth ad', images),
       (5, 1, 'My Fifth Ad', 'Description about fifth ad', images);

# how many categories should we make? (LOW))
INSERT INTO categories (id, title)
VALUES (1,'Anime'),
       (2, 'Tech'),
       (3, 'Gaming Consoles'),
       (4, 'Video Games'),
       (5, 'Office Supplies'),
       (6, 'DVDs'),
       (7, 'Vehicles'),
       (8, 'Books'),
       (9, 'Pets'),
       (10, 'Miscellaneous');

# still a bit confused on how to properly use this -K
INSERT INTO ads_categories (ad_id, cat_id)
VALUES  (1,1),
        (1, 2);
