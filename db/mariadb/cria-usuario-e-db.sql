
CREATE USER 'sempreufg'@'localhost' IDENTIFIED BY 'sempreufg';

GRANT USAGE ON *.* TO sempreufg@localhost IDENTIFIED BY 'sempreufg';

CREATE DATABASE sempreufg;

GRANT ALL PRIVILEGES ON sempreufg.* to sempreufg@localhost ;
