CREATE DATABASE `vmconfdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE TASK_LOG (
  TASK_LOG_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  TASK_STATUS INTEGER(4) UNSIGNED NOT NULL,
  LOG_DATA LONGTEXT NULL,
  ERROR_MESSAGE BLOB  NULL,
  CREATION_DATE TIMESTAMP NOT NULL,
  PRIMARY KEY(TASK_LOG_ID)
  ) AUTO_INCREMENT=1000000001;