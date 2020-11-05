'''
Created on 2020. 11. 5

@author: g
    Tuple : List와 비슷하지만 다른 점을 말하자면
    List는 요소의 추가와 삭제가 자유로운 가변적 길이를 가졌지만
    Tuple은 immutable(불변) 즉, 읽기 전용으로 사용된다.하지만 속도의 이점이 있다.
'''
list1 = [10, 20, 50, 100, 150]
tuple1 = (100, 'tuple', 200)

list1[1] = 500 #요소의 값을 변경
list1.append(200) #요소 추가

print('list1={}'.format(list1))

#tuple1[1] = "TEST" #오류!

print('tuple1={}'.format(tuple1))
print('tuple1.count(200)={}'.format(tuple1.count(200))) #tuple1 안에서 200의 갯수

print('tuple1.index("tuple")={}'.format(tuple1.index("tuple"))) #tuple1 안에서 "tuple"이 있는 인덱스 번호

list2 = list1 #list1의 주소 복사
print('list2={}'.format(list2))
chk = list2 is list1 #주소 비교 : 같으면 True, 다르면 False
print('list2 is list1={}'.format(chk))

list2 = list1[:] #list1의 내용 복사 > list[a:b] :: 인덱스번호 a부터 b까지~ [:]은 처음부터 끝까지!
print('list2={}'.format(list2))
chk = list2 is list1 #주소 비교 : 같으면 True, 다르면 False
print('list2 is list1={}'.format(chk))
