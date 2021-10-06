DROP DATABASE IF EXISTS blogsDB;

CREATE DATABASE IF NOT EXISTS blogsDB;

USE blogsDB;

CREATE TABLE IF NOT EXISTS user_data(
	user_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE,
    gender ENUM('male', 'female'),
    user_status ENUM('admin', 'moderator', 'user'),
    age INT DEFAULT 0,
    reg_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_email VARCHAR(50),
    user_password VARCHAR(50),
    PRIMARY KEY(user_id)
);

CREATE TABLE /*IF NOT EXISTS*/ blog_data(
	blog_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(50),
    blog_text TEXT,
    wrote_on_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(blog_id)
);

CREATE TABLE /*IF NOT EXISTS*/ comment_data(
	comment_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    commenter_name VARCHAR(50),
    comment_text TEXT,
    wrote_on_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(comment_id)
);

CREATE TABLE /*IF NOT EXISTS*/ blog_controle(
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL ,
	id_of_blogs int UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY(id),
    FOREIGN KEY(title) REFERENCES user_data(user_name),
    FOREIGN KEY(id_of_blogs) REFERENCES blog_data(blog_id)
);

CREATE TABLE /*IF NOT EXISTS*/ comment_controle(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
	id_of_blogs INT UNSIGNED,
    id_of_comments INT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY(id_of_blogs) REFERENCES blog_data(blog_id),
    FOREIGN KEY(id_of_comments) REFERENCES comment_data(comment_id)
);

INSERT INTO user_data(user_name, gender, user_status, age, user_email, user_password) VALUES
	('Pista Bácsi', 'male','user', 58, 'pistabá@valami.hu', 'titkos'),
    ('Erzsi','female', 'admin', 25, 'erzsi@buli.hu', 'titkos2');
    
SELECT* FROM user_data;