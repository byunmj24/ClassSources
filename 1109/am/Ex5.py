import os
from xml.etree.ElementTree import Element, dump, SubElement, ElementTree
from _operator import sub

personal = Element('personal') # personal이라는 엘리먼트 생성
# personal에 들어갈 name과 phone이라는 Element를 만들자
name = Element('name')
phone = Element('phone')

# 각 Element에 문자값 지정
name.text = '마루치'
phone.text = '010-1234-5678'

# 각 Element들 배치작업 (personal에 하위 Element들 추가)
personal.append(name)
personal.append(phone)

# 하위 Element 추가하는 다른 방법
SubElement(personal, 'addr', p_no='08654').text = '서울시'

dump(personal)

# 파일에 쓰기
cpath = os.getcwd()
f_name = "ex5.xml"          #전체 경로                                                            #xml선언문 넣기
ElementTree(personal).write(cpath + "/" + f_name, encoding='UTF-8', xml_declaration=True) #xml파일 생성하기


