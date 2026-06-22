CREATE TABLE account (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         balance NUMERIC(19, 2) NOT NULL
);

INSERT INTO account (name, email, balance) VALUES
                                               ('João Silva', 'joao.silva@email.com', 1500.00),
                                               ('Maria Souza', 'maria.souza@email.com', 2750.50),
                                               ('Pedro Santos', 'pedro.santos@email.com', 890.75),
                                               ('Ana Oliveira', 'ana.oliveira@email.com', 4200.00),
                                               ('Carlos Pereira', 'carlos.pereira@email.com', 125.30),
                                               ('Fernanda Lima', 'fernanda.lima@email.com', 9876.45),
                                               ('Ricardo Gomes', 'ricardo.gomes@email.com', 3200.00),
                                               ('Juliana Costa', 'juliana.costa@email.com', 560.90),
                                               ('Bruno Almeida', 'bruno.almeida@email.com', 7450.10),
                                               ('Camila Rocha', 'camila.rocha@email.com', 1899.99);