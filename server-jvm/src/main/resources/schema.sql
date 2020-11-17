CREATE TABLE Users
(
    userId   INT          NOT NULL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Sessions
(
    id     VARCHAR(40) NOT NULL PRIMARY KEY,
    userId INT         NOT NULL REFERENCES Users (userId)
);
