'''
Created on 2020. 11. 9

@author: g
'''

class MyClass:
    
    def __init__(self): #자바의 생성자와 같다.
        self.name = '' #멤버변수 선언시에 기본값을 넣어주어야만한다.
        
    def __del__(self): #소멸자 - 객체가 메모리 상에서 삭제될 때 자동 호출됨
        self.name = ''
        
    # def : 정의, 선언
    def setName(self, n): #멤버메서드 정의, 메서드 정의 시 반드시 첫번째 인자는
                            #현재 객체의 레퍼런스인 self를 넣어주어야 한다.    
        self.name = n #멤버변수 정의와 초기화, self -> this, 자바에서 setter를 만드는 형태
        #메서드 안에서 멤버변수 정의가 가능하다.
        
    def getName(self): #자바의 getter 형태
        return self.name
    
