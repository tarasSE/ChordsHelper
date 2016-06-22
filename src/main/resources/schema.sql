CREATE TABLE currencies (
  id         SERIAL  NOT NULL,
  name       VARCHAR NOT NULL,
  short_name VARCHAR NOT NULL,
  code       INT     NOT NULL,
  symbol     CHAR    NOT NULL,
  PRIMARY KEY (id)
);
