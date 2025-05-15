CREATE TABLE paises (
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        capital VARCHAR(100) NOT NULL,
                        continente VARCHAR(50) NOT NULL,
                        area_km2 DECIMAL(15,2) NOT NULL,
                        populacao BIGINT NOT NULL,
                        data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserir dados iniciais
INSERT INTO paises (nome, capital, continente, area_km2, populacao) VALUES
                                                                        ('Brasil', 'Brasília', 'América do Sul', 8515767.049, 214300000),
                                                                        ('Estados Unidos', 'Washington D.C.', 'América do Norte', 9833517.00, 331900000),
                                                                        ('Japão', 'Tóquio', 'Ásia', 377975.00, 125700000),
                                                                        ('Alemanha', 'Berlim', 'Europa', 357022.00, 83200000),
                                                                        ('África do Sul', 'Pretória', 'África', 1221037.00, 59300000);