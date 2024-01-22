-- Create 'users' table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role ENUM('USER', 'ADMIN')
);

-- Create 'stories' table
CREATE TABLE stories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    quote VARCHAR(255),
    writing TEXT,
    user_id INT,
    prompt_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (prompt_id) REFERENCES prompts(id)
);

-- Create 'prompts' table
CREATE TABLE prompts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    quote VARCHAR(255)
);

-- Create 'modes' table
CREATE TABLE modes (
    mode_id INT PRIMARY KEY AUTO_INCREMENT,
    mode_name VARCHAR(255)
);


INSERT INTO prompts (date, quote)
VALUES
  (CURDATE(), 'Write a story about a poet who kills his plant.'),
  (CURDATE() + INTERVAL 1 DAY, 'Write a story about a character who discovers a mysterious portal in their backyard.'),
  (CURDATE() + INTERVAL 2 DAY, 'Describe a world where dreams become reality, but with unintended consequences.'),
  (CURDATE() + INTERVAL 3 DAY, 'Explore the day in the life of a sentient robot experiencing human emotions for the first time.'),
  (CURDATE() + INTERVAL 4 DAY, 'Craft a narrative set in a future society where memories can be bought and sold.'),
  (CURDATE() + INTERVAL 5 DAY, 'Create a story around a group of people with the ability to manipulate time, but at a cost.'),
  (CURDATE() + INTERVAL 6 DAY, 'Imagine a world where everyone has a unique superpower, except for the protagonist.'),
  (CURDATE() + INTERVAL 7 DAY, 'Write about a character who can communicate with animals during a mysterious celestial event.'),
  (CURDATE() + INTERVAL 8 DAY, 'Describe a cityscape where buildings have personalities and histories of their own.'),
  (CURDATE() + INTERVAL 9 DAY, 'Craft a story involving a character who wakes up with no memory in an unfamiliar, fantastical land.'),
  (CURDATE() + INTERVAL 10 DAY, 'Explore the consequences of a society where lies and deceit are physically visible.');