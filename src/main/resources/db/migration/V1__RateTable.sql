CREATE TABLE rate(
    id UUID PRIMARY KEY NOT NULL,
    shortName CHAR(100) NOT NULL,
    validFrom DATE,
    name CHAR(100),
    country CHAR(100),
    amount NUMERIC(30),
    valBuy NUMERIC(30),
    valSell NUMERIC(30),
    valMid NUMERIC(30),
    currBuy NUMERIC(30),
    currSell NUMERIC(30),
    currMid NUMERIC(30),
    move NUMERIC(30),
    cnbMid NUMERIC(30),
    version INTEGER
);