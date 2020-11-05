'''
Created on 2020. 11. 5

@author: g
    SET : 합집합, 교집합, 차집합
    자바와 같이 중복을 허용하지 않는다.
'''
icecream1 = {'체리쥬빌레', '엄마는외계인', '쿠키앤크림', '뉴욕치즈케익', '메로나', '메로나'}
# SET은 중복을 허용하지 않고 순서도 정해져있지않다.
print('icecream1의 길이:{},{}'.format(len(icecream1), icecream1))

res = '슈팅스타' in icecream1 #'슈팅스타'가 icecream1에 들어있으면 True! 아니면 False!
print("'슈팅스타' in icecream1 :", res)

res = '슈팅스타' not in icecream1 #'슈팅스타'가 icecream1에 없으면 True!
print("'슈팅스타' in icecream1 :", res)

t1 = set('1234567')
t2 = set('4567890') #이렇게 해도 SET 구조를 만들 수 있다.

print("t1 :", t1)
print("t2 :", t2)

# 집합연산자(논리연산자)
res1 = t1 & t2 # 두 SET 모두가 가지는 교집합 : 4,5,6,7
print("t1 & t2 :", res1)

res2 = t1 | t2 # 두 SET의 합집합 : 0,1,2,3,4,5,6,7,8,9
print("t1 | t2 :", res2)

res3 = t1 - t2 # t1에서 t2의 차집합 : 1,2,3
print("t1 - t2 :", res3)
