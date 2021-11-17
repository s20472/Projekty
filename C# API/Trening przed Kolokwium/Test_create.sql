-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-05-13 06:17:43.712

-- tables
-- Table: Mieszkaniec
CREATE TABLE Mieszkaniec (
    IDclient int  NOT NULL,
    Imie varchar(20)  NOT NULL,
    Nazwisko varchar(20)  NOT NULL,
    DataUrodzenia datetime  NOT NULL,
    CONSTRAINT Mieszkaniec_pk PRIMARY KEY  (IDclient)
);

-- Table: MieszkaniecPomieszczenie
CREATE TABLE MieszkaniecPomieszczenie (
    Mieszkaniec_IDclient int  NOT NULL,
    Pomieszczenie_IDpomieszczenie int  NOT NULL,
    DataWynajecia datetime  NOT NULL,
    CONSTRAINT MieszkaniecPomieszczenie_pk PRIMARY KEY  (Mieszkaniec_IDclient,Pomieszczenie_IDpomieszczenie)
);

-- Table: Pomieszczenie
CREATE TABLE Pomieszczenie (
    IDpomieszczenie int  NOT NULL,
    MaksOsob int  NOT NULL,
    CONSTRAINT Pomieszczenie_pk PRIMARY KEY  (IDpomieszczenie)
);

-- End of file.

