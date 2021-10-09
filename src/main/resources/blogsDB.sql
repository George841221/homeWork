DROP DATABASE IF EXISTS blogsDB;

CREATE DATABASE IF NOT EXISTS blogsDB;

USE blogsDB;

CREATE TABLE IF NOT EXISTS user_data(
	user_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE,
    gender ENUM('male', 'female'),
    user_status ENUM('admin', 'moderator', 'user'),
    age INT DEFAULT 0,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
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
    wrote_on_date DATETIME DEFAULT CURRENT_TIMESTAMP,
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
    ('Erzsi', 'female', 'admin', 25, 'erzsi@buli.hu', 'titkos2'),
    ('Nedry', 'male', 'moderator', 32, 'nedry@gmail.com', 'titkos3'),
    ('Kiss József', 'male', 'user', 41, 'kiss.jozsi@freemail.hu', 'titkos4');
    
    INSERT INTO blog_data(title, blog_text) VALUES
		('Erzsi', 'Üdvözlet a tagoknak'),
        ('Kiss József','első blogja'),
        ('Erzsi','második blogja'),
        ('Nedry','A Jurassic Park rendszerét is bedöntöttem, a facebook-é miért ne ment volna :D'),
        ('Pista Bácsi','első blogja'),
        ('Pista Bácsi','második blogja'),
        ('Nedry','második blogja'),
        ('Erzsi','harmadik blogja');
        
	INSERT INTO comment_data(commenter_name, comment_text) VALUES
		('Erzsi', 'első kommentje'),
        ('Kiss József','első kommentje'),
        ('Erzsi','második kommentje'),
        ('Nedry','első kommentje'),
        ('Pista Bácsi','első kommentje'),
        ('Pista Bácsi','második kommentje'),
        ('Nedry','második kommentje'),
        ('Erzsi','harmadik kommentje');
    