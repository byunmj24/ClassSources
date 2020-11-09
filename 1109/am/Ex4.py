import random
from copyreg import _slotnames

r = range(1, 11) #1부터 10까지의 범위
value = random.choice(r) #range에서 난수가 하나 발생하여 value에 저장!
print('random.choice(range(1,11)):', value)
print('--------------------------------------')
# 1부터 45까지의 난수를 6개만 발생시켜 출력하는 예제를 작성해보자
r = range(1, 46) # 1~45까지의 범위 준비 
lotto = set() # 중복되지 않는 자료 구조 준비(범위에서 하나씩 난수 발생하여 저장될 곳)

while True: # lotto의 크기가 6이 될 때까지 무한 반복한다.
    value = random.choice(r)
    lotto.add(value) # 중복된 값은 count 되지 않는다.
    if len(lotto) == 6:
        break
    
print('lotto:',lotto)