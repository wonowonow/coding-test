-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I
WHERE I.INTAKE_CONDITION = 'Sick'
ORDER BY I.ANIMAL_ID