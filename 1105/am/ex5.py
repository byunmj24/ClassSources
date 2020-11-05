'''
Created on 2020. 11. 5

@author: g
'''
ar1 = [10, 20, 30, 3.3, 'MJ']

var1 = ar1[3]
print("ar1[3]={}".format(var1))

#ar1의 마지막 요소의 값을 추출하여 출력하시오!
var2 = ar1[-1]
var2 = ar1[len(ar1)-1] #len(ar1)은 배열(ar1)의 길이 : 5
print("ar1[len(ar1)-1]={}".format(var2))

# 중요! len(리스트) : 리스트의 길이가 정수로 반환된다.