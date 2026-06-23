CREATE TABLE transfers (
  id BIGSERIAL PRIMARY KEY,
  source_account_id BIGINT NOT NULL,
  target_account_id BIGINT NOT NULL,
  amount NUMERIC(19, 2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  create_dt TIMESTAMP NOT NULL,

  CONSTRAINT fk_transfer_source_account
      FOREIGN KEY (source_account_id)
          REFERENCES account(id),

  CONSTRAINT fk_transfer_target_account
      FOREIGN KEY (target_account_id)
          REFERENCES account(id)
);