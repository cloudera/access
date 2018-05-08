CREATE TABLE "SENTRY_USER" (
  "USER_ID" NUMBER  NOT NULL,
  "USER_NAME" VARCHAR2(128) NOT NULL,
  "CREATE_TIME" NUMBER NOT NULL
);

ALTER TABLE "SENTRY_USER"
  ADD CONSTRAINT "SENTRY_USER_PK" PRIMARY KEY ("USER_ID");

ALTER TABLE "SENTRY_USER"
ADD CONSTRAINT "SENTRY_USER_USER_NAME_UNIQUE" UNIQUE ("USER_NAME");

CREATE TABLE "SENTRY_USER_DB_PRIVILEGE_MAP" (
  "USER_ID" NUMBER NOT NULL,
  "DB_PRIVILEGE_ID" NUMBER NOT NULL,
  "GRANTOR_PRINCIPAL" VARCHAR2(128)
);

ALTER TABLE "SENTRY_USER_DB_PRIVILEGE_MAP"
  ADD CONSTRAINT "SEN_USER_PRIV_MAP_PK" PRIMARY KEY ("USER_ID","DB_PRIVILEGE_ID");

ALTER TABLE "SENTRY_USER_DB_PRIVILEGE_MAP"
  ADD CONSTRAINT "SEN_USER_DB_PRV_MAP_SN_USER_FK"
  FOREIGN KEY ("USER_ID") REFERENCES "SENTRY_USER"("USER_ID") INITIALLY DEFERRED;

ALTER TABLE "SENTRY_USER_DB_PRIVILEGE_MAP"
  ADD CONSTRAINT "SEN_USER_DB_PRV_MAP_SN_DB_PRV_FK"
  FOREIGN KEY ("DB_PRIVILEGE_ID") REFERENCES "SENTRY_DB_PRIVILEGE"("DB_PRIVILEGE_ID") INITIALLY DEFERRED;

CREATE INDEX "SEN_USR_DB_PRV_MAP_USR_FK_IDX" ON "SENTRY_USER_DB_PRIVILEGE_MAP" ("USER_ID");

CREATE INDEX "SEN_USR_DB_PRV_MAP_PRV_FK_IDX" ON "SENTRY_USER_DB_PRIVILEGE_MAP" ("DB_PRIVILEGE_ID");