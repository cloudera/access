-- Table AUTHZ_PATHS_SNAPSHOT_ID for class [org.apache.sentry.provider.db.service.model.MAuthzPathsSnapshotId]
CREATE TABLE `AUTHZ_PATHS_SNAPSHOT_ID`
(
    `AUTHZ_SNAPSHOT_ID` BIGINT NOT NULL,
    CONSTRAINT `AUTHZ_SNAPSHOT_ID_PK` PRIMARY KEY (`AUTHZ_SNAPSHOT_ID`)
)ENGINE=INNODB;