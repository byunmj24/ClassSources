
# 파일처리에서 모드를 구별하여 사용해야 함
# mode : 'r' --> 읽기, 'w' --> 쓰기, 'a' --> 추가, 'rb' --> 바이너리로 읽기(데이터 안정성 높아진대)

fs = open('Ex1.py','r', encoding='UTF-8') # r : read, 파일과 연결 -- encoding 유무? 확인

content = fs.read() # 파일로부터 모든 데이터를 읽어서 변수 content에 저장
fs.close() # 파일과 연결된 객체 닫기

print(content)
print('----------------------------------------------------')
fs = open('Ex1.py','r', encoding='UTF-8')

while True:
    content = fs.readline()
    if content != '': # 입력한 엔터 및 들여쓰기는 공백으로 인식하지 않는다.
        print(content, end="") # 화면에 출력하고, 마지막에 엔터값을 공백으로 대체
    else: # 읽은 데이터가 공백일 경우
        break
fs.close()
print('파일의 끝')
