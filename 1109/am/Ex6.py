import os
import xml.etree.ElementTree as ET

#현재 파일의 경로를 얻어낸다.
cpath = os.getcwd()
fname = "ex5.xml"

tree = ET.parse(cpath+"/"+fname) #xml문서를 파싱(로드)
root = tree.getroot() #root Element 얻기
print('root명:',root.tag) #root의 태그명

for child in root :
    print('\t'+child.tag+':'+child.text)
