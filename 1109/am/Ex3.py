import os

cpath = os.getcwd() # 현재 소스파일이 있는 위치
print("현재 위치:", cpath)

#현재 파일이 위치하고 있는 폴더 내에 있는 모든 파일들을 얻어내자.
sub_list = os.listdir(cpath)

#리스트로 받은 하위 요소들을 반복문으로 출력
for f in sub_list:
    print(f)
