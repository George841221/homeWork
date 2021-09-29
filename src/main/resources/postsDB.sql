DROP DATABASE IF EXISTS postsDB;

CREATE DATABASE IF NOT EXISTS postsDB;

USE postsDB;

CREATE TABLE IF NOT EXISTS user_data(
	user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE,
    gender ENUM('male', 'female'),
    age INT DEFAULT 0,
    reg_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_email VARCHAR(50),
    user_password VARCHAR(50),
    PRIMARY KEY(user_id)
);

CREATE TABLE /*IF NOT EXISTS*/ post_data(
	post_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(50),
    post_text TEXT,
    wrote_on_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(post_id)
);

CREATE TABLE /*IF NOT EXISTS*/ comment_data(
	comment_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    commenter_name VARCHAR(50),
    comment_text TEXT,
    wrote_on_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(comment_id)
);

CREATE TABLE /*IF NOT EXISTS*/ post_controle(
	id INT NOT NULL AUTO_INCREMENT,
    name_of_user VARCHAR(50) NOT NULL ,
	id_of_posts int UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY(id),
    FOREIGN KEY(name_of_user) REFERENCES user_data(user_name),
    FOREIGN KEY(id_of_posts) REFERENCES post_data(post_id)
);

CREATE TABLE /*IF NOT EXISTS*/ comment_controle(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
	id_of_posts INT UNSIGNED,
    id_of_comments INT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY(id_of_posts) REFERENCES post_data(post_id),
    FOREIGN KEY(id_of_comments) REFERENCES comment_data(comment_id)
);