USE adlister_db;
# SELECT * FROM categories WHERE id = 1 LIMIT 1;

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
       (2, 1, 'My Second Ad', 'Description about second ad', images);

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

# still a bit confused on how to properly use this -k
INSERT INTO ads_categories (ad_id, cat_id)
VALUES  (1,1),
        (1, 2);
