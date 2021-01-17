


select * from t_account_balance;

select * from t_account_water order by ID desc;

select count(*) from t_account_water;

select count(*),max(UPDATE_TIME),min(UPDATE_TIME) from t_account_water;

-- 8 线程    每个循环10w
-- 带版本    612838	2021-01-16 19:01:36	2021-01-16 19:17:40	635.7241
-- 不带版本  623663	2021-01-16 20:02:12	2021-01-16 20:17:45	668.4491


-- 发生额
-- 不卡金额  800000	2021-01-16 21:44:53	2021-01-16 21:50:38	2318.8406
-- 不卡金额  800000	2021-01-17 11:51:47	2021-01-17 11:57:17	2424.2424



-- 100 线程  每个循环1w
-- 不带版本  616695	2021-01-16 20:20:48	2021-01-16 20:35:56	679.1795

-- 100 线程  每个循环100w
-- 不卡金额  1823016	2021-01-16 21:57:41	2021-01-16 22:11:18	2231.3537

select count(*) as allCount,
       min(UPDATE_TIME) as startTime,
       max(UPDATE_TIME) as endTime,
       count(*)/( TIME_TO_SEC(max(UPDATE_TIME))- TIME_TO_SEC(min(UPDATE_TIME)) ) as perSecCount
from t_account_water where ATOM_TYPE='ADD';

-- 799999	2021-01-17 12:20:02	2021-01-17 12:25:54	2272.7244
select count(*) as allCount,
       min(UPDATE_TIME) as startTime,
       max(UPDATE_TIME) as endTime,
       count(*)/( TIME_TO_SEC(max(UPDATE_TIME))- TIME_TO_SEC(min(UPDATE_TIME)) ) as perSecCount
from t_account_water where ATOM_TYPE='SUB';

update t_account_balance set BALANCE=0 ,VERSION=0 where id=2;

truncate t_account_water;



-- 构造扣减

INSERT INTO t_account_balance (ID, ACCOUNT_ID, PRODUCT_ID, FROZ, BALANCE, VERSION, REMARK, CREATE_TIME, UPDATE_TIME)
VALUES (2, 1, 1, 0, 800000, 0, '初始化账户', '2021-01-16 15:51:15', '2021-01-17 11:57:17');



-- 悲观锁 800000	2021-01-17 13:52:15	2021-01-17 13:59:31	1834.8624
select count(*) as allCount,
       min(UPDATE_TIME) as startTime,
       max(UPDATE_TIME) as endTime,
       count(*)/( TIME_TO_SEC(max(UPDATE_TIME))- TIME_TO_SEC(min(UPDATE_TIME)) ) as perSecCount
from t_account_water where ATOM_TYPE='ADD' and ACCOUNT_ID=2 ;


select count(*) as allCount,
       min(UPDATE_TIME) as startTime,
       max(UPDATE_TIME) as endTime,
       count(*)/( TIME_TO_SEC(max(UPDATE_TIME))- TIME_TO_SEC(min(UPDATE_TIME)) ) as perSecCount
from t_account_water where ATOM_TYPE='SUB' and ACCOUNT_ID=2 ;