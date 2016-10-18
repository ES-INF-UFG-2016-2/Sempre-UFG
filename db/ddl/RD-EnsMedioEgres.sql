
CREATE TABLE LocalizGeograf
(
cidade TEXT NOT NULL,
unid_federativa TEXT NOT NULL,
pais TEXT NOT NULL,
sigla_unid_federativa TEXT NOT NULL,
latitude FLOAT NOT NULL,
longitude FLOAT NOT NULL,
UNIQUE (cidade, unid_federativa),
id_localizacao BIGINT PRIMARY KEY
);

CREATE TABLE EnsMedioEgres
(
id_egresso BIGINT references Egresso NOT NULL,
id_localizacao BIGINT references LocalizGeograf NOT NULL,
nome_iem TEXT PRIMARY KEY NOT NULL,
tipo_iem TEXT CHECK (tipo_iem='Federal' OR tipo_iem='Estadual' OR tipo_iem='Municipal' OR tipo_iem='Particular') NOT NULL
);

CREATE TABLE HistEnsMedio
(
id_egresso BIGINT references Egresso NOT NULL,
id_EnsMedio TEXT references EnsMedioEgres NOT NULL,
mes_inicio INTEGER NOT NULL,
ano_inicio INTEGER NOT NULL,
mes_fim INTEGER NOT NULL,
mano_fim INTEGER NOT NULL
);
