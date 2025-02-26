DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id           int          NOT NULL AUTO_INCREMENT,
    login_id     varchar(50)  NOT NULL,
    name         varchar(50)  NOT NULL,
    password     varchar(100) NOT NULL,
    phone_number varchar(50)  NOT NULL,
    created_at   timestamp    NOT NULL,
    modified_at  timestamp    NULL DEFAULT NULL,
    created_by   varchar(50)  NOT NULL,
    modified_by  varchar(50)       DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE user_address
(
    id             int         NOT NULL AUTO_INCREMENT,
    login_id       varchar(50) NOT NULL,
    street_address varchar(50) NOT NULL,
    detail_address varchar(50) NOT NULL,
    latitude       double      NOT NULL,
    longitude      double      NOT NULL,
    created_at     timestamp   NOT NULL,
    modified_at    timestamp   NULL DEFAULT NULL,
    created_by     varchar(50) NOT NULL,
    modified_by    varchar(50)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE cafe
(
    id         int         NOT NULL AUTO_INCREMENT,
    cafe_id    varchar(50) NOT NULL,
    name       varchar(50) NOT NULL,
    latitude   double      NOT NULL,
    longitude  double      NOT NULL,
    created_at timestamp   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `reservation`
(
    `id`                 int          NOT NULL,
    `user_id`            int          NOT NULL,
    `cafe_id`            int          NOT NULL,
    `address`            varchar(100) NOT NULL,
    `reservation_status` varchar(45)  NOT NULL,
    `created_at`         timestamp    NOT NULL,
    PRIMARY KEY (`id`)
)
