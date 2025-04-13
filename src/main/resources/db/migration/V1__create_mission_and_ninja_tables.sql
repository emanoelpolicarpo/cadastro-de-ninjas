CREATE TABLE mission (
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    difficulty VARCHAR(50) NOT NULL
);

CREATE TABLE ninja (
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    img_url VARCHAR(255),
    rank VARCHAR(50)
);
