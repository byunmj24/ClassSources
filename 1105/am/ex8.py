'''
Created on 2020. 11. 5

@author: g
    dict : 키와 값이 한 쌍이 되어 저장되는 구조(자바의 Map)
'''
d1 = {'k1':100, 2:200} #딕셔너리 생성 :: 키가 반드시 문자열일 필요는 없다.
print('d1 :',d1, type(d1))

d1[3] = 300 #3이라는 키에 값이 300인 원소 추가
d1[2] = 400 #2라는 키의 값을 400으로 변경
print('d1 :',d1)

del d1[2] #키가 2인 요소를 삭제!
print('d1 :',d1)

v1 = d1.get('k1')
print('d1.get("k1") :', v1)

#딕셔너리에 저장된 모든 키를 얻어낸다.
keys = d1.keys()
print('d1.keys() :', keys)
print("type(keys) :", type(keys))

#딕셔너리에 저장된 모든 값을 얻어낸다.
values = d1.values()
print('d1.values() :', values)
print('type(values) :', type(values))

key_list = list(keys) #dict_keys인 keys를 List로 변환
print("key_list :", key_list)
print("type(key_list) :", type(key_list))

v2 = d1.get(3) #3은 키값이다.
print("d1.get(3):{}".format(v2))

v2 = d1.get('ky2', 'empty')
print("d1.get('ky2'):{}".format(v2))

d1.clear() #요소들 삭제
print("d1:{}".format(d1))

#변경가능 : list, set, dict
#변경불가능 : int, float, bool, string, tuple -> 변수를 다시 지정하면 변수가 새로 할당되어서 지정해준다.

var1 = 100
var2 = 200

var3 = var1
check = var1 is var3
print("var1 is var3 :", check)
print("id(var1) :", id(var1)) #할당받은 메모리 ID값 받기
print("id(var3) :", id(var3))

var1 = 400
check = var1 is var3
print("var1 is var3 :", check)

print("id(var1) :", id(var1))
print("id(var2) :", id(var2))
print("id(var3) :", id(var3))

