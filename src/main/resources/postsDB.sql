DROP DATABASE IF EXISTS postsDB;

CREATE DATABASE postsDB;

USE postDB;

CREATE TABLE IF NOT EXISTS user_data(
	user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50),
    gender ENUM('male', 'female'),
    age INT DEFAULT 0,
    reg_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_email VARCHAR(50),
    user_password VARCHAR(50),
    PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS post_data(
	post_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50),
    post_text TEXT,
    wrote_on_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(post_id)
);

CREATE TABLE IF NOT EXISTS comment_data(
	comment_id INT NOT NULL AUTO_INCREMENT,
    commenter_name VARCHAR(50),
    comment_text TEXT,
    wrote_on_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(comment_id)
);