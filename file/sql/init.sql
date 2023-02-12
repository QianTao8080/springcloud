drop table if exists `order`;
CREATE TABLE `order`
(
    `n_uid`      bigint NOT NULL COMMENT 'uid',
    `n_goods_id` int    NOT NULL COMMENT '商品id',
    `n_state`    int      DEFAULT NULL COMMENT '状态',
    `n_price`    double   DEFAULT NULL COMMENT '实际价格',
    `d_create`   datetime DEFAULT NULL COMMENT '创建时间',
    `d_last`     datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`n_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

drop table if exists `user`;
CREATE TABLE `user`
(
    `n_id`    int NOT NULL COMMENT 'id',
    `n_sex`   int NOT NULL COMMENT '性别 0-女 1-男',
    `n_age`   int                                                           DEFAULT NULL COMMENT '年龄',
    `s_name`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
    `d_birth` datetime                                                      DEFAULT NULL COMMENT '生日',
    PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';
