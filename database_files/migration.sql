CREATE DATABASE IF NOT EXISTS adlister_db DEFAULT CHARACTER SET utf8mb4;

USE adlister_db;

# SHOW TABLES;

# DESCRIBE users;

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(240) NOT NULL,
    profile_img LONGBLOB,
    PRIMARY KEY (id),
    UNIQUE (username, email)
);

# DESCRIBE ads;

CREATE TABLE IF NOT EXISTS ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    images LONGBLOB,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

# DESCRIBE categories;

CREATE TABLE IF NOT EXISTS categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
);

# DESCRIBE ads_categories;

CREATE TABLE IF NOT EXISTS ads_categories (
    ad_id INTEGER UNSIGNED NOT NULL,
    cat_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads(id),
    FOREIGN KEY (cat_id) REFERENCES categories(id)
);
