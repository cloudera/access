--Licensed to the Apache Software Foundation (ASF) under one or more
--contributor license agreements.  See the NOTICE file distributed with
--this work for additional information regarding copyright ownership.
--The ASF licenses this file to You under the Apache License, Version 2.0
--(the "License"); you may not use this file except in compliance with
--the License.  You may obtain a copy of the License at
--
--    http://www.apache.org/licenses/LICENSE-2.0
--
--Unless required by applicable law or agreed to in writing, software
--distributed under the License is distributed on an "AS IS" BASIS,
--WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--See the License for the specific language governing permissions and
--limitations under the License.

-- Table SENTRY_DB_PRIVILEGE for classes [org.apache.sentry.provider.db.service.model.MSentryPrivilege]
CREATE TABLE SENTRY_DB_PRIVILEGE
(
    DB_PRIVILEGE_ID BIGINT NOT NULL generated always as identity (start with 1),
    URI VARCHAR(4000),
    "ACTION" VARCHAR(40),
    CREATE_TIME BIGINT NOT NULL,
    DB_NAME VARCHAR(4000),
    PRIVILEGE_SCOPE VARCHAR(40),
    "SERVER_NAME" VARCHAR(4000),
    "TABLE_NAME" VARCHAR(4000),
    "COLUMN_NAME" VARCHAR(4000),
    WITH_GRANT_OPTION CHAR(1) NOT NULL
);

ALTER TABLE SENTRY_DB_PRIVILEGE ADD CONSTRAINT SENTRY_DB_PRIVILEGE_PK PRIMARY KEY (DB_PRIVILEGE_ID);

-- Table SENTRY_ROLE for classes [org.apache.sentry.provider.db.service.model.MSentryRole]
CREATE TABLE SENTRY_ROLE
(
    ROLE_ID BIGINT NOT NULL generated always as identity (start with 1),
    CREATE_TIME BIGINT NOT NULL,
    ROLE_NAME VARCHAR(128)
);

ALTER TABLE SENTRY_ROLE ADD CONSTRAINT SENTRY_ROLE_PK PRIMARY KEY (ROLE_ID);

-- Table SENTRY_GROUP for classes [org.apache.sentry.provider.db.service.model.MSentryGroup]
CREATE TABLE SENTRY_GROUP
(
    GROUP_ID BIGINT NOT NULL generated always as identity (start with 1),
    CREATE_TIME BIGINT NOT NULL,
    GROUP_NAME VARCHAR(128)
);

ALTER TABLE SENTRY_GROUP ADD CONSTRAINT SENTRY_GROUP_PK PRIMARY KEY (GROUP_ID);

-- Table SENTRY_ROLE_GROUP_MAP for join relationship
CREATE TABLE SENTRY_ROLE_GROUP_MAP
(
    GROUP_ID BIGINT NOT NULL,
    ROLE_ID BIGINT NOT NULL,
    GRANTOR_PRINCIPAL VARCHAR(128)
);

ALTER TABLE SENTRY_ROLE_GROUP_MAP ADD CONSTRAINT SENTRY_ROLE_GROUP_MAP_PK PRIMARY KEY (GROUP_ID,ROLE_ID);

-- Table SENTRY_ROLE_DB_PRIVILEGE_MAP for join relationship
CREATE TABLE SENTRY_ROLE_DB_PRIVILEGE_MAP
(
    ROLE_ID BIGINT NOT NULL,
    DB_PRIVILEGE_ID BIGINT NOT NULL,
    GRANTOR_PRINCIPAL VARCHAR(128)
);

ALTER TABLE SENTRY_ROLE_DB_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_DB_PRIVILEGE_MAP_PK PRIMARY KEY (ROLE_ID,DB_PRIVILEGE_ID);

CREATE TABLE "SENTRY_VERSION" (
  VER_ID BIGINT NOT NULL,
  SCHEMA_VERSION VARCHAR(127),
  VERSION_COMMENT VARCHAR(255)
);

ALTER TABLE SENTRY_VERSION ADD CONSTRAINT SENTRY_VERSION_PK PRIMARY KEY (VER_ID);

-- Constraints for table SENTRY_DB_PRIVILEGE for class(es) [org.apache.sentry.provider.db.service.model.MSentryPrivilege]
CREATE UNIQUE INDEX SENTRYPRIVILEGENAME ON SENTRY_DB_PRIVILEGE ("SERVER_NAME",DB_NAME,"TABLE_NAME","COLUMN_NAME",URI,"ACTION",WITH_GRANT_OPTION);


-- Constraints for table SENTRY_ROLE for class(es) [org.apache.sentry.provider.db.service.model.MSentryRole]
CREATE UNIQUE INDEX SENTRYROLENAME ON SENTRY_ROLE (ROLE_NAME);


-- Constraints for table SENTRY_GROUP for class(es) [org.apache.sentry.provider.db.service.model.MSentryGroup]
CREATE UNIQUE INDEX SENTRYGROUPNAME ON SENTRY_GROUP (GROUP_NAME);


-- Constraints for table SENTRY_ROLE_GROUP_MAP
CREATE INDEX SENTRY_ROLE_GROUP_MAP_N49 ON SENTRY_ROLE_GROUP_MAP (GROUP_ID);

CREATE INDEX SENTRY_ROLE_GROUP_MAP_N50 ON SENTRY_ROLE_GROUP_MAP (ROLE_ID);

ALTER TABLE SENTRY_ROLE_GROUP_MAP ADD CONSTRAINT SENTRY_ROLE_GROUP_MAP_FK2 FOREIGN KEY (ROLE_ID) REFERENCES SENTRY_ROLE (ROLE_ID) ;

ALTER TABLE SENTRY_ROLE_GROUP_MAP ADD CONSTRAINT SENTRY_ROLE_GROUP_MAP_FK1 FOREIGN KEY (GROUP_ID) REFERENCES SENTRY_GROUP (GROUP_ID) ;


-- Constraints for table SENTRY_ROLE_DB_PRIVILEGE_MAP
CREATE INDEX SENTRY_ROLE_DB_PRIVILEGE_MAP_N50 ON SENTRY_ROLE_DB_PRIVILEGE_MAP (ROLE_ID);

CREATE INDEX SENTRY_ROLE_DB_PRIVILEGE_MAP_N49 ON SENTRY_ROLE_DB_PRIVILEGE_MAP (DB_PRIVILEGE_ID);

ALTER TABLE SENTRY_ROLE_DB_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_DB_PRIVILEGE_MAP_FK2 FOREIGN KEY (DB_PRIVILEGE_ID) REFERENCES SENTRY_DB_PRIVILEGE (DB_PRIVILEGE_ID) ;

ALTER TABLE SENTRY_ROLE_DB_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_DB_PRIVILEGE_MAP_FK1 FOREIGN KEY (ROLE_ID) REFERENCES SENTRY_ROLE (ROLE_ID) ;

INSERT INTO SENTRY_VERSION (VER_ID, SCHEMA_VERSION, VERSION_COMMENT) VALUES (1, '1.5.0-cdh5-2', 'Sentry release version 1.5.0-cdh5-2');

-- Generic model
-- Table SENTRY_GM_PRIVILEGE for classes [org.apache.sentry.provider.db.service.model.MSentryGMPrivilege]
CREATE TABLE SENTRY_GM_PRIVILEGE
(
    GM_PRIVILEGE_ID BIGINT NOT NULL,
    "ACTION" VARCHAR(40),
    COMPONENT_NAME VARCHAR(400),
    CREATE_TIME BIGINT NOT NULL,
    WITH_GRANT_OPTION CHAR(1),
    RESOURCE_NAME_0 VARCHAR(400),
    RESOURCE_NAME_1 VARCHAR(400),
    RESOURCE_NAME_2 VARCHAR(400),
    RESOURCE_NAME_3 VARCHAR(400),
    RESOURCE_TYPE_0 VARCHAR(400),
    RESOURCE_TYPE_1 VARCHAR(400),
    RESOURCE_TYPE_2 VARCHAR(400),
    RESOURCE_TYPE_3 VARCHAR(400),
    "SCOPE" VARCHAR(40),
    SERVICE_NAME VARCHAR(400)
);
-- Primary key(GM_PRIVILEGE_ID)
ALTER TABLE SENTRY_GM_PRIVILEGE ADD CONSTRAINT SENTRY_GM_PRIVILEGE_PK PRIMARY KEY (GM_PRIVILEGE_ID);

-- Constraints for table SENTRY_GM_PRIVILEGE for class(es) [org.apache.sentry.provider.db.service.model.MSentryGMPrivilege]
CREATE UNIQUE INDEX GM_PRIVILEGE_INDEX ON SENTRY_GM_PRIVILEGE (COMPONENT_NAME,SERVICE_NAME,RESOURCE_NAME_0,RESOURCE_TYPE_0,RESOURCE_NAME_1,RESOURCE_TYPE_1,RESOURCE_NAME_2,RESOURCE_TYPE_2,RESOURCE_NAME_3,RESOURCE_TYPE_3,"ACTION",WITH_GRANT_OPTION);

-- Table SENTRY_ROLE_GM_PRIVILEGE_MAP for join relationship
CREATE TABLE SENTRY_ROLE_GM_PRIVILEGE_MAP
(
    ROLE_ID BIGINT NOT NULL,
    GM_PRIVILEGE_ID BIGINT NOT NULL
);
ALTER TABLE SENTRY_ROLE_GM_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_GM_PRIVILEGE_MAP_PK PRIMARY KEY (ROLE_ID,GM_PRIVILEGE_ID);

-- Constraints for table SENTRY_ROLE_GM_PRIVILEGE_MAP
CREATE INDEX SENTRY_ROLE_GM_PRIVILEGE_MAP_N50 ON SENTRY_ROLE_GM_PRIVILEGE_MAP (ROLE_ID);

CREATE INDEX SENTRY_ROLE_GM_PRIVILEGE_MAP_N49 ON SENTRY_ROLE_GM_PRIVILEGE_MAP (GM_PRIVILEGE_ID);

ALTER TABLE SENTRY_ROLE_GM_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_GM_PRIVILEGE_MAP_FK2 FOREIGN KEY (GM_PRIVILEGE_ID) REFERENCES SENTRY_GM_PRIVILEGE (GM_PRIVILEGE_ID);

ALTER TABLE SENTRY_ROLE_GM_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_ROLE_GM_PRIVILEGE_MAP_FK1 FOREIGN KEY (ROLE_ID) REFERENCES SENTRY_ROLE (ROLE_ID);

-- Table AUTHZ_PATHS_SNAPSHOT_ID for class [org.apache.sentry.provider.db.service.model.MAuthzPathsSnapshotId]
CREATE TABLE AUTHZ_PATHS_SNAPSHOT_ID
(
    AUTHZ_SNAPSHOT_ID BIGINT NOT NULL
);

-- Constraints for table AUTHZ_PATHS_SNAPSHOT_ID for class [org.apache.sentry.provider.db.service.model.MAuthzPathsSnapshotId]
ALTER TABLE AUTHZ_PATHS_SNAPSHOT_ID ADD CONSTRAINT AUTHZ_SNAPSHOT_ID_PK PRIMARY KEY (AUTHZ_SNAPSHOT_ID);

-- Table AUTHZ_PATHS_MAPPING for classes [org.apache.sentry.provider.db.service.model.MAuthzPathsMapping]
CREATE TABLE AUTHZ_PATHS_MAPPING(
    AUTHZ_OBJ_ID BIGINT NOT NULL generated always as identity (start with 1),
    AUTHZ_OBJ_NAME VARCHAR(384) NOT NULL,
    CREATE_TIME_MS BIGINT NOT NULL,
    AUTHZ_SNAPSHOT_ID BIGINT NOT NULL
);

ALTER TABLE AUTHZ_PATHS_MAPPING ADD CONSTRAINT AUTHZ_PATHSCO7K_PK PRIMARY KEY (AUTHZ_OBJ_ID);

-- Constraints for table AUTHZ_PATHS_MAPPING for class(es) [org.apache.sentry.provider.db.service.model.MAuthzPathsMapping]
CREATE UNIQUE INDEX AUTHZOBJNAMEID ON AUTHZ_PATHS_MAPPING (AUTHZ_OBJ_NAME, AUTHZ_SNAPSHOT_ID);

-- Table `AUTHZ_PATH` for classes [org.apache.sentry.provider.db.service.model.MPath]
CREATE TABLE AUTHZ_PATH
 (
    PATH_ID BIGINT NOT NULL,
    PATH_NAME VARCHAR(4000),
    AUTHZ_OBJ_ID BIGINT
);

-- Constraints for table `AUTHZ_PATH`
ALTER TABLE AUTHZ_PATH
  ADD CONSTRAINT AUTHZ_PATH_PK PRIMARY KEY (PATH_ID);

ALTER TABLE AUTHZ_PATH
  ADD CONSTRAINT AUTHZ_PATH_FK
  FOREIGN KEY (AUTHZ_OBJ_ID) REFERENCES AUTHZ_PATHS_MAPPING (AUTHZ_OBJ_ID);

CREATE INDEX AUTHZ_PATH_FK_IDX ON AUTHZ_PATH (AUTHZ_OBJ_ID);

-- Table SENTRY_PERM_CHANGE for classes [org.apache.sentry.provider.db.service.model.MSentryPermChange]
CREATE TABLE SENTRY_PERM_CHANGE
(
    CHANGE_ID bigint NOT NULL,
    CREATE_TIME_MS bigint NOT NULL,
    PERM_CHANGE VARCHAR(4000) NOT NULL
);

ALTER TABLE SENTRY_PERM_CHANGE ADD CONSTRAINT SENTRY_PERM_CHANGE_PK PRIMARY KEY (CHANGE_ID);

-- Table SENTRY_PATH_CHANGE for classes [org.apache.sentry.provider.db.service.model.MSentryPathChange]
CREATE TABLE SENTRY_PATH_CHANGE
(
    CHANGE_ID bigint NOT NULL,
    NOTIFICATION_HASH char(40) NOT NULL,
    CREATE_TIME_MS bigint NOT NULL,
    PATH_CHANGE CLOB NOT NULL
);

-- Constraints for table SENTRY_PATH_CHANGE for class [org.apache.sentry.provider.db.service.model.MSentryPathChange]
ALTER TABLE SENTRY_PATH_CHANGE ADD CONSTRAINT SENTRY_PATH_CHANGE_PK PRIMARY KEY (CHANGE_ID);
CREATE UNIQUE INDEX NOTIFICATION_HASH_INDEX ON SENTRY_PATH_CHANGE (NOTIFICATION_HASH);

-- Table SENTRY_HMS_NOTIFICATION_ID for classes [org.apache.sentry.provider.db.service.model.MSentryHmsNotification]
CREATE TABLE SENTRY_HMS_NOTIFICATION_ID
(
    NOTIFICATION_ID bigint NOT NULL
);

CREATE INDEX SENTRY_HMS_NOTIF_ID_INDEX ON SENTRY_HMS_NOTIFICATION_ID (NOTIFICATION_ID);

-- Table SENTRY_USER
CREATE TABLE SENTRY_USER
(
    USER_ID BIGINT NOT NULL generated always as identity (start with 1),
    CREATE_TIME BIGINT NOT NULL,
    USER_NAME VARCHAR(128)
);

ALTER TABLE SENTRY_USER ADD CONSTRAINT SENTRY_USER_PK PRIMARY KEY (USER_ID);

CREATE UNIQUE INDEX SENTRYUSERNAME ON SENTRY_USER (USER_NAME);

-- Table SENTRY_USER_DB_PRIVILEGE_MAP for join relationship
CREATE TABLE SENTRY_USER_DB_PRIVILEGE_MAP
(
    USER_ID BIGINT NOT NULL,
    DB_PRIVILEGE_ID BIGINT NOT NULL,
    GRANTOR_PRINCIPAL VARCHAR(128)
);

-- Constraints for table SENTRY_USER_DB_PRIVILEGE_MAP
ALTER TABLE SENTRY_USER_DB_PRIVILEGE_MAP ADD CONSTRAINT SENTRY_USR_DB_PRV_MAP_PK PRIMARY KEY (USER_ID,DB_PRIVILEGE_ID);

CREATE INDEX SENTRY_USER_DB_PRIVILEGE_MAP_N50 ON SENTRY_USER_DB_PRIVILEGE_MAP (USER_ID);

CREATE INDEX SENTRY_USER_DB_PRIVILEGE_MAP_N49 ON SENTRY_USER_DB_PRIVILEGE_MAP (DB_PRIVILEGE_ID);

ALTER TABLE SENTRY_USER_DB_PRIVILEGE_MAP ADD CONSTRAINT SEN_USR_DB_PRV_MAP_DB_PRV_FK FOREIGN KEY (DB_PRIVILEGE_ID) REFERENCES SENTRY_DB_PRIVILEGE (DB_PRIVILEGE_ID) ;

ALTER TABLE SENTRY_USER_DB_PRIVILEGE_MAP ADD CONSTRAINT SEN_USR_DB_PRV_MAP_SN_USR_FK FOREIGN KEY (USER_ID) REFERENCES SENTRY_USER (USER_ID) ;
