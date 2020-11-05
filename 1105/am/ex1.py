'''
Created on 2020. 11. 5

@author: g
    산술연산자(+, -, *, /, //, %)

'''
a = 100
b = 32
print(a+b) #a가 기억하는 100과 b가 기억하는 32를 더한 값을 출력

c = a*b
print(c) #3200

c= a/b #3.125
print(c)

print("a/b=%f"%(a/b)) #3.125000
# 소수점 이하를 제어하여 출력하고자 할 때
# %.2f 를 쓰면 소수점 두번째 자리까지 나온다.
print("a/b=%.2f"%(a/b))
print("a/b=%.4f"%(a/b))

c = a%b #4
print(c)
