from am.Ex1 import MyClass
# 같은 자리에 있지만 import해야한다.
ex1 = MyClass() #객체 생성1
ex2 = MyClass() #객체 생성2

ex1.setName('Michael')
print('ex1의 이름:{}'.format(ex1.getName()))

print('ex2의 이름:{}'.format(ex2.getName())) # 오류다. 먼저 setName을 호출하지 않아 
                                        # 멤버변수인 name이 만들어져 있지 않은 상태다.
