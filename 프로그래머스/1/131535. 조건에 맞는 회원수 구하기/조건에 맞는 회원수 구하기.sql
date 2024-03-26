SELECT COUNT(U.USER_ID) AS USERS
FROM USER_INFO U
WHERE U.AGE BETWEEN 20 and 29
AND U.JOINED BETWEEN DATE('2021-01-01') and DATE('2021-12-31')