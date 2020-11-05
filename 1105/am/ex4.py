'''
Created on 2020. 11. 5

@author: g
    자료구조
    - Tuple : (값1, 값2, ... , 값n) :: 리스트와 같지만 읽기 전용(한번 생성하면 변경불가) 
    - List : [값1, 값2, ... , 값n] :: 배열과 같고 순서를 가진다.
    - Set : {값1, 값2, ... , 값n} :: 리스트와 유사하지만 교집합(중복 불가)
    - Dictionary(Dict) : (키1=값1, 키2=값2, ... , 키n=값n) :: 자바의 Map과 같다.
'''
ar1 = [1,2,3,4,5]
ar2 = [10, 3.14, 'TEST'] #자료형에 관계없이 다 받는다.
print("ar1={}".format(ar1))
print("ar2={}".format(ar2))

ar3 = ar1 + ar2 #배열 합치기
print("ar3={}".format(ar3))

str = '들음에 있어 믿음이 생기고, 그 믿음에서 행동이 뒤따른다.'
ar4 = str.split(' ') #공백을 기준으로 문자열을 쪼개어 배열에 담는다.
print("ar4={}".format(ar4))

