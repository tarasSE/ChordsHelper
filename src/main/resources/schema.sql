CREATE TABLE users (
  id       SERIAL  NOT NULL,
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  email    VARCHAR NOT NULL,
  PRIMARY KEY (id)
);